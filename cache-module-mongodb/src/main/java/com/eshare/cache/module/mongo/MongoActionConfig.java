package com.eshare.cache.module.mongo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MongoActionConfig {
	
	@Bean
	public MongoAction getDemoAction() {
		return new MongoAction();
	}
	
}