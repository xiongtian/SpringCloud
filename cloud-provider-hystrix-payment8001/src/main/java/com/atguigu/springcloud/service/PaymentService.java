package com.atguigu.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/10/28 9:48
 */
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
     * 超时访问，演示降级
     * 设置超时时间为3秒
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 3;
        // 模拟超时
        //int age = 10/0;
        try { TimeUnit.SECONDS.sleep(timeNumber); } catch (InterruptedException e) { e.printStackTrace(); }
        return "线程池" + Thread.currentThread().getName() + "  paymentInfo_Timeout,id  " + id + "\t" + "   耗时:" + timeNumber + "秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id) {
        return "调用支付接口超时或异常： \t"+"\t 当前线程池名字"+Thread.currentThread().getName();
    }
}

