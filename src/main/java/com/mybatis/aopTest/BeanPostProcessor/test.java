package com.mybatis.aopTest.BeanPostProcessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) throws Exception {
	    ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
//	    PlayerActionInterface smone = ctx.getBean("messi",PlayerActionInterface.class);
//	    smone.shoot();
//	    smone.pass();
	    footballPlayer obj = ctx.getBean("messi",footballPlayer.class);
	    System.out.println(obj.getTeam());
	}
}
