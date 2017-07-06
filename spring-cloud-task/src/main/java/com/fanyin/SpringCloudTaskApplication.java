package com.fanyin;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.cloud.task.repository.dao.TaskExecutionDao;
import org.springframework.context.annotation.Bean;

/**
 * 开启任务
 */
@SpringBootApplication
@EnableTask
public class SpringCloudTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudTaskApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				System.out.println("hello world 定时任务开始了");
			}
		};
	}

	@Bean
	public MyConfiguration myConfiguration(){
		return new MyConfiguration();
	}

}
