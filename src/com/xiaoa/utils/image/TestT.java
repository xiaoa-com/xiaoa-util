package com.xiaoa.utils.image;

import com.xiaoa.utils.email.EmailUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName TestT
 * @Description TODO
 * @Author wanmeng
 * @Date 2019/3/12 9:29
 * @Version 1.0
 **/
public class TestT {

    @Test
    public void testT() {
        String content = "我不去想,是否能够成功,既然选择了远方,便只顾风雨兼程.我不去想,能否赢得爱情,既然钟情于玫瑰,就勇敢地吐露真诚.我不去想,身后会不会袭来寒风冷雨,既然目标是地平线,留给世界的只能是背影.我不去想,未来是平坦还是泥泞,只要热爱生命,一切,都在意料之中";
        String qrImagePath = "D:/test.png";
        QRCodeUtil.encode(content, 300, 300, qrImagePath, "D:/test/小新.jpg");

        List<String> emails = new ArrayList<>();
        emails.add("amber_hj@163.com");
        boolean send = EmailUtil.send(emails, "测试二维码", "扫我", "D:", "test.png");
        System.out.println(send);
    }

}
