package com.rtstjkx.jkxlistener.rabbitmq;

import com.rtstjkx.jkxlistener.config.RabbitmqConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消息生产者
 */
@Component
@Slf4j
public class RabbitProducer implements RabbitTemplate.ConfirmCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;
   /* @Autowired
    public RabbitProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);//rabbitTemplate如果为单例的话，那回调就是最后设置的内容
    }*/
    //处理消息
    public  void sendMsg(String msg){
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_A,RabbitmqConfig.ROUTINGKEY_A,msg);
    }

    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.info("回调ID："+correlationData);
        if(b){
            log.info("消息发送成功");
        }else {
            log.info("消息发送失败"+s);
        }
    }
}
