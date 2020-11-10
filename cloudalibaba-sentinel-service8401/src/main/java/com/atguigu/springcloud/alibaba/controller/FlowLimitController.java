package com.atguigu.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/10 13:51
 */
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB(){
        return "------testB";
    }
}
