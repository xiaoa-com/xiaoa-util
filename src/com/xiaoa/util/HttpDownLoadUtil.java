package com.xiaoa.util;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName HttpDownLoadUtil
 * @Description 文件下载工具类
 * @Author wanmeng
 * @Date 2019/3/11 17:34
 * @Version 1.0
 **/
public class HttpDownLoadUtil {
    private HttpDownLoadUtil() {
    }

    /**
     * 从指定的URL下载文件到指定的目录
     *
     * @param url      文件地址
     * @param dir      存储目录
     * @param fileName 存储文件名
     */
    public static void downLoadByUrl(String url, String dir, String fileName) {
        try {
            URL httpUrl = new URL(url);
            File dirFile = new File(dir);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
            //下载文件
            FileUtils.copyURLToFile(httpUrl, new File(dir + File.separator + fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDownLoad(){
        downLoadByUrl("https://img01.sogoucdn.com/app/a/100520093/339f7cbe2d55caa5-9d1043cca1534199-093a9343ea9a7bf40b3e7765c329e02f.jpg","D://test","小新.jpg");
    };
}
