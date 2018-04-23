package com.beini.mq.imoocReceiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beini.core.utils.JsonUtil;
import com.beini.mq.config.RabbitQueueConfig;
import com.beini.mq.entity.TestTemp;
import com.beini.mq.service.TestTempService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MQReceiver {
	@Autowired
	private TestTempService testTempService;
	@RabbitListener(queues=RabbitQueueConfig.QUEUE)
	public void receive1(String message) {
		TestTemp testTemp = JsonUtil.stringToBean(message, TestTemp.class);
		log.info("[1]receive message : "+message);
		testTempService.save(testTemp);
	}
	
	@RabbitListener(queues=RabbitQueueConfig.QUEUE)
	public void receive2(String message) {
		TestTemp testTemp = JsonUtil.stringToBean(message, TestTemp.class);
		log.info("[2]receive message : "+message);
		testTempService.save(testTemp);
		
	}
	
	@RabbitListener(queues=RabbitQueueConfig.QUEUE)
	public void receive3(String message) {
		TestTemp testTemp = JsonUtil.stringToBean(message, TestTemp.class);
		log.info("[3]receive message : "+message);
		testTempService.save(testTemp);
		
	}
}
