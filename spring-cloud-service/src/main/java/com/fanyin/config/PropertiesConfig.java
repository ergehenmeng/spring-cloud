package com.fanyin.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;


/**
 * @author fanyin
 * @create 2017-06-29 16:47
 */
public class PropertiesConfig extends PropertyPlaceholderConfigurer{

    public static final Logger LOGGER = LoggerFactory.getLogger(PropertiesConfig.class);

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if(isEncrypt(propertyName)){
            LOGGER.info("加密key:{},value:{}",propertyName,propertyValue);
            return "";
        }else {
          return  propertyValue;
        }
    }

    private boolean isEncrypt(String key){
        return key.startsWith("encrypt.");
    }

}
