package com.junpeng.daigou.controller.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.product.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

//	@ResponseBody
//	@RequestMapping("/list")
//	public CommonResponse<ProductResponse> showALL() {
//		List<ProductResponse> response = productService.listAllProduct();
//		return new CommonResponse<ProductResponse>(response);
//	}
	
	@ResponseBody
	@RequestMapping("/{id}/findbyId")
	public CommonResponse<ProductResponse> findbyId(@PathVariable("id") int id) {
		List<ProductResponse> response = productService.findbyId(id);
		return new CommonResponse<ProductResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping("/findbyCategoryIdOrBrandId")
	public CommonResponse<ProductResponse> findbyCategoryIdOrBrandId(
				@RequestParam(value="categoryId" , defaultValue = "0") Integer categoryId ,
				@RequestParam(value="brandId", defaultValue = "0") Integer brandId) {
		List<ProductResponse> response = productService.findbyCategoryIdOrBrandId(categoryId , brandId);
		return new CommonResponse<ProductResponse>(response);
	}
	
	
	@ResponseBody
	@RequestMapping(value="/addNew",method=RequestMethod.POST)
	public CommonResponse<ProductResponse> addNew(@RequestBody ProductRequest product) {
		List<ProductResponse> response = productService.addNew(product);
		
		return new CommonResponse<ProductResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public CommonResponse<ProductResponse> update(@RequestBody ProductRequest product) {
		List<ProductResponse> response = productService.update(product);
		
		return new CommonResponse<ProductResponse>(response);
	}
}
