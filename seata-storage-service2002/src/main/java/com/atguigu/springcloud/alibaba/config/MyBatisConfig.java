package com.atguigu.springcloud.alibaba.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/19 15:02
 * mybatis相关的配置文件
 */
@Configuration
@MapperScan("com.atguigu.springcloud.alibaba.dao")
public class MyBatisConfig {
}
