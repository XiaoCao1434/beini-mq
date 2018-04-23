package com.beini.mq.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置消息交换机
 * 
 * @author lb_chen
 */
@Configuration
public class RabbitExchangeConfig {
	/**
	 * 直连路由器<br>
	 * DirectExchange:按照routingkey分发到指定队列
	 * 
	 * @return
	 */
	@Bean("directExchange")
	public DirectExchange defaultExchange() {
		return new DirectExchange("directExchange");
	}

	/**
	 * 头部路由器<br>
	 * HeadersExchange ：通过添加属性key-value匹配
	 * 
	 * @return
	 */
	@Bean("headersExchange")
	public HeadersExchange headersExchange() {
		return new HeadersExchange("headersExchange");
	}

	/**
	 * 主题路由器<br>
	 * TopicExchange:多关键字匹配
	 * 
	 * @return TopicExchange
	 */
	@Bean("topicExchange")
	public TopicExchange topicExchange() {
		return new TopicExchange("topicExchange");
	}

	/**
	 * 配置广播路由器<br>
	 * FanoutExchange: 将消息分发到所有的绑定队列，无routingkey的概念
	 * 
	 * @return FanoutExchange
	 */
	@Bean("fanoutExchange")
	public FanoutExchange fanoutExchange() {
		return new FanoutExchange("fanoutExchange");
	}
}