package com.mybatis.app;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class SpringApplicationContextInitializer implements ApplicationContextInitializer<XmlWebApplicationContext> {
	public void initialize(XmlWebApplicationContext applicationContext) {
		applicationContext.setAllowBeanDefinitionOverriding(false);
		//在这里将XmlWebApplicationContext属性allowBeanDefinitionOverriding设置为false,
		//这个属性的值最终会传递给DefaultListableBeanFactory类的allowBeanDefinitionOverriding属性
	}
}