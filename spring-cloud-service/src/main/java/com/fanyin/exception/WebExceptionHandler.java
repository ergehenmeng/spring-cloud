package com.fanyin.exception;


import com.fanyin.param.ResponseJson;
import com.fanyin.param.ResponseUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


@ControllerAdvice
public class WebExceptionHandler{

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseJson jsonException(HttpServletRequest request, Exception e){
       if(e instanceof RuntimeException){
           e = (RuntimeException)e;
           return ResponseUtil.businessJson(400,e.getMessage());
       }else{
            return ResponseUtil.systemJson("系统繁忙,请稍后再试");
       }
    }
}
