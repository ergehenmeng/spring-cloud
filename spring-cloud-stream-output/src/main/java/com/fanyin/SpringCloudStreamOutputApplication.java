package com.fanyin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
//@EnableBinding(Source.class)
@EnableBinding(MySink.class)
@RestController
public class SpringCloudStreamOutputApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamOutputApplication.class, args);
	}

	/*系统发送:
	@InboundChannelAdapter(value = Source.OUTPUT)
	public String sendMessage(){
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}*/

	@Autowired
	private MySink mySink;

	@RequestMapping("/send")
	public void sendMessage(){
		mySink.ouput().send(MessageBuilder.withPayload("发送消息").build());
	}
}
