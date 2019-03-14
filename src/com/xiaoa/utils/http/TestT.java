package com.xiaoa.utils.http;

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
        HttpDownLoadUtil.downLoadByUrl("https://img01.sogoucdn.com/app/a/100520093/339f7cbe2d55caa5-9d1043cca1534199-093a9343ea9a7bf40b3e7765c329e02f.jpg", "D://test", "小新.jpg");
    }

}
