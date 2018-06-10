package com.mybatis.aopTest.BeanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AwareTest implements BeanNameAware, ApplicationContextAware,
        BeanFactoryAware {
    String beanname;
    ApplicationContext appct;
    BeanFactory bFactory;

    @Override
    public void setBeanName(String name) {
        this.beanname = name;
        System.out.println("通过BeanNameAware接口的实现，我知道我的名字是：" + this.beanname);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        this.appct = applicationContext;
        System.out.println("通过ApplicationContextAware接口实现，获得了容器对象："
                + this.appct.toString().substring(0, 35) +"......");
        footballPlayer player = appct.getBean("messi", footballPlayer.class);
        player.setName("maladona");
        player.pass();
        player.shoot();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.bFactory = beanFactory;
        System.out.println("通过BeanFactoryAware接口实现，获得了容器对象："
                + this.bFactory.toString().substring(0, 35)+"......");
    }
}
