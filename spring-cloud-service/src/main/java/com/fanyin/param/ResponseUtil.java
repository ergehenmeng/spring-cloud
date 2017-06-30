package com.fanyin.param;

/**
 * Created by fanyin on 2017-06-30 14:24.
 * 异常时post请求json返回值处理
 */
public class ResponseUtil {


    public static ResponseJson systemJson(String msg){
        return new ResponseJson(400,msg);
    }

    public static ResponseJson businessJson(int code,String msg){
        return new ResponseJson(code,msg);
    }
}
