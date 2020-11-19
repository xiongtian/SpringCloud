package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/19 14:27
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;


    /**
     * 创建订单
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户佘额->修改订单状态
     * 简单来说:
     * 下订单->减库存->减佘额->改状态
     * @param order
     */
    @Override
    public void create(Order order) {

        log.info("------->开始新建订单！");
        // 1、新建订单
        orderDao.create(order);

        log.info("------->订单微服务开始调用库存，做扣减 Count！");
        // 2、扣减库存
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------->订单微服务开始调用库存，做扣减 end！");

        log.info("------->订单微服务开始调用账户，做扣减 Money！");
        // 3、扣减账户
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------->订单微服务开始调用账户，做扣减 end ！");

        // 4、修改订单的状态，从 0 --> 1， 1表示已经完成
        log.info("------->修改订单状态开始！");
        orderDao.update(order.getUserId(),0);
        log.info("------->修改订单状态结束！");

        log.info("------->下订单结束！");
    }
}
