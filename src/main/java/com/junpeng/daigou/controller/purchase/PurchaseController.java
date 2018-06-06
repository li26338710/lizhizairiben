package com.junpeng.daigou.controller.purchase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junpeng.daigou.common.CommonResponse;
import com.junpeng.daigou.service.purchase.PurchaseService;
import com.junpeng.daigou.utils.Utils;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

	@Autowired
	private PurchaseService purchaseService;

	@ResponseBody
	@RequestMapping("/list")
	public CommonResponse<PurchaseResponse> showALL() {
		List<PurchaseResponse> response = purchaseService.findPurchaseByBrandOrDate(0 , null);
		return new CommonResponse<PurchaseResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping("/findPurchaseByBrandOrDate")
	public CommonResponse<PurchaseResponse> findPurchaseByBrandOrDate(
				@RequestParam(value="marketId" , defaultValue = "0") Integer marketId ,
				@RequestParam(value="startDate" , defaultValue = "") String startDate) {
		List<PurchaseResponse> response = purchaseService.findPurchaseByBrandOrDate(marketId , Utils.convStringToDate(startDate));
		return new CommonResponse<PurchaseResponse>(response);
	}
	
	
	@ResponseBody
	@RequestMapping("/findbyPurchaseId")
	public CommonResponse<PurchaseDetailResponse> findPurchaseByPurchaseId(
				@RequestParam(value="purchaseId" , defaultValue = "0") Integer purchaseId ,
				@RequestParam(value="productId" , defaultValue = "0") Integer productId ,
				@RequestParam(value="marketId" , defaultValue = "0") Integer marketId ,
				@RequestParam(value="brandId" , defaultValue = "0") Integer brandId ) {
		List<PurchaseDetailResponse> response = purchaseService.findPurchaseByPurchaseId(purchaseId, productId, marketId, brandId);
		return new CommonResponse<PurchaseDetailResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/addNew",method=RequestMethod.POST)
	public CommonResponse<PurchaseResponse> addNew(@RequestBody PurchaseRequest purchase) {
		List<PurchaseResponse> response = purchaseService.addNew(purchase);
		
		return new CommonResponse<PurchaseResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public CommonResponse<PurchaseResponse> update(@RequestBody PurchaseRequest purchase) {
		List<PurchaseResponse> response = purchaseService.update(purchase);
		
		return new CommonResponse<PurchaseResponse>(response);
	}
	
	/* -------------------------------------------- */
	
	@ResponseBody
	@RequestMapping(value="/addNewPurchaseDetail",method=RequestMethod.POST)
	public CommonResponse<PurchaseDetailResponse> addNewPurchaseDetail(@RequestBody PurchaseDetailRequest purchaseDetail) {
		List<PurchaseDetailResponse> response = purchaseService.addNewPurchaseDetail(purchaseDetail);
		
		return new CommonResponse<PurchaseDetailResponse>(response);
	}
	
	@ResponseBody
	@RequestMapping(value="/updatePurchaseDetail",method=RequestMethod.POST)
	public CommonResponse<PurchaseDetailResponse> updatePurchaseDetail(@RequestBody PurchaseDetailRequest purchaseDetail) {
		List<PurchaseDetailResponse> response = purchaseService.updatePurchaseDetail(purchaseDetail);
		
		return new CommonResponse<PurchaseDetailResponse>(response);
	}
	
}
