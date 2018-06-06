package com.junpeng.daigou.controller.order;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.order.OrderService;

@Controller
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	
	@ResponseBody
	@RequestMapping("/findOrderByCustomerAndStatus")
	public CommonResponse<OrderResponse> findOrderByCustomerAndStatus(
				@RequestParam(value="customerId" , defaultValue = "0") Integer customerId ,
				@RequestParam(value="status", defaultValue = "") String status) {
		List<OrderResponse> response = orderService.findOrderByCustomerAndStatus(customerId , status , 0);
		return new CommonResponse<OrderResponse>(response);
	}
	
	
	@ResponseBody
	@RequestMapping("/findbyOrderId")
	public CommonResponse<OrderDetailResponse> findOrderByOrderId(
			@RequestParam(value="orderId" , defaultValue = "0") Integer orderId ,
			@RequestParam(value="customerId" , defaultValue = "0") Integer customerId ,
			@RequestParam(value="status" , defaultValue = "") String status,
			@RequestParam(value="productId" , defaultValue = "0") Integer productId) {
		List<OrderDetailResponse> response = orderService.findOrderByOrderId(orderId ,customerId ,status,productId);
		return new CommonResponse<OrderDetailResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/addNew",method=RequestMethod.POST)
	public CommonResponse<OrderResponse> addNew(@RequestBody OrderRequest order) throws ParseException {
		List<OrderResponse> response = orderService.addNew(order);
		
		return new CommonResponse<OrderResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public CommonResponse<OrderResponse> update(@RequestBody OrderRequest order) throws ParseException {
		List<OrderResponse> response = orderService.update(order);
		
		return new CommonResponse<OrderResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/addNewDetail",method=RequestMethod.POST)
	public CommonResponse<OrderDetailResponse> addNewDetail(@RequestBody OrderDetailRequest orderDetail) throws ParseException {
		List<OrderDetailResponse> response = orderService.addNewDetail(orderDetail);
		
		return new CommonResponse<OrderDetailResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/updateDetail",method=RequestMethod.POST)
	public CommonResponse<OrderDetailResponse> updateDetail(@RequestBody  OrderDetailRequest orderDetail) throws ParseException {
		List<OrderDetailResponse> response = orderService.updateDetail(orderDetail);
		
		return new CommonResponse<OrderDetailResponse>(response);
	}
	
}
