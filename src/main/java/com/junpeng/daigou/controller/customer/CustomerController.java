package com.junpeng.daigou.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.customer.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@ResponseBody
	@RequestMapping("/list")
	public CommonResponse<CustomerResponse> showALL() {
		List<CustomerResponse> response = customerService.listAllCustomer();
		return new CommonResponse<CustomerResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/addNew",method=RequestMethod.POST)
	public CommonResponse<CustomerResponse> addNew(@RequestBody CustomerRequest customer) {
		List<CustomerResponse> response = customerService.addNew(customer);
		
		return new CommonResponse<CustomerResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public CommonResponse<CustomerResponse> update(@RequestBody CustomerRequest customer) {
		List<CustomerResponse> response = customerService.update(customer);
		
		return new CommonResponse<CustomerResponse>(response);
	}
}
