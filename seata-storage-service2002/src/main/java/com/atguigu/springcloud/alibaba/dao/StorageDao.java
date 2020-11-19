package com.atguigu.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/19 16:51
 */
@Mapper
public interface StorageDao {

    // 扣减库存
    void decrease(@Param("productId")Long productId,@Param("count")Integer count);
}
