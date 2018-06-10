package com.mybatis.aopTest.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;

public class beanFactoryPostProcessorImpl implements BeanFactoryPostProcessor{

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactoryPostProcessorImpl");
        BeanDefinition bdefine=beanFactory.getBeanDefinition("messi");
        System.out.println(bdefine.getPropertyValues().toString());
        MutablePropertyValues pv =  bdefine.getPropertyValues();  
            if (pv.contains("team")) {
                PropertyValue ppv= pv.getPropertyValue("name");
                TypedStringValue obj=(TypedStringValue)ppv.getValue();
                if(obj.getValue().equals("Messi")){
                    pv.addPropertyValue("team", "阿根延");  
                }
        }  
            bdefine.setScope(BeanDefinition.SCOPE_PROTOTYPE);
    }
}