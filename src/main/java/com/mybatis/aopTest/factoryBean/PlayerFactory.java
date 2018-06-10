package com.mybatis.aopTest.factoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PlayerFactory implements FactoryBean<PlayerActionInterface>, InitializingBean,
DisposableBean {
	
	/*被代理的PlayerActionInterface实现对象，通过XML注入*/
	private PlayerActionInterface target;
    public PlayerActionInterface getTarget() {
        return target;
    }
    public void setTarget(PlayerActionInterface target) {
        this.target = target;
    }

	/*本类生成的代理对象*/
	private PlayerActionInterface proxyObj;

	/*在容器设置bean必须的属性之后执行初始化工作*/
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
		proxyObj = (PlayerActionInterface)Proxy.newProxyInstance(this.getClass().getClassLoader(),
	        new Class[] { Class.forName("com.mybatis.aopTest.factoryBean.PlayerActionInterface") },
	        new InvocationHandler() {
	            @Override
	            public Object invoke(Object proxy, Method method,
	                    Object[] args) throws Throwable {
	                System.out.println("method:" + method.getName());
	                System.out.println("观察进攻及防守队员跑位");
	                Object result = method.invoke(target, args);
	                System.out.println("无球跑动");
	                return result;
	            }
	        });
	}
	public void destroy() throws Exception {
		System.out.println("distory");
	}
	
	@Override
	public PlayerActionInterface getObject() throws Exception {
		System.out.println("getObject");
		return proxyObj;
	}
	@Override
	public Class<?> getObjectType() {
		return proxyObj == null ? Object.class : proxyObj.getClass();
	}
	@Override
	public boolean isSingleton() {
		return true;
	}
}