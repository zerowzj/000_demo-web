package com.noriental.jobweb.job.service.demo;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzhj
 */
@Service("demo")
public class Demo {

    public void sayHi(String trackNo) {
        try {
            TimeUnit.SECONDS.sleep(180);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("你好啊！");
    }
}
