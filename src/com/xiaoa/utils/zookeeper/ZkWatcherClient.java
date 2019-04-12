package com.xiaoa.utils.zookeeper;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.junit.Test;

public class ZkWatcherClient {
    //获取zk客户端
    private static ZooKeeper zk = ZkUtil.getZK();

    /**
     * 监控zookerper节点变化
     */
    public void doProcess() {

        Watcher watcher = new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                doProcess();
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
        doProcess();

        while (true){
            try {
                Thread.sleep(Integer.MAX_VALUE);
//                System.err.println("我还活着呢!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
