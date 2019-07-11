package com.xiaoa.utils.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author wanm
 * @description 线程池工具类
 * @date 19-7-11下午7:51
 */
public class ThreadPoolUtils {

    //日志记录工具类
    private static final Logger log = LoggerFactory.getLogger(ThreadPoolUtils.class);

    //单例线程池对象
    private static ThreadPoolExecutor singlePoolExecutor;
    //非单例线程池对象
    private static ThreadPoolExecutor poolExecutor;

    /**
     * 创建单例的线程池对象，可控
     *
     * @return
     */
    public static ThreadPoolExecutor getSinglePoolExecutor() {

        try {
            if (null == singlePoolExecutor) {
                synchronized (ThreadPoolUtils.class) {
                    if (null == singlePoolExecutor) {
                        int cpuNum = Runtime.getRuntime().availableProcessors();
                        log.info("cpu线程数： {}", cpuNum);
                        singlePoolExecutor = new ThreadPoolExecutor(cpuNum,     //线程池长期维持的线程数
                                cpuNum * 2,                     //线程池最大的线程数
                                60, TimeUnit.SECONDS,              //线程空闲超过60秒被回收
                                new LinkedBlockingDeque<>(Integer.MAX_VALUE));  //任务的排队队列
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return singlePoolExecutor;
    }

    /**
     * 创建普通的线程池对象，不可控
     *
     * @return
     */
    public static ThreadPoolExecutor getPoolExecutor() {
        int cpuNum = Runtime.getRuntime().availableProcessors();
        log.info("cpu线程数： {}", cpuNum);
        poolExecutor = new ThreadPoolExecutor(cpuNum,           //线程池长期维持的线程数
                cpuNum * 2,                     //线程池最大的线程数
                60, TimeUnit.SECONDS,              //线程空闲超过60秒被回收
                new LinkedBlockingDeque<>(Integer.MAX_VALUE));  //任务的排队队列
        return poolExecutor;
    }

}
