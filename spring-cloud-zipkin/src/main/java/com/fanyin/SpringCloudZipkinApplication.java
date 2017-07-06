package com.fanyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * 服务间调用时 链路追踪
 *
 */
@SpringBootApplication
@EnableZipkinServer
public class SpringCloudZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinApplication.class, args);
	}
}
