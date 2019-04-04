package com.xiaoa.utils.file;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        FileUtil.deleteAllInFolder("D:\\test");
    }

    @Test
    public void testTT() {
        FileUtil.deleteFilesAndFolder("D:\\test");
    }

    @Test
    public void testTTT() {
        List<String> filePathInFolder = FileUtil.getFilePathInFolder("D:\\test");
        for (String s : filePathInFolder) {
            System.out.println(s);
        }
    }

    @Test
    public void testTTTT() {
        List<String> fileNameInFolder = FileUtil.getFileNameInFolder("D:\\test");
        for (String s : fileNameInFolder) {
            System.out.println(s);
        }
    }

    @Test
    public void testTTTTT() {

        String fileSuffix = FileUtil.getFileSuffix("D:\\test\\小新.jpg");
        String filePath = FileUtil.getFilePath("D:\\test\\小新.jpg");
        String fileName = FileUtil.getFileName("D:\\test\\小新.jpg");
        String fileBaseName = FileUtil.getFileBaseName("D:\\test\\小新.jpg");
        String fileFullPath = FileUtil.getFileFullPath("D:\\test\\小新.jpg");
        String fileFullPathNoEndSeparator = FileUtil.getFileFullPathNoEndSeparator("D:\\test\\小新.jpg");
        String filePathNoEndSeparator = FileUtil.getFilePathNoEndSeparator("D:\\test\\小新.jpg");
        String filePrefix = FileUtil.getFilePrefix("D:\\test\\小新.jpg");
        Integer filePrefixLength = FileUtil.getFilePrefixLength("D:\\test\\小新.jpg");

        System.out.println(fileSuffix);
        System.out.println(filePath);
        System.out.println(fileName);
        System.out.println(fileBaseName);
        System.out.println(fileFullPath);
        System.out.println(fileFullPathNoEndSeparator);
        System.out.println(filePathNoEndSeparator);
        System.out.println(filePrefix);
        System.out.println(filePrefixLength);
    }

    @Test
    public void testTTTTTT() {
        List<String> lowestFolders = FileUtil.getLowestFolders("D:\\a");
        for (String lowestFolder : lowestFolders) {
            System.out.println(lowestFolder);
        }
    }

    @Test
    public void testTTTTTTT() {
        String path = "D:/a/1.xls";
        String path2 = "D:/a/2.xls";
        String path3 = "D:/a/3.jpg";
        String path4 = "D:/a/a.xlsx";
        String md5 = FileUtil.getMd5(path);
        String md52 = FileUtil.getMd5(path2);
        String md53 = FileUtil.getMd5(path3);
        String md54 = FileUtil.getMd5(path4);

        System.out.println(path+"-------"+md5);
        System.out.println(path2+"-------"+md52);
        System.out.println(path3+"-------"+md53);
        System.out.println(path4+"-------"+md54);
    }
    @Test
    public void testTTTTTTTT() {
        Map map = new HashMap<String,String>();
        map.put("1","a");
        map.put("1","b");
        System.out.println(map);
    }
}
