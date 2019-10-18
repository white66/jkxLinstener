package com.rtstjkx.jkx.rabbitmq;

import com.rtstjkx.jkx.config.RabbitmqConfig;
import com.rtstjkx.jkx.service.serviceImpl.RabbitmqServiceImpl;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
public class RabbitConsumer {
    @Autowired
    RabbitmqServiceImpl rabbitmqService;
    @RabbitHandler
    @RabbitListener(queues = RabbitmqConfig.QUEUE_A)
    public void receiveProcess(String msg){
        rabbitmqService.saveMsg(msg);
    }
}
