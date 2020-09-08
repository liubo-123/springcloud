package com.example.demo;

import com.example.demo.util.SzhMappingJackson2HttpMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableHystrix
public class ConsumerApplication {
	//private static final Logger logger = LogManager.getLogger(ConsumerApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConsumerApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(new SzhMappingJackson2HttpMessageConverter());

		return restTemplate;
	}
}
