package com.atguigu.springcloud.service.impl;



import com.atguigu.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2020/11/3 11:28
 */
@EnableBinding(Source.class)  // 将信道Channel和exchange绑定在一起(定义消息的推送管道)
public class MessageProviderImpl implements IMessageProvider {

    // 消息发送管道
    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("*******serial: "+serial);
        return serial;
    }
}
