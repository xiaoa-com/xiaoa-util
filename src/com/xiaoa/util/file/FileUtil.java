package com.xiaoa.util.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
     * 获取目录下所有文件夹名,不包括子文件夹和文件名
     *
     * @param path
     */
    public static List<String> getFileNameInFolder(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        List<String> fileNameList = new ArrayList<>();
        if (null != files) {
            for (File f : files) {
                if (f.isDirectory()) {
                    fileNameList.add(f.getName());
                }
            }
        }
        return fileNameList;
    }
    
    /**
     * 获取目录下所有的文件的绝对路径
     *
     * @param path
     */
    public static List<String> getFilePathInFolder(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        List<String> filePathList = new ArrayList<>();
        if (null != files) {
            for (File f : files) {
                if (f.isDirectory()) {
                    filePathList.addAll(FileUtil.getFilePathInFolder(f.getAbsolutePath()));
                } else {
                    filePathList.add(f.getAbsolutePath());
                }
            }
        }
        return filePathList;
    }

    /**
     * 删除文件夹下所有文件和文件夹,包括最外层文件夹
     *
     * @param path
     */
    public static boolean deleteFilesAndFolder(String path) {
        boolean result = FileUtil.deleteAllInFolder(path);
        if (result) {
            new File(path).delete();
        } else {
            return false;
        }
        return true;
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
