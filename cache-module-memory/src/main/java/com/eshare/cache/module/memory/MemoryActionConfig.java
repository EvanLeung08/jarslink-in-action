package com.eshare.cache.module.memory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryActionConfig {
	
	@Bean
	public MemoryAction getDemoAction() {
		return new MemoryAction();
	}
	
}