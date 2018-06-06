package com.junpeng.daigou.service.category;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.category.CategoryAttrDefRequest;
import com.junpeng.daigou.controller.category.CategoryAttrDefResponse;
import com.junpeng.daigou.dao.CategoryMapper;
import com.junpeng.daigou.model.Category;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class CategoryService {

	@Autowired
	private CategoryMapper categoryDao;
	
	public List<CategoryAttrDefResponse> listAllBand() {
		
		List<Category> categorys = categoryDao.selectByExample(null);
		List<CategoryAttrDefResponse> result = combList(categorys);
		
		return result;
	}

	public List<CategoryAttrDefResponse> findbyId(int id) {
		
		List<Category> categorys = new ArrayList<Category>();
		Category category = categoryDao.selectByPrimaryKey(new Integer(id));
		categorys.add(category);
		List<CategoryAttrDefResponse> result = combList(categorys);
		
		return result;
	}
	
	private List<CategoryAttrDefResponse>  combList(List<Category> categorys){
		List<CategoryAttrDefResponse> result = new ArrayList<CategoryAttrDefResponse>();
		
		if(Utils.isNotEmpty(categorys)){
			for(Category c : categorys){
				CategoryAttrDefResponse cr = new CategoryAttrDefResponse();
				cr.setCategoryId(String.valueOf(c.getIdcategory()));
				cr.setCategoryName(c.getCategoryname());
				
				result.add(cr);
			}
		}
		
		return result;
	}

	
	public List<CategoryAttrDefResponse> addNew(CategoryAttrDefRequest b) {
		
		List<CategoryAttrDefResponse> result = new ArrayList<CategoryAttrDefResponse>();
		Category category = new Category();
		category.setCategoryname(b.getCategoryName());
		category.setCreatetime(new Date());
		category.setCreateuser("admin");
		category.setUpdatetime(new Date());
		category.setUpdateuser("admin");
		category.setIsactive("1");
		int r = categoryDao.insertSelective(category);
		
		if(r > 0){
			CategoryAttrDefResponse br = new CategoryAttrDefResponse();
			br.setCategoryId(String.valueOf(category.getIdcategory()));
			br.setCategoryName(category.getCategoryname());
			result.add(br);
		}
		return result;
	}

	public List<CategoryAttrDefResponse> update(CategoryAttrDefRequest b) {

		List<CategoryAttrDefResponse> result = new ArrayList<CategoryAttrDefResponse>();
		Category category = new Category();
		category.setIdcategory(Integer.valueOf(b.getCategoryId()));
		category.setCategoryname(b.getCategoryName());
		category.setUpdatetime(new Date());
		category.setUpdateuser("admin");
		category.setIsactive("1");
		int r = categoryDao.updateByPrimaryKey(category);
		
		if(r > 0){
			CategoryAttrDefResponse br = new CategoryAttrDefResponse();
			br.setCategoryId(String.valueOf(category.getIdcategory()));
			br.setCategoryName(category.getCategoryname());
			result.add(br);
		}
		return result;
	}
}
