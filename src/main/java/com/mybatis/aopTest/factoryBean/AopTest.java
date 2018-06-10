package com.mybatis.aopTest.factoryBean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class AopTest {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
//		WebApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();
        Object obj1 = ctx.getBean("PlayerFactory");
        Object obj2 = ctx.getBean("&PlayerFactory");
        System.out.println("ctx.getBean(\"PlayerFactory\"):"+obj1.getClass().getName());
        System.out.println("ctx.getBean(\"&PlayerFactory\"):"+obj2.getClass().getName());
        System.out.println("-----------------------");

        PlayerActionInterface smone = ctx.getBean("PlayerFactory",
                PlayerActionInterface.class);
        smone.shoot();
        System.out.println("");
        smone.pass();
    }
}
