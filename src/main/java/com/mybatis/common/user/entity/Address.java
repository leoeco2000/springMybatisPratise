package com.mybatis.common.user.entity;

import java.io.Serializable;

import com.mybatis.common.user.enumObject.CityTest;

public class Address implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String province;
	CityTest city;
    public Address() {}
    public Address(String province, CityTest city) {
        this.province = province;
        this.city = city;
    }
  //假设我们存储在db中的字符串是以","号分隔省市关系的
    public Address(String address) {  
        if (address != null) {  
            String[] segments = address.split(",");  
            if (segments.length > 1) {  
                this.province = segments[0];
                this.city = CityTest.Value2CityTest(segments[1]);  
            } 
            else if (segments.length > 0) {  
                this.city = CityTest.Value2CityTest(segments[0]);  
            }  
        }  
    }
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public CityTest getCity() {
		return city;
	}
	public void setCity(CityTest city) {
		this.city = city;
	}
	@Override
	public String toString() {
	    return this.province + "," + this.city.getName();
	}
    
}