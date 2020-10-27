package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * 选择负载算法以及机器
 * @author Administrator
 */
public interface LoadBalancer {

    /**
     * 得到instance
     * @param serviceInstances instance集合
     * @return 返回的instance
     */
    ServiceInstance  instance (List<ServiceInstance> serviceInstances);

}
