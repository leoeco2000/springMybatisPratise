package com.mybatis.aopTest.BeanPostProcessor;

public class footballPlayer implements PlayerActionInterface {

    String name;//球员名字
    String team;//所在球队

    //getter and setter......

    public void shoot() {
        System.out.println(this.getName()+"射门");
    }
	public void pass() {
        System.out.println(this.getName()+"边路传中");
    }

    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
}    