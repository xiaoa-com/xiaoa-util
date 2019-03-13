package com.xiaoa.util.prop;

import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName PropertiesUtil
 * @Description properties文件操作工具类
 * @Author wanmeng
 * @Date 2019/3/13 20:14
 * @Version 1.0
 **/
public class PropertiesUtil {
    private PropertiesUtil() {
    }

    /**
     * 根据key获取value
     * @param key
     * @return
     */
    public static String getValueByKey(String key) {
        Properties prop = new Properties();
        try {
            prop.load(PropertiesUtil.class.getResourceAsStream("/conf.properties"));
            return prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
