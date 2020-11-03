package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("**********插入结果" + result + "**********");
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功！,serverPort:" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败！");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("**********查询结果" + payment + "**********");
        if (null != payment) {
            return new CommonResult(200, "查询成功！ serverPort:" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，查询ID！" + id, null);
        }
    }

    @GetMapping(value = "/payment/discovery")
    public Object discovery() {
        // 获取服务列表的信息，该Eureka下所有的微服务信息
        List<String> services = discoveryClient.getServices();
        for (String element : services) {

            log.info("********element:" + element + "********");
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("********service::" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri() + "********");
        }
        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    /**
     * 模拟超时服务
     * @return 返回值端口
     */
    @GetMapping(value ="/payment/feign/timeout")
    public String paymentFeignTimeout() {
        // 暂停线程几秒钟
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        return serverPort;
    }

    /**
     *测试zipkin
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi, I'am paymentzipkin server fall back, Welcome to atguigu !";
    }
}
