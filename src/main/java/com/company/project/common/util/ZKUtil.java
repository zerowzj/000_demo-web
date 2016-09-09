package com.company.project.common.util;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @author wangzhj
 */
public class ZKUtil {

    private static CuratorFramework zkClient = null;

    private static String data = null;

    static {
        String zkHost = "127.0.0.1:2181";
        RetryPolicy rp = new ExponentialBackoffRetry(1000, 3);
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder().connectString(zkHost)
                .connectionTimeoutMs(5000)
                .sessionTimeoutMs(5000)
                .retryPolicy(rp);
        zkClient = builder.build();
        zkClient.start();

        final NodeCache nodeCache = new NodeCache(zkClient, "/test", false);
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("the test node is change and result is :");
                System.out.println("path : " + nodeCache.getCurrentData().getPath());
                System.out.println("data : " + new String(nodeCache.getCurrentData().getData()));
                data = new String(nodeCache.getCurrentData().getData());
                System.out.println("stat : " + nodeCache.getCurrentData().getStat());
            }
        });
        try {
            nodeCache.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void print(){
        System.out.println(data);
    }
}
