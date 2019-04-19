package com.xiaoa.utils.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

public class ZkWatcherClient extends Thread{
    //获取zk客户端
    private static ZooKeeper zk = ZkUtil.getZK();

    /**
     * 监控zookerper节点变化
     */
    @Override
    public void run(){
        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                run();
            }
        };
        try {
            String zkData = new String(zk.getData("/eclipse", watcher, null));
            System.out.println("eclise:-->" + zkData);
        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void testWatchZk(){
        ZkWatcherClient zkWatcherClient = new ZkWatcherClient();
        //用守护线程实现后台监控zookeeper节点变化
        zkWatcherClient.setDaemon(true);

        zkWatcherClient.start();

    }
}
