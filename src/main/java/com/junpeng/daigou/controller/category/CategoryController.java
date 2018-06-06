package com.junpeng.daigou.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.category.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping("/list")
	public CommonResponse<CategoryAttrDefResponse> showALL() {
		List<CategoryAttrDefResponse> response = categoryService.listAllBand();
		return new CommonResponse<CategoryAttrDefResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping("/{id}/findbyId")
	public CommonResponse<CategoryAttrDefResponse> findbyId(@PathVariable("id") int id) {
		List<CategoryAttrDefResponse> response = categoryService.findbyId(id);
		return new CommonResponse<CategoryAttrDefResponse>(response);
	}

	@ResponseBody
	@RequestMapping(value="/addNew",method=RequestMethod.POST)
	public CommonResponse<CategoryAttrDefResponse> addNew(@RequestBody CategoryAttrDefRequest category) {
		List<CategoryAttrDefResponse> response = categoryService.addNew(category);
		
		return new CommonResponse<CategoryAttrDefResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public CommonResponse<CategoryAttrDefResponse> update(@RequestBody CategoryAttrDefRequest category) {
		List<CategoryAttrDefResponse> response = categoryService.update(category);
		
		return new CommonResponse<CategoryAttrDefResponse>(response);
	}
	
}
