package com.example.demo;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class ProviderApplication {
	private static final Logger logger = LogManager.getLogger(ProviderApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ProviderApplication.class, args);
	}

}
