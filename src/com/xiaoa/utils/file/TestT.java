package com.xiaoa.utils.file;

import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

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

}
