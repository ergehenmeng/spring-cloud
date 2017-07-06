package com.fanyin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * 监控页面:任意一个部署了Hystrix仪表盘的应用 http://ip:port/hystrix 输入的stream地址为:http://turbineIp:port/turbine.stream即可
 * 注意:用来管理Hystrix监控数据时,需要先调用接口才会显示,否则会一致loading...
 */
@SpringBootApplication
@EnableTurbine
public class SpringCloudTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTurbineApplication.class, args);
	}
}
