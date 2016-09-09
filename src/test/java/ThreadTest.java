import org.junit.Test;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author wangzhj
 */
public class ThreadTest {

    @Test
    public void test1() {

    }

    @Test
    public void test2() {
        // 使用线程安全的Vector
        Vector<Thread> threads = new Vector<Thread>();
        for (int i = 0; i < 10; i++) {
            Thread iThread = new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        // 模拟子线程任务
                    } catch (InterruptedException e) {
                    }
                    System.out.println("子线程" + Thread.currentThread() + "执行完毕");
                }
            });
            threads.add(iThread);
            iThread.start();
        }
        for (Thread iThread : threads) {
            try {
                // 等待所有线程执行完毕
                iThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("主线执行。");
    }

    @Test
    public void test3() throws Exception{
        // 定义一个缓冲的线程值 线程池的大小根据任务变化
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                        // 模拟子线程任务
                    } catch (InterruptedException e) {
                    }
                    System.out.println("子线程" + Thread.currentThread() + "执行完毕");

                }
            });
        }
        // 启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
        threadPool.shutdown();
        try {
            // 请求关闭、发生超时或者当前线程中断，无论哪一个首先发生之后，都将导致阻塞，直到所有任务完成执行
            // 设置最长等待10秒
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            //
            e.printStackTrace();
        }
        System.out.println("主线执行。");
    }

    @Test
    public void test4() throws Exception{

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("子线程" + Thread.currentThread() + "执行完毕");
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("子线程" + Thread.currentThread() + "执行完毕");
                }
            }
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println("主线执行。");
    }
}
