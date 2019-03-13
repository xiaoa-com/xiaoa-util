package com.xiaoa.util.prop;

import com.xiaoa.util.http.HttpDownLoadUtil;
import org.junit.Test;

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
        String name = PropertiesUtil.getValueByKey("name");
        System.out.println(name);
    }

}
