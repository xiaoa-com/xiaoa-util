package com.xiaoa.utils.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ZkWatcherClient extends Thread {

    //日志记录工具类
    private static final Logger log = LoggerFactory.getLogger(ZkWatcherClient.class);
    //获取zk客户端
    private static ZooKeeper zk;

    public ZkWatcherClient() {
        zk = ZkUtil.getZK();
    }

    /**
     * 监控zookerper节点变化
     */
    @Override
    public void run() {
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                run();
            }
        };
        try {
            String zkData = new String(zk.getData("/eclipse", watcher, null));
            log.info("eclise:-->" + zkData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testWatchZk() {
        ZkWatcherClient zkWatcherClient = new ZkWatcherClient();
        //用守护线程实现后台监控zookeeper节点变化
        zkWatcherClient.setDaemon(true);

        zkWatcherClient.start();

    }
}
