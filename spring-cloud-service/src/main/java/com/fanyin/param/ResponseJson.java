package com.fanyin.param;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fanyin on 2017-06-30 14:15.
 */
public class ResponseJson implements Serializable {

    private int code;

    private String msg;

    public ResponseJson(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
