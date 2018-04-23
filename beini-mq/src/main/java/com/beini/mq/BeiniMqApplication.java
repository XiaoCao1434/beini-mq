package com.beini.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = { "classpath:druid-spring.xml" })
public class BeiniMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeiniMqApplication.class, args);
	}
}
