package com.beini.mq.receive;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.beini.mq.config.RabbitConfig;
import com.beini.mq.config.RabbitQueueConfig;
import com.rabbitmq.client.Channel;

@Configuration
public class RabbitReceive {
	@Autowired
	private RabbitConfig rabbitConfig;
	@Autowired
	private RabbitQueueConfig rabbitQueueConfig;

	//@Bean
	public SimpleMessageListenerContainer messageContainer() {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(rabbitConfig.connectionFactory());
		/* 设置要监听的队列 */
		container.setQueues(
				rabbitQueueConfig.queueProductAll()
				);
		container.setExposeListenerChannel(true);
		container.setMaxConcurrentConsumers(1);
		container.setConcurrentConsumers(1);
		/* 设置确认模式手工确认 */
		container.setAcknowledgeMode(AcknowledgeMode.MANUAL);
		container.setMessageListener(new ChannelAwareMessageListener() {
			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				byte[] body = message.getBody();
				System.out.println("receive msg : " + new String(body));
				/* 确认消息成功消费 */
				channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
			}
		});
		return container;
	}
}