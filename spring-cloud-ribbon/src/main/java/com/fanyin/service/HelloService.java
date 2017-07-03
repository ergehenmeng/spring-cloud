package com.fanyin.service;

/**
 * Created by fanyin on 2017-07-03 15:36.
 */
public interface HelloService {


    /**
     * 远程调用say方法,如果返回错误则回调sayCallBack方法
     * @param name
     * @return
     */
    String say(String name);
}
