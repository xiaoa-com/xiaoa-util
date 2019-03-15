package com.xiaoa.utils.file;

import org.apache.commons.io.FilenameUtils;

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
     * 获取文件前缀的长度
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> 3
     */
    public static Integer getFilePrefixLength(String fileName) {
        return FilenameUtils.getPrefixLength(fileName);
    }

    /**
     * 获取文件前缀
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> D:\
     */
    public static String getFilePrefix(String fileName) {
        return FilenameUtils.getPrefix(fileName);
    }

    /**
     * 获取文件不带前缀和最后文件分隔符的路径
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> test
     */
    public static String getFilePathNoEndSeparator(String fileName) {
        return FilenameUtils.getPathNoEndSeparator(fileName);
    }

    /**
     * 获取文件不带前缀的路径
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> test\
     */
    public static String getFilePath(String fileName) {
        return FilenameUtils.getPath(fileName);
    }

    /**
     * 获取文件带前缀不带最后文件分隔符的路径
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> D:\test
     */
    public static String getFileFullPathNoEndSeparator(String fileName) {
        return FilenameUtils.getFullPathNoEndSeparator(fileName);
    }

    /**
     * 获取文件带前缀带最后文件分隔符的路径
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> D:\test\
     */
    public static String getFileFullPath(String fileName) {
        return FilenameUtils.getFullPath(fileName);
    }

    /**
     * 获取基本文件名,不带后缀
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> 小新
     */
    public static String getFileBaseName(String fileName) {
        return FilenameUtils.getBaseName(fileName);
    }

    /**
     * 获取文件名,带后缀的
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> 小新.jpg
     */
    public static String getFileName(String fileName) {
        return FilenameUtils.getName(fileName);
    }

    /**
     * 获取文件后缀
     *
     * @param fileName 文件磁盘路径
     * @return
     * @forexample D:\test\小新.jpg --> jpg
     */
    public static String getFileSuffix(String fileName) {
        return FilenameUtils.getExtension(fileName);
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
