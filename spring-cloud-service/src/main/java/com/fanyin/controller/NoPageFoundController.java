package com.fanyin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by fanyin on 2017-06-30 13:36.
 */
@Controller
public class NoPageFoundController implements ErrorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoPageFoundController.class);

    private static final String ERROR_PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @RequestMapping(value = ERROR_PATH,produces = "text/html")
    public ModelAndView errorReturn(HttpServletRequest request){

        return new ModelAndView("errorPage.html",getRequestAttribute(request));
    }

    /**
     * 获取request中绑定的参数
     * @param request
     * @return
     */
    private Map<String,Object> getRequestAttribute(HttpServletRequest request){
        RequestAttributes attribute = new ServletRequestAttributes(request);
        Map<String,Object> map = this.errorAttributes.getErrorAttributes(attribute,false);
        String url = request.getRequestURL().toString();
        map.put("url",url);
        LOGGER.error("无效请求页面:{}",url);
        return map;
    }

}
