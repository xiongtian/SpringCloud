package com.atguigu.springcloud.alibaba;

import com.alibaba.druid.proxy.jdbc.DataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/19 11:57
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) // 取消数据源的自动创建
@EnableFeignClients
@EnableDiscoveryClient
public class SeataOrderMainApp2001 {
    public static void main(String[] args) {
        SpringApplication.run(SeataOrderMainApp2001.class,args);
    }
}
