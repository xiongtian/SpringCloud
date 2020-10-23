package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/*
* Restemplate配置，将其注入到容器中
* */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced      // 使用@LoadBalanced注解赋予RestTmplate负载均衡的能力
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}

