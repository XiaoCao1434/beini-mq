package com.beini.mq.sender;

import java.util.UUID;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitSender implements RabbitTemplate.ConfirmCallback,RabbitTemplate.ReturnCallback {
	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(String content) {
		
		CorrelationData correlationId = new CorrelationData(UUID.randomUUID().toString());
		/* rabbitTemplate如果为单例的话，那回调就是最后设置的内容 */
		this.rabbitTemplate.setConfirmCallback(this);
		this.rabbitTemplate.setReturnCallback(this);
		this.rabbitTemplate.convertAndSend("topicExchange", "product_all", content,correlationId);
		//this.rabbitTemplate.convertAndSend("topicExchange", "product_all", content);
	}

	/* 确认回调 */
	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
		System.out.println(" 回调id:" + correlationData);
		if (ack) {
			System.out.println("消息成功消费");
		} else {
			System.out.println("消息消费失败:" + cause);
		}
	}

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		System.out.println("replyCode : "+replyCode+" , replyText ："+replyText+" , exchange : "+exchange+" , routingKey : "+routingKey+" , message : "+message.getBody().toString());
	}
	
}