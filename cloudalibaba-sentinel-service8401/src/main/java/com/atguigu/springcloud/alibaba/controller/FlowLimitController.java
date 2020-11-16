package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String testA() {
        // 演示流控规则按照线程数的情况
        //try { TimeUnit.MILLISECONDS.sleep(2000); } catch (InterruptedException e) { e.printStackTrace(); }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        // 流控效果 --->  排队等待
        log.info(Thread.currentThread().getName() + "\t" + ".... /testB");
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD() {
        // 暂停几秒钟线程
        // 测试RT try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        // log.info("testD 测试RT");

        // 测试异常比例
        int a = 10 / 0;
        log.info("testD 测试异常比例 ");

        return "-------testD";
    }

    @GetMapping("/testE")
    public String testE() {
        log.info("testE 测试异常数！");

        int age = 10 / 0;
        return "-------testE 测试异常数！";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {

        return "-------testHotKey";
    }

    public String deal_testHotKey(String p1,String p2, BlockException exception){
        return "------- deal_testHotKey,wuwuwuuw";

    }
}
