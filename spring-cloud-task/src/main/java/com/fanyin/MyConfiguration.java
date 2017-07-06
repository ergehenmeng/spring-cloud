package com.fanyin;

import org.springframework.cloud.task.configuration.SimpleTaskConfiguration;
import org.springframework.cloud.task.listener.annotation.AfterTask;
import org.springframework.cloud.task.listener.annotation.BeforeTask;
import org.springframework.cloud.task.listener.annotation.FailedTask;
import org.springframework.cloud.task.repository.TaskExecution;
import org.springframework.context.annotation.Configuration;

/**
 * Created by fanyin on 2017-07-05 18:02.
 */

public class MyConfiguration  {

    @BeforeTask
    public void befor(TaskExecution taskExecution){

        System.out.println("之前" + taskExecution.getTaskName() + taskExecution.getExecutionId());
    }

    @AfterTask
    public void after(TaskExecution  taskExecution){
        System.out.println("之后" + taskExecution.getTaskName()+ taskExecution.getExecutionId());
    }

    @FailedTask
    public void fail(TaskExecution taskExecution){
        System.out.println("失败" + taskExecution.getTaskName()+ taskExecution.getExecutionId());
    }
}
