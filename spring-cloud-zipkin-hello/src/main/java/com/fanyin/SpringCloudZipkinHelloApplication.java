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
public class SpringCloudZipkinHelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinHelloApplication.class, args);
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudZipkinHelloApplication.class);

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

	/**
	 * say方法调用远程的world方法,而远程的world方法又回调hello方法 这样形成了链路会被zipkin记录下来
	 * @return
	 */
	@RequestMapping("/say")
	public String say(){
		LOGGER.info("远程调用中...");
		return restTemplate.getForObject("http://localhost:8702/world",String.class);
	}

	@RequestMapping("/hello")
	public String hello(){
		return "我是hello客户端";
	}
}
