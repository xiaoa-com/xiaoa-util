package com.xiaoa.utils.image;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;

/**
 * @ClassName QRCodeUtil
 * @Description 二维码生成与解析工具类
 * @Author wanmeng
 * @Date 2019/3/14 19:42
 * @Version 1.0
 **/
public class QRCodeUtil {
    private static final Map<EncodeHintType, Object> ENCODE_HINTS = new EnumMap<EncodeHintType, Object>(EncodeHintType.class) {
        private static final long serialVersionUID = 1L;

        {
            // 编码格式(utf-8等单词必须小写!!)
            put(EncodeHintType.CHARACTER_SET, "utf-8");
            // 容错级别(L--7%,M--15%,Q--25%,H--30%)
            put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);
            // 边框宽度
            put(EncodeHintType.MARGIN, 1);
        }
    };

    private static final Map<DecodeHintType, Object> DECODE_HINT = new EnumMap<DecodeHintType, Object>(DecodeHintType.class) {
        private static final long serialVersionUID = 1L;

        {
            // 编码格式(utf-8等单词必须小写!!)
            put(DecodeHintType.CHARACTER_SET, "utf-8");
        }
    };

    private QRCodeUtil() {
    }


    /**
     * 生成二维码到指定目录
     *
     * @param content   内容
     * @param width     宽度
     * @param height    高度
     * @param imagePath 二维码图片存放路径
     * @param logoPath  二维码logo路径
     * @return
     */
    public static boolean encode(String content, int width, int height, String imagePath, String logoPath) {
        String imageType = FilenameUtils.getExtension(imagePath);
        if (!StringUtils.equals(imageType, "png")) {
            throw new IllegalArgumentException("image must be png");
        }

        try {
            BitMatrix matrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, ENCODE_HINTS);
            File imageFile = new File(imagePath);
            MatrixToImageWriter.writeToFile(matrix, imageType, imageFile, new MatrixToImageConfig(0xFF000001, 0xFFFFFFFF));
            if (!StringUtils.isBlank(logoPath)) {
                File logoFile = new File(logoPath);
                Thumbnails.of(logoFile).size(width / 5, height / 5).keepAspectRatio(true).toFile(logoFile);
                Thumbnails.of(imageFile).size(width, height).watermark(Positions.CENTER, ImageIO.read(logoFile), 1).toFile(imageFile);
            }
            return true;
        } catch (WriterException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


    /**
     * 解析二维码,返回内容
     *
     * @param imagePath
     * @return
     */
    public static String decode(String imagePath) {
        try {
            BufferedImage bi = ImageIO.read(new File(imagePath));
            LuminanceSource source = new BufferedImageLuminanceSource(bi);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Result result = new MultiFormatReader().decode(bitmap, DECODE_HINT);
            return result.getText();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
