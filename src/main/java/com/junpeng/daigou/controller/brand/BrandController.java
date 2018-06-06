package com.junpeng.daigou.controller.brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.brand.BrandService;

@Controller
@RequestMapping("/brand")
public class BrandController {
	
	@Autowired
	private BrandService brandService;

	@ResponseBody
	@RequestMapping("/list")
	public CommonResponse<BrandResponse> showALL() {
		List<BrandResponse> response = brandService.listAllBand();
		return new CommonResponse<BrandResponse>( response);
	}
	
	@ResponseBody
	@RequestMapping("/findbyId")
	public CommonResponse<BrandResponse> findbyId(@RequestParam(value="id" , defaultValue = "0") int id) {
		List<BrandResponse> response = brandService.findbyId(id);
		return new CommonResponse<BrandResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/addNew",method=RequestMethod.POST)
	public CommonResponse<BrandResponse> addNew(@RequestBody BrandRequest brand) {
		List<BrandResponse> response = brandService.addNew(brand);
		
		return new CommonResponse<BrandResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public CommonResponse<BrandResponse> update(@RequestBody BrandRequest brand) {
		List<BrandResponse> response = brandService.update(brand);
		
		return new CommonResponse<BrandResponse>(response);
	}
}
