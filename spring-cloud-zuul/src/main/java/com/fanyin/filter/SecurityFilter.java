package com.fanyin.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.ZuulFilterResult;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fanyin on 2017-07-03 17:56.
 */
@Component
public class SecurityFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityFilter.class);




    /**
     * 过滤器类型:
     *  pre:路由之前
     *  routing:路由时
     *  post:路由之后
     *  error:发生错误调用时
     *  filterOrder->过滤排序
     *  shouldFilter->是否需要过滤,可以自定义逻辑判断
     *  run->过滤器执行逻辑,可以进行权限判断
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        LOGGER.info(String.format("%s -> %s",request.getMethod(),request.getRequestURL().toString()));
        Object token = request.getParameter("token");
        if(token == null){
            LOGGER.warn("token为空");
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().setContentType("text/html;charset=UTF-8");
                context.getResponse().getWriter().write("token不能为空");
            }catch (Exception e){

            }
            return null;
        }
        LOGGER.info("token验证通过");
        return null;
    }
}
