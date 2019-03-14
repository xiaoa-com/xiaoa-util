package com.xiaoa.utils.file;

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
    public void testT(){
        FileUtil.deleteAllInFolder("D:\\test");
    }
    @Test
    public  void testTT(){
        FileUtil.deleteFilesAndFolder("D:\\test");
    }
    @Test
    public  void testTTT(){
        List<String> filePathInFolder = FileUtil.getFilePathInFolder("D:\\test");
        for (String s : filePathInFolder) {
            System.out.println(s);
        }
    }
    @Test
    public  void testTTTT(){
        List<String> fileNameInFolder = FileUtil.getFileNameInFolder("D:\\test");
        for (String s : fileNameInFolder) {
            System.out.println(s);
        }
    }
}
