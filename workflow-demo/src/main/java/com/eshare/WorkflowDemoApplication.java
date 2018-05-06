package com.eshare;

import com.bstek.uflo.console.UfloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:context.xml")
public class WorkflowDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkflowDemoApplication.class, args);
	}
	@Bean
	public ServletRegistrationBean buildUfloServlet(){
		return new ServletRegistrationBean(new UfloServlet(),"/uflo/*");
	}
}
