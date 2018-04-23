package com.beini.mq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class RabbitBidding {

	@Bean("topic_insert")
	public Binding insertTopic(@Qualifier("product.insert")Queue queue,@Qualifier("topicExchange")TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("product.insert");
	}
	@Bean("topic_update")
	public Binding updateTopic(@Qualifier("product.update")Queue queue,@Qualifier("topicExchange")TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("product.update");
	}
	@Bean("topic_delete")
	public Binding deleteTopic(@Qualifier("product.delete")Queue queue,@Qualifier("topicExchange")TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("product.delete");
	}
	@Bean("topic_select")
	public Binding selectTopic(@Qualifier("product.select")Queue queue,@Qualifier("topicExchange")TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("product.select");
	}
	@Bean("topic_all")
	public Binding allTopic(@Qualifier("product.all")Queue queue,@Qualifier("topicExchange")TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("product.all");
	}
}
