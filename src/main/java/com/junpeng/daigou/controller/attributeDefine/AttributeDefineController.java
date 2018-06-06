package com.junpeng.daigou.controller.attributeDefine;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.attributeDefine.AttributeDefineService;

@Controller
@RequestMapping("/attributeDefine")
public class AttributeDefineController {

	
	@Autowired
	private AttributeDefineService attributeDefineService;

	@ResponseBody
	@RequestMapping("/list")
	public CommonResponse<AttributeDefineResponse> showALL() {
		List<AttributeDefineResponse> response = attributeDefineService.listAllBand();
		return new CommonResponse<AttributeDefineResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping("/findbyId")
	public CommonResponse<AttributeDefineResponse> findbyId(@RequestParam(value="id" , defaultValue = "0") int id) {
		List<AttributeDefineResponse> response = attributeDefineService.findbyId(id);
		return new CommonResponse<AttributeDefineResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping("/findbyCategoryId")
	public CommonResponse<AttributeDefineResponse> findbyCategoryId(@RequestParam(value="categoryId" , defaultValue = "0") int categoryId) {
		List<AttributeDefineResponse> response = attributeDefineService.findbyCategoryId(categoryId);
		return new CommonResponse<AttributeDefineResponse>(response);
	}
}
