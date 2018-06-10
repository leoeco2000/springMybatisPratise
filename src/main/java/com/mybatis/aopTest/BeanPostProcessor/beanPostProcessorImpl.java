package com.mybatis.aopTest.BeanPostProcessor;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.mybatis.aopTest.factoryBean.PlayerActionInterface;

public class beanPostProcessorImpl implements BeanPostProcessor{

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {

        /* 后处理器beanPostProcessor会对容器中所有的bean起作用，因此我们要限定一下范围。
         * 这个例子中，我们只处理PlayerActionInterface对象*/
        if(!(bean instanceof PlayerActionInterface)){
            return bean;
        }

        final Object finalBean=bean;
        Map map = new ConcurrentHashMap(100);  

        if(map.get(beanName)!=null){
            return map.get(beanName);
        }

        Class[] classes=bean.getClass().getInterfaces();
        if(classes.length<1){
            //没有接口的，无法进行代理
            return bean;
        }

        Object proxyObj = Proxy.newProxyInstance(this.getClass().getClassLoader(),
                classes,
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method,
                            Object[] args) throws Throwable {
                        System.out.println("method:" + method.getName());
                        Object result = method.invoke(finalBean, args);
                        System.out.println("发生时间："
                                + (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"))
                                        .format(new Date()));
                        return result;
                    }
                });
        map.put(beanName, proxyObj);
        return proxyObj;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {
        return bean;
    }
}