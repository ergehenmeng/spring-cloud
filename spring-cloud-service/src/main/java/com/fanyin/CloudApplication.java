package com.fanyin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;


/**
 * EnableEurekaClient 表明自己是eureka的客户端,即是服务提供者
 */
@MapperScan(basePackages = "com.fanyin.mapper")
@SpringBootApplication
@EnableEurekaClient
public class CloudApplication {



	public static void main(String[] args) {
		SpringApplication.run(CloudApplication.class, args);

	}


}
