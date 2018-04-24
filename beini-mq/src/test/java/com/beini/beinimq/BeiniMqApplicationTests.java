package com.beini.beinimq;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.beini.core.utils.JsonUtil;
import com.beini.mq.BeiniMqApplication;
import com.beini.mq.controller.BaseController;
import com.beini.mq.entity.TestTemp;
import com.beini.mq.imoocSender.MQSender;
import com.beini.mq.sender.RabbitSender;
import com.beini.mq.thread.SendThread;

import lombok.extern.slf4j.Slf4j;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=BeiniMqApplication.class)
@Slf4j
public class BeiniMqApplicationTests {
	@Autowired
	private RabbitSender rabbitSender;
	@Autowired
	private MQSender mqSender;
	@Autowired
	private BaseController controller;
	
	@Autowired
	private SendThread sendThread;
	
	@Test
	public void testSend() throws InterruptedException {
		long begin=0,end=0;
		begin = new Date().getTime();
		for(int i = 1;i<=100000;i++) {
			mqSender.send(JsonUtil.beanToString(new TestTemp("name_"+i)));
		}
		end = new Date().getTime();
		System.out.println(end-begin);
		Thread.sleep(1000);
		begin = 0;end = 0;
		begin = new Date().getTime();
		for(int i = 1;i<=100000;i++) {
			mqSender.send(JsonUtil.beanToString(new TestTemp("name_"+i)));
		}
		end = new Date().getTime();
		System.out.println(end-begin);
	}
	@Test
	public void test() throws InterruptedException {
		long begin=0,end=0;
		begin = new Date().getTime();
		for (int i = 0; i < 1000; i++) {
			sendThread.execute();
		}
		
		end = new Date().getTime();
		System.out.println((end-begin)/1000+" s");
	}
	
	@Test
	public void test3() {
		long begin=0,end=0;
		begin = new Date().getTime();
		for (int i = 0; i < 1000; i++) {
			sendThread.execute();
		}
		end = new Date().getTime();
		System.out.println((end-begin)+"---------------------------------------------------------------- s");
	}
}
