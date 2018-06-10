package com.mybatis.aopTest.BeanPostProcessor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.SmartLifecycle;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

public class CustomComponent implements SmartLifecycle {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private boolean hasData;

    @Override
    public boolean isRunning() {
        // TODO Auto-generated method stub
        return hasData;
    }

    @Override
    public void start() {
        System.out.println(">>>>>>>>>>>>>");
        String result = jdbcTemplate.queryForObject("select name from user ", String.class);
        System.out.println("start启动服务加载的数据：" + result);
        hasData = StringUtils.isNotEmpty(result) ? true : false;
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

    @Override
    public int getPhase() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isAutoStartup() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void stop(Runnable arg0) {
        if(hasData) {
            System.out.println("删除表");
//            jdbcTemplate.execute("drop table user");
        }
    }
}