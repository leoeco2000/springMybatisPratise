package com.mybatis.aopTest.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class test {
	public static void main(String[] args) throws Exception {

	    Object tempTarget = new Object();

	    ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
	    Fireable fighterPlane = ctx.getBean("fighterPlane", Fireable.class);
	    Fireable tank = ctx.getBean("tank", Fireable.class);
	    fighterPlane.attack(tempTarget);
	    System.out.println();
	    tank.attack(tempTarget);

	}
}
