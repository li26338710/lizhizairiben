package com.junpeng.daigou.service.order;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.junpeng.daigou.controller.order.OrderDetailRequest;
import com.junpeng.daigou.controller.order.OrderDetailResponse;
import com.junpeng.daigou.controller.order.OrderRequest;
import com.junpeng.daigou.controller.order.OrderResponse;
import com.junpeng.daigou.dao.OrderDetailMapper;
import com.junpeng.daigou.dao.OrderTableMapper;
import com.junpeng.daigou.model.OrderDetail;
import com.junpeng.daigou.model.OrderTable;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class OrderService {
	@Autowired
	private OrderTableMapper orderDao;
	
	@Autowired
	private OrderDetailMapper orderDetailDao;

	public List<OrderResponse> listAllOrder() {

		List<OrderTable> orders = orderDao.selectByExample(null);
		List<OrderResponse> result = combList(orders);

		return result;
	}
	
	public List<OrderResponse> findOrderByCustomerAndStatus(int idcustomer , String status , int idorder) {

		List<OrderTable> orders = orderDao.getOrderByCustomerAndStatus(idcustomer , status , idorder);
		List<OrderResponse> result = combList(orders);

		return result;
	}
	
	private List<OrderResponse> combList(List<OrderTable> orders) {
		List<OrderResponse> result = new ArrayList<OrderResponse>();

		if (Utils.isNotEmpty(orders)) {
			for (OrderTable o : orders) {
				
				result.add(saveOrderToResponse(o));
			}
		}
		return result;
	}
	
	public List<OrderResponse> addNew(OrderRequest o) throws ParseException {
		List<OrderResponse> result = new ArrayList<OrderResponse>();
		OrderTable order = saveRequestToOrder(o);
		
		int r = orderDao.insertSelective(order);
		
		if(r > 0){
			r = updateSumprice(order.getIdorder());
			
			order = orderDao.getOrderByCustomerAndStatus( order.getIdcustomer() , null , order.getIdorder()).get(0);
			
			result.add(saveOrderToResponse(order));
		}
		return result;
	}

	public List<OrderResponse> update(OrderRequest o) throws ParseException {
		List<OrderResponse> result = new ArrayList<OrderResponse>();
		OrderTable order = saveRequestToOrder(o);
		
		int r = orderDao.updateByPrimaryKeySelective(order);
		
		if(r > 0){
			r = updateSumprice(order.getIdorder());
			
			order = orderDao.getOrderByCustomerAndStatus(0 , null , order.getIdorder()).get(0);
			
			result.add(saveOrderToResponse(order));
		}
		return result;
	}
	
	private OrderTable saveRequestToOrder(OrderRequest o) throws ParseException {
		
		OrderTable order = new OrderTable();
		
		order.setIdorder(Utils.isNotEmpty(o.getOrderId())?Integer.parseInt(o.getOrderId()) : null);
		order.setIdcustomer(Integer.parseInt(o.getCustomerId()));
		order.setBookdate(o.getBookDate());
		order.setDeposit(o.getDeposit());
		order.setDeposittype(o.getDepositType());
		order.setPayment(o.getPayment());
		order.setPaymenttype(o.getPaymentType());
		order.setPostprice(o.getPostprice());
		order.setStatus(o.getStatus());
		
		return order;
	}
	
	private OrderResponse saveOrderToResponse(OrderTable o){
		
		OrderResponse or = new OrderResponse();
		
		double deposit = Utils.convDoubleToRoundDouble(o.getDeposit().doubleValue());
		double payment = Utils.convDoubleToRoundDouble(o.getPayment().doubleValue());
		double postprice = Utils.convDoubleToRoundDouble(o.getPostprice().doubleValue());
		
		
		double sumprofit = Utils.convDoubleToRoundDouble(o.getSumprofit());
		
		//double sumprice = deposit + payment + postprice + remaindprice;
//		double remaindprice = Utils.convDoubleToRoundDouble(o.getRemaindprice());
		
		double sumprice =  Utils.convDoubleToRoundDouble(o.getSumprice());
		
		double remaindprice =  Utils.convDoubleToRoundDouble(sumprice - deposit - payment);
		
		or.setWxid(o.getWxid());
		or.setCustomerId(o.getIdcustomer().toString());
		or.setBookDate(Utils.convDateToString(o.getBookdate()));
		or.setCustomerName(o.getCustomerName());
		or.setCustomerId(o.getIdcustomer().toString());
		or.setDeposit(deposit);
		or.setDepositType(o.getDeposittype());
		or.setOrderId(String.valueOf(o.getIdorder()));
		or.setPayment(payment);
		or.setPaymentType(o.getPaymenttype());
		or.setPostprice(postprice);
		
		or.setRemaindprice(remaindprice);
		
		or.setSumprice(sumprice);
		
		or.setSumprofit(sumprofit);
		or.setStatus(o.getStatus());
		or.setStatusStr(o.getStatusStr());
		
		return or;
	}
	
	// ------------Order Detail----------------------------------------------------
	
	
	public List<OrderDetailResponse> findOrderByOrderId(Integer orderId , Integer customerId , String status , Integer productId) {
		List<OrderDetail> orderDetails = orderDao.getOrderByOrderId(orderId , 0 , customerId , status , productId);
		List<OrderDetailResponse> result = combDetailList(orderDetails);

		return result;
	}
	
	private List<OrderDetailResponse> combDetailList(List<OrderDetail> orderDetail) {
		List<OrderDetailResponse> result = new ArrayList<OrderDetailResponse>();

		if (Utils.isNotEmpty(orderDetail)) {
			for (OrderDetail o : orderDetail) {
				
				result.add(saveOrderDetailToResponse(o));
			}
		}
		return result;
	}

	private OrderDetailResponse saveOrderDetailToResponse(OrderDetail o) {
		OrderDetailResponse odr = new OrderDetailResponse();
		double bookPrice = o.getBookprice().doubleValue();
		double bookRate = o.getBookrate().doubleValue();
		int count = o.getCount();
		
		odr.setBookPrice(Utils.convDoubleToRoundDouble(bookPrice));
		odr.setBookPriceJpy(Utils.convDoubleToRoundDouble(bookPrice / bookRate));
		odr.setBookRate(Utils.convDoubleToRoundDouble(bookRate));
		
		odr.setBookPriceSum(Utils.convDoubleToRoundDouble(bookPrice * count));
		
		double estiBookPrice = o.getEsticostprice().doubleValue();
		odr.setEstiBookPrice(Utils.convDoubleToRoundDouble(estiBookPrice));
		odr.setEstiBookPriceJpy(Utils.convDoubleToRoundDouble(estiBookPrice / bookRate));
		
		double costPrice = o.getCostprice().doubleValue();
		double costRate = o.getCostrate().doubleValue();
		odr.setCostPrice(Utils.convDoubleToRoundDouble(o.getCostprice().doubleValue()));
		odr.setCostPriceJpy(Utils.convDoubleToRoundDouble(costPrice / costRate));
		
		odr.setCostRate(Utils.convDoubleToRoundDouble(costRate));
		
		double profit = o.getProfit().doubleValue();
		odr.setProfit(Utils.convDoubleToRoundDouble(profit));
		
		
		odr.setOrderDetailId(String.valueOf(o.getIdorderdetail()));
		odr.setProductId(String.valueOf(o.getIdproduct()));
		odr.setProductName(o.getProductname());
		odr.setOrderId(String.valueOf(o.getIdorder()));
		odr.setStatus(o.getStatus());
		odr.setCount(count);
		odr.setBookDate(Utils.convDateToString(o.getBookdate()));
		
		odr.setStatusStr(o.getStatusvalue());
		
		odr.setCustomerId(String.valueOf(o.getIdcustomer()));
		odr.setCustomerName(o.getCustomername());
		
		return odr;
	}

	public List<OrderDetailResponse> addNewDetail(OrderDetailRequest o) throws ParseException {
		List<OrderDetailResponse> result = new ArrayList<OrderDetailResponse>();

		OrderDetail order = saveRequestToOrderDetail(o);
		
		if(StringUtils.isEmpty(order.getIdorder())){
			order.setIdorder(checkOrderId(order));
		}
		
		int r = orderDetailDao.insertSelective(order);
		
		if(r > 0){
			r = updateOrder(order.getIdorder());
			
			order = orderDao.getOrderByOrderId(order.getIdorder() , order.getIdorderdetail() , 0 , null, 0).get(0);
			
			result.add(saveOrderDetailToResponse(order));
		}
		return result;
	}

	private Integer checkOrderId(OrderDetail order) {
		
		List<OrderTable> orderList = orderDao.getOrderByCustomerAndStatus(order.getIdcustomer(), "0", 0);
		Integer orderId = 0;
		if (orderList.size()<1){
			OrderTable record = new OrderTable();
			record.setBookdate(new Date());
			record.setIdcustomer(order.getIdcustomer());
			record.setDeposit(0.0);
			record.setDeposittype("0");
			record.setPayment(0.0);
			record.setPaymenttype("0");
			record.setPostprice(0.0);
			record.setRemaindprice(0.0);
			record.setStatus("0");
			
			
			orderDao.insertSelective(record);
			orderId = record.getIdorder();
		}else{
			orderId = orderList.get(0).getIdorder();
		}
		// TODO Auto-generated method stub
		return orderId;
	}

	public List<OrderDetailResponse> updateDetail(OrderDetailRequest o) throws ParseException {
		List<OrderDetailResponse> result = new ArrayList<OrderDetailResponse>();

		OrderDetail order = saveRequestToOrderDetail(o);
		
		int r = orderDetailDao.updateByPrimaryKeySelective(order);
		
		if(r > 0){
			r = updateOrder(order.getIdorder());
			
			order = orderDao.getOrderByOrderId(order.getIdorder() , order.getIdorderdetail() , 0 , null, 0).get(0);
			
			result.add(saveOrderDetailToResponse(order));
		}
		return result;
	}

	private int updateOrder(Integer orderId){
		
		int r = 0;
		
		r = updateSumprice(orderId);
		
		r = updateProfit(orderId);
		
		return r;
	}
	private OrderDetail saveRequestToOrderDetail(OrderDetailRequest o) throws ParseException {
		OrderDetail order = new OrderDetail();
		
		double bookPrice = o.getBookPrice();
		double bookRate = o.getBookRate();
		double costPriceJpy = o.getCostPriceJpy();
		double costRate = o.getCostRate();
		double costPrice = costPriceJpy * costRate;
		
		int count = o.getCount();
		double estiBookPriceJpy = o.getEstiBookPriceJpy();
		double estiBookPrice = estiBookPriceJpy * bookRate;
		double profit = (bookPrice - costPrice) * count;
		order.setIdcustomer(Utils.isNotEmpty(o.getCustomerId())?Integer.parseInt(o.getCustomerId()) : null);
		order.setIdorder(Utils.isNotEmpty(o.getOrderId())?Integer.parseInt(o.getOrderId()) : null);
		order.setBookprice(bookPrice);
		order.setBookdate(o.getBookDate());
		order.setBookrate(bookRate);
		order.setCostprice(costPrice);
		order.setCostrate(costRate);
		order.setCount(count);
		order.setEsticostprice(estiBookPrice);
		order.setIdorderdetail(Utils.isNotEmpty(o.getOrderDetailId())?Integer.valueOf(o.getOrderDetailId()) : null);
		order.setIdproduct(Integer.valueOf(o.getProductId()));
		order.setStatus(o.getStatus());
		order.setProfit(profit);
		
		
		return order;
	}
	
	private int updateProfit(int orderId){
		
		int result = orderDao.udpateSumprofit(orderId);
		
		return result;
	}
	
	private int updateSumprice(int idorder) {
		
		int result = orderDao.updateSumprice(idorder);
		
		return result;
	}
	
}
