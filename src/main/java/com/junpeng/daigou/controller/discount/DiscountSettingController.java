package com.junpeng.daigou.controller.discount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.discount.DiscountSettingService;

@Controller
@RequestMapping("/discountSetting")
public class DiscountSettingController {
	
	@Autowired
	private DiscountSettingService discountSettingService;

	@ResponseBody
	@RequestMapping("/list")
	public CommonResponse<DiscountSettingResponse> showALL() {
		List<DiscountSettingResponse> response = discountSettingService.listAllDiscount();
		return new CommonResponse<DiscountSettingResponse>( response);
	}

}
