package com.fanyin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

@SpringBootApplication
//@EnableBinding(Sink.class)
@EnableBinding(MySink.class)
public class SpringCloudStreamInputApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudStreamInputApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamInputApplication.class, args);
	}

	//@StreamListener(Sink.input)
	@StreamListener(MySink.input)
	public void process(Message<String> message){
		LOGGER.info("接收到的消息:{}",message.getPayload());
	}



}
