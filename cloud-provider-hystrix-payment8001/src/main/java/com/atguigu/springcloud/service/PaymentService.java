package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
    /*"***************************************上面是服务降级，下面是服务熔断**********************************************************/


    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),// 时间窗口期（时间范围）
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率到达多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if (id < 0) {
            throw  new RuntimeException("***** id 不能为负数");
        }
        String serialNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号："+serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id 不能为负数，请稍后再试，谢谢！    ~~· id:"+id;
    }
}

