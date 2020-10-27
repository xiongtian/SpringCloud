package com.atguigu.springcloud.service;

/**
 * @author xiongtian
 * @create 2020/10/27-23:05
 */

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问肯定ok的
     *
     * @param id
     * @return
     */
    public String paymentInfo_Ok(Integer id) {

        return "线程池" + Thread.currentThread().getName() + "  paymentInfo_OK,id  " + id + "\t";
    }

    /**
     * 超时的
     *
     * @param id
     * @return
     */
    public String paymentInfo_Timeout(Integer id) {

        int timeNumber = 3;
        // 模拟超时
        try { TimeUnit.SECONDS.sleep(timeNumber); } catch (InterruptedException e) { e.printStackTrace(); }

        return "线程池" + Thread.currentThread().getName() + "  paymentInfo_Timeout,id  " + id + "\t" + "   耗时:" + timeNumber + "秒钟";
    }
}
