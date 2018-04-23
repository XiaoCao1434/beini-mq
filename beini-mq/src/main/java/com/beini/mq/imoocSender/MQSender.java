package com.beini.mq.imoocSender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beini.core.utils.JsonUtil;
import com.beini.mq.config.RabbitQueueConfig;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MQSender {
	@Autowired
	AmqpTemplate amqpTemplate;
	public void send(Object message) {
		String msg = JsonUtil.beanToString(message);
		log.info("send message : "+message);
		amqpTemplate.convertAndSend(RabbitQueueConfig.QUEUE,msg);
	
	}
}
