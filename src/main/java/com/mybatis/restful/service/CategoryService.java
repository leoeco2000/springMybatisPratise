package com.mybatis.restful.service;

import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.mybatis.restful.entity.Category;

public interface CategoryService {
	public List<Category> getCategories();
	public String addCategory(Category category);
}
