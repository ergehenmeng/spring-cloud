package com.fanyin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.ServiceActivator;

import javax.websocket.server.ServerEndpoint;

/**
 * 作为中转站 与input out 进行通讯
 */
@SpringBootApplication
@EnableBinding(Processor.class)
public class SpringCloudStreamSourceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudStreamSourceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamSourceApplication.class, args);
	}


	@ServiceActivator(inputChannel = Processor.INPUT,outputChannel = Processor.OUTPUT)
	public Object transform(Object payload){
		LOGGER.info("中转的消息:{}",payload);
		return payload;
	}
}
