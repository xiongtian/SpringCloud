package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自写的轮询算法
 */

@Component
public class MyLB implements LoadBalancer {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     *
     * 自旋锁
     * @return 选择的服务器值
     */
    public final int getAndIncrement(){
        int current;
        int next;
        do {
            current=this.atomicInteger.get();
            next = current > 214748367 ? 0 : current+1;
        }while (!this.atomicInteger.compareAndSet(current,next));
        System.out.println("*****访问次数： next:"+next);
        return next;
    }

    /**
     * 负载均衡算法：rest接口第几次请求数 % 服务的集群总数量 = 实际调用服务器位置下标 ， 每次服务重启后rest接口计算从1开始
     * @param serviceInstances instance集合
     * @return
     */
    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
