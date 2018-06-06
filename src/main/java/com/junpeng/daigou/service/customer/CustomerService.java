package com.junpeng.daigou.service.customer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.customer.CustomerRequest;
import com.junpeng.daigou.controller.customer.CustomerResponse;
import com.junpeng.daigou.dao.CustomerMapper;
import com.junpeng.daigou.model.Customer;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class CustomerService {

	@Autowired
	private CustomerMapper customerDao;
	public List<CustomerResponse> listAllCustomer() {

		List<Customer> customers = customerDao.selectByExample(null);
		List<CustomerResponse> result = combList(customers);

		return result;
	}
	
	private List<CustomerResponse> combList(List<Customer> customers) {
		List<CustomerResponse> result = new ArrayList<CustomerResponse>();

		if (Utils.isNotEmpty(customers)) {
			for (Customer c : customers) {
				CustomerResponse cr = new CustomerResponse();
				
				cr.setAddress(c.getAddress());
				cr.setCredit(c.getCredit());
				cr.setCustomerId(String.valueOf(c.getIdcustomer()));
				cr.setCustomerName(c.getCustomername());
				cr.setPhone(c.getPhone());
				cr.setRecommonder(c.getRecommender());
				cr.setWxId(c.getWxid());

				result.add(cr);
			}
		}
		return result;
	}
	public List<CustomerResponse> addNew(CustomerRequest customerRequest) {
		List<CustomerResponse> result = new ArrayList<CustomerResponse>();
		Customer customer = new Customer();
		
		customer.setAddress(customerRequest.getAddress());
		customer.setCredit(customerRequest.getCredit());
		customer.setCustomername(customerRequest.getCustomerName());
		customer.setPhone(customerRequest.getPhone());
		customer.setRecommender(customerRequest.getRecommonder());
		customer.setWxid(customerRequest.getWxId());
		
//		customer.setCreatetime(new Date());
//		customer.setCreateuser("admin");
//		customer.setUpdatetime(new Date());
//		customer.setUpdateuser("admin");
//		customer.setIsactive("1");
		int r = customerDao.insertSelective(customer);
		
		if(r > 0){
			CustomerResponse br = new CustomerResponse();
			br.setAddress(customerRequest.getAddress());
			br.setCredit(customerRequest.getCredit());
			br.setCustomerName(customerRequest.getCustomerName());
			br.setCustomerId(customerRequest.getCustomerId());
			br.setPhone(customerRequest.getPhone());
			br.setRecommonder(customerRequest.getRecommonder());
			br.setWxId(customerRequest.getWxId());
			result.add(br);
		}
		return result;
	}

	public List<CustomerResponse> update(CustomerRequest customerRequest) {
		List<CustomerResponse> result = new ArrayList<CustomerResponse>();
		Customer customer = new Customer();
		
		customer.setAddress(customerRequest.getAddress());
		customer.setCredit(customerRequest.getCredit());
		customer.setCustomername(customerRequest.getCustomerName());
		customer.setIdcustomer(Integer.valueOf(customerRequest.getCustomerId()));
		customer.setPhone(customerRequest.getPhone());
		customer.setRecommender(customerRequest.getRecommonder());
		customer.setWxid(customerRequest.getWxId());
		
//		customer.setCreatetime(new Date());
//		customer.setCreateuser("admin");
//		customer.setUpdatetime(new Date());
//		customer.setUpdateuser("admin");
//		customer.setIsactive("1");
		int r = customerDao.updateByPrimaryKey(customer);
		
		if(r > 0){
			CustomerResponse br = new CustomerResponse();
			br.setAddress(customerRequest.getAddress());
			br.setCredit(customerRequest.getCredit());
			br.setCustomerName(customerRequest.getCustomerName());
			br.setCustomerId(customerRequest.getCustomerId());
			br.setPhone(customerRequest.getPhone());
			br.setRecommonder(customerRequest.getRecommonder());
			br.setWxId(customerRequest.getWxId());
			result.add(br);
		}
		return result;
	}
}
