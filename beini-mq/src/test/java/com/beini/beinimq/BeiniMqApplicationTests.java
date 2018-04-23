package com.beini.beinimq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.beini.mq.BeiniMqApplication;
import com.beini.mq.sender.RabbitSender;
@RunWith(SpringRunner.class)
@SpringBootTest(classes=BeiniMqApplication.class)
public class BeiniMqApplicationTests {
	@Autowired
	private RabbitSender rabbitSender;
	@Test
	public void testSend() {
		for(int i = 1;i<=100000;i++) {
			try {
				rabbitSender.sendMsg("message : "+ i);
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
