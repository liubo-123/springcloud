package com.example.demo.test;

import com.example.demo.util.HttpClientUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * 模拟高并发请求
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cou = new CountDownLatch(1);
        int count=0;

        for (int i = 0; i < 1000; i++) {
            String url ="http://localhost:2223/test01?phone01="+i;
            System.out.println("url:"+url);
            new Thread(new Runnable() {

                @Override
                public void run() {
                    // TODO Auto-generated method stub
                    HttpClientUtil.get(url);
                    cou.countDown();
                }

            }) {

            }.start();
            cou.await();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println("222222====" + sdf.format(date)+"====="+i);
        }
    }
}
