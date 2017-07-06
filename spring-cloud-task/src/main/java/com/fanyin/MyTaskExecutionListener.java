package com.fanyin;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

/**
 * Created by fanyin on 2017-07-05 17:59.
 */
public class MyTaskExecutionListener implements TaskExecutionListener {
    @Override
    public void onTaskStartup(TaskExecution taskExecution) {
        System.out.println("任务开始");
    }

    @Override
    public void onTaskEnd(TaskExecution taskExecution) {
        System.out.println("任务结束");
    }

    @Override
    public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {
        System.out.println("任务失败");
    }
}
