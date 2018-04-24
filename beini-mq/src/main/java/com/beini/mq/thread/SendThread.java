package com.beini.mq.thread;

import java.util.Random;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beini.core.utils.JsonUtil;
import com.beini.mq.config.RabbitQueueConfig;
import com.beini.mq.entity.TestTemp;
import com.beini.mq.imoocSender.MQSender;
@Component
public class SendThread {
	@Autowired
	private AmqpTemplate amqpTemplate;
	@Autowired
	private MQSender mqSender;
	
	public SendThread() {
		
	}
	public SendThread(MQSender mqSender) {
		this.mqSender = mqSender;
	}
	/*public void execute(MQSender mqSender) {
		new SendThread().start();
	}*/
	public void execute() {
		new Worker().start();
	}
	
	public void execute2() {
		new Worker2().start();
	}
	
	 // 线程内部类，Thread或者Runnable均可
    private class Worker extends Thread {
        @Override
        public void run() {
        	for (int i = 1; i <= 100; i++) {
        		int index = new Random().nextInt(100000);
        		SendThread.this.mqSender.send(new TestTemp("name_"+index));
        	}
        }
    }
    
    // 线程内部类，Thread或者Runnable均可
    private class Worker2 extends Thread {
        @Override
        public void run() {
        	for (int i = 1; i <= 100; i++) {
        		int index = new Random().nextInt(100000);
        		SendThread.this.mqSender.sendStr(new TestTemp("name_"+index));
        	}
        }
    }
}
