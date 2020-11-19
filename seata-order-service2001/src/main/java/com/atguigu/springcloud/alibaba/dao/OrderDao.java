package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/19 12:04
 */
@Mapper
public interface OrderDao {
    // 1 新建订单
    void create(Order order);

    // 2 修改订单状态，从 0 改为 1
    void update(@Param("userId")Long userId,@Param("status")Integer status);

}
