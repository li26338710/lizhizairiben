package com.junpeng.daigou.controller.market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.market.MarketService;

@Controller
@RequestMapping("/market")
public class MarketControllet {

	@Autowired
	private MarketService marketService;
	
	@ResponseBody
	@RequestMapping("/findMarket")
	public CommonResponse<MarketResponse> findOrderByOrderId() {
		List<MarketResponse> response = marketService.listAllMarket();
		return new CommonResponse<MarketResponse>(response);
	}
}
