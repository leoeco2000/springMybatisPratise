package com.mybatis.restful.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.mybatis.restful.entity.Category;
import com.mybatis.restful.service.CategoryService;



@Path("category")
public class CategoryServiceImpl implements CategoryService {
	
	List<Category> result;
	public void init(){
		result= new ArrayList<Category>();
		result.add(new Category(1, "第一个分类"));
		result.add(new Category(2, "第二个分类"));
	}
	
	@GET
	@Consumes({ MediaType.APPLICATION_FORM_URLENCODED })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<Category> getCategories() {
		init();
		return result;
	}
	
	@PUT
    @Path("add")
    @Produces("text/html")
    @Consumes( { "application/xml", "application/json" })
    public String addCategory(Category category) {
        System.out.println("处理添加类别逻辑，接受的数据为id:"+category.getCategoryId()+",name:"+category.getCategoryName());
        return "ok";
    }
	
	@GET
	@Path("query/{categoryId}")
	@Produces({"application/json","application/xml"})
	public Category getCategory(@PathParam("categoryId") int id){
		init();
		for(Category category:result){
			if(category.getCategoryId()==id){
				return category;
			}
		}
		return null;
	}

}

