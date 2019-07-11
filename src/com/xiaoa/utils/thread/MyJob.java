package com.xiaoa.utils.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @author wanm
 * @description 线程任务类
 * @date 19-7-11下午8:16
 */
public class MyJob implements Callable<String> {

    //记录日志工具类
    private static final Logger log = LoggerFactory.getLogger(MyJob.class);

    //参数
    private String param;

    public MyJob(String param) {
        this.param = param;
    }

    @Override
    public String call() throws Exception {
        log.info("{}执行线程中方法", param);
        Thread.sleep(5000);
        return null;
    }
}
