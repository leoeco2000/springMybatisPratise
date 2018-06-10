package com.mybatis.common.user.enumObject;

public enum CityTest {
    ChangSha(4301, "长沙"),
    Zhuzhou(4302, "株洲"),
    Xiangtan(4303, "湘潭");

    int value;
    String name;
    private CityTest(int value, String name){
        this.value=value;
        this.name = name;
    }
    public int getValue() {
        return this.value;
    }
    public String getName() {
        return this.name;
    }
    /*方法Value2CityTest是为了typeHandler后加的*/
    public static CityTest Value2CityTest(String name) {
    	System.out.println(name);
        for (CityTest citytest : CityTest.values()) {
//        	System.out.println(citytest.name);
            if (citytest.name.equals(name)) {
                return citytest;
            }
        }
        throw new IllegalArgumentException("无效的value值: " + name + "!");
    }
}