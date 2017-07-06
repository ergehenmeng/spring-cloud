package com.fanyin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class SpringCloudZipkinWorldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinWorldApplication.class, args);
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudZipkinWorldApplication.class);


	@Autowired
	public RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

	@Bean
	public AlwaysSampler alwaysSampler (){
		return new AlwaysSampler();
	}

	@RequestMapping("/world")
	public String world(){
		LOGGER.info("远程调用中...");
		return restTemplate.getForObject("http://localhost:8701/hello",String.class);
	}

	@RequestMapping("/say")
	public String say(){
		return "我是world客户端";
	}
}
