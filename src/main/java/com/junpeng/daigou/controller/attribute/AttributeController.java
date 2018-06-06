package com.junpeng.daigou.controller.attribute;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.attribute.AttributeService;


@Controller
@RequestMapping("/attribute")
public class AttributeController {

	@Autowired
	private AttributeService attributeService;

	@ResponseBody
	@RequestMapping("/list")
	public CommonResponse<AttributeResponse> showALL() {
		List<AttributeResponse> response = attributeService.listAllAttribute();
		return new CommonResponse<AttributeResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping("/findbyProductId")
	public CommonResponse<AttributeResponse> findbyProductId(
				@RequestParam(value="categoryId" , defaultValue = "0") Integer categoryId ,
				@RequestParam(value="productId", defaultValue = "0") Integer productId) {
		List<AttributeResponse> response = attributeService.findbyProductId(categoryId , productId);
		return new CommonResponse<AttributeResponse>(response);
	}

}
