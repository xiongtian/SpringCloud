package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiongtian
 * @create 2020/10/27-1:38
 * 修改轮询的规则
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){

        return new RandomRule();//定义为随机
    }
}
