package com.atguigu.springcloud.alibaba.service;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/19 17:05
 */
public interface StorageService {

    /*
    * 扣减库存
    * */
    void decrease(Long productId,Integer count);
}
