package com.fanyin;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by fanyin on 2017-07-06 11:20.
 * 自定义发送发送接收接口
 */
public interface MySink {

    String input = "input";
    String output = "output";

    @Input(MySink.input)
    SubscribableChannel input();

    @Output(MySink.output)
    MessageChannel ouput();
}
