package com.xiaoa.util.email;

import com.xiaoa.util.prop.PropertiesUtil;
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
        List<String> emails = new ArrayList<>();
        emails.add("amber_hj@163.com");
        boolean send = EmailUtil.send(emails, "测试", "这是内容主体", null, null);
        System.out.println(send);
    }

}
