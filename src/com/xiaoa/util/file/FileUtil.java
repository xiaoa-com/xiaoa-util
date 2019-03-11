package com.xiaoa.util.file;

import org.junit.Test;

import java.io.File;

/**
 * @ClassName FileUtil
 * @Description 操作文件的工具类
 * @Author wanmeng
 * @Date 2019/3/11 19:22
 * @Version 1.0
 **/
public class FileUtil {


    private FileUtil() {
    }

    /**
     * 删除文件夹下所有文件和文件夹,但是保留最外层文件夹
     *
     * @param path
     * @return
     */
    public static boolean deleteAllInFolder(String path) {
        File file = new File(path);
        if (!file.exists()) {//判断是否待删除目录是否存在
            return false;
        }
        String[] content = file.list();//取得当前目录下所有文件和文件夹
        for (String name : content) {
            File temp = new File(path, name);
            if (temp.isDirectory()) {//判断是否是目录
                deleteAllInFolder(temp.getAbsolutePath());//递归调用，删除目录里的内容
                temp.delete();//删除空目录
            } else {
                if (!temp.delete()) {//直接删除文件
                }
            }
        }
        return true;
    }


}
