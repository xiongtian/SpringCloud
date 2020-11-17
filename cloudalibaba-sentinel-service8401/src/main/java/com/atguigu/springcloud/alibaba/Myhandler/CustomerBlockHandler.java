package com.atguigu.springcloud.alibaba.Myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/17 16:41
 */

public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){
        return new CommonResult(444, "按客户自定义,global handlerException ! ----- 1", new Payment(2020L, "serial002"));
    }

    public static CommonResult handlerException2(BlockException exception){
        return new CommonResult(444, "按客户自定义,global handlerException ! ----- 2", new Payment(2020L, "serial002"));
    }
}
