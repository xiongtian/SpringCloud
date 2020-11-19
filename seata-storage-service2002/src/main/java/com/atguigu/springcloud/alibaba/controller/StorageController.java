package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.domain.CommonResult;
import com.atguigu.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/19 17:15
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 减扣库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId,Integer count){
        storageService.decrease(productId, count);
        return new CommonResult(200,"扣减库存成功！");
    }
}
