package com.beini.mq.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitReceive1 {
	/* 监听器监听指定的Queue */
	@RabbitListener(queues = "product.insert")
	public void process1(String str) {
		System.out.println("### message : " + str);
	}

	/* 监听器监听指定的Queue */
	@RabbitListener(queues = "product.all")
	public void process2(String str) {
		System.out.println("all messages : " + str);
	}
}
