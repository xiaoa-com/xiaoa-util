package com.xiaoa.utils.zookeeper;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ZkUtil {

    //日志揭露工具类
    private static final Logger log = LoggerFactory.getLogger(ZkUtil.class);

    private static final String connectString = "192.168.137.102:2181,192.168.137.103:2181,192.168.137.104:2181";
    private static final int sessionTimeout = 2000;

    public static ZooKeeper getZK() {

        ZooKeeper zkClient = null;
        try {
            zkClient = new ZooKeeper(connectString, sessionTimeout, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    // 收到事件通知后的回调函数（应该是我们自己的事件处理逻辑）
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            if (zkClient.getState().isConnected()) {
                log.info("创建zkClient成功");
                return zkClient;
            }
        }

    }
}
