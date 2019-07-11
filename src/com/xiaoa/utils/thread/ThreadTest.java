package com.xiaoa.utils.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author wanm
 * @description 线程池测试类
 * @date 19-7-11下午8:18
 */
public class ThreadTest {
    //日志记录工具类
    private static final Logger log = LoggerFactory.getLogger(ThreadTest.class);

    /**
     * 电脑是2核4线程,
     * 明显感觉到任务5是在有空余线程的情况下排队执行的,
     * 因为线程池是单例的,
     * 所以获取第二个线程池，事实上是不为空的
     */
    @Test
    public void Test1() {
        ThreadPoolExecutor singlePoolExecutor = ThreadPoolUtils.getSinglePoolExecutor();

        MyJob myJob1 = new MyJob("任务1： ");
        MyJob myJob2 = new MyJob("任务2： ");
        MyJob myJob3 = new MyJob("任务3： ");
        MyJob myJob4 = new MyJob("任务4： ");
        MyJob myJob5 = new MyJob("任务5： ");

        singlePoolExecutor.submit(myJob1);
        singlePoolExecutor.submit(myJob2);
        singlePoolExecutor.submit(myJob3);
        singlePoolExecutor.submit(myJob4);
        singlePoolExecutor.submit(myJob5);

        singlePoolExecutor.shutdown();
        ThreadPoolExecutor singlePoolExecutor2 = ThreadPoolUtils.getSinglePoolExecutor();
        log.info(singlePoolExecutor2.toString());

        while (true) {
            if (singlePoolExecutor.isTerminated()) {
                log.info("所有线程中任务结束");
                ThreadPoolExecutor singlePoolExecutor3 = ThreadPoolUtils.getSinglePoolExecutor();
                log.info(singlePoolExecutor3.toString());
                break;
            }
        }

    }

    /**
     * 电脑是2核4线程,
     * 明显感觉到任务5是在有空余线程的情况下排队执行的,
     * 因为线程池是普通的,
     * 所以获取第二个线程池，事实上是空的
     */
    @Test
    public void Test2() {
        ThreadPoolExecutor poolExecutor = ThreadPoolUtils.getPoolExecutor();

        MyJob myJob1 = new MyJob("任务1： ");
        MyJob myJob2 = new MyJob("任务2： ");
        MyJob myJob3 = new MyJob("任务3： ");
        MyJob myJob4 = new MyJob("任务4： ");
        MyJob myJob5 = new MyJob("任务5： ");

        poolExecutor.submit(myJob1);
        poolExecutor.submit(myJob2);
        poolExecutor.submit(myJob3);
        poolExecutor.submit(myJob4);
        poolExecutor.submit(myJob5);

        poolExecutor.shutdown();

        ThreadPoolExecutor poolExecutor2 = ThreadPoolUtils.getPoolExecutor();
        log.info(poolExecutor2.toString());

        while (true) {
            if (poolExecutor.isTerminated()) {
                log.info("所有线程中任务结束");
                break;
            }
        }

    }
}
