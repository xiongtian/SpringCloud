package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Restemplate配置，将其注入到容器中
 */
@Configuration
public class ApplicationContextConfig {

    /**
     *
     * @return 将RestTemplate注入到容器中
     */
    @Bean
    //@LoadBalanced      // 使用@LoadBalanced注解赋予RestTmplate负载均衡的能力(练习自定义轮询算法时将其注解掉)
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}