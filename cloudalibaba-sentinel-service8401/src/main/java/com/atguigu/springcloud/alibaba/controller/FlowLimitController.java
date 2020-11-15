package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/10 13:51
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        // 暂停几秒钟线程
       // 测试RT try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        // log.info("testD 测试RT");

        // 测试异常比例
        int a=10/0;
        log.info("testD 测试异常比例 ");

        return "-------testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE 测试异常数！");

        int age=10/0;
        return "-------testE 测试异常数！";
    }
}
