package com.junpeng.daigou.service.purchase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.purchase.PurchaseDetailRequest;
import com.junpeng.daigou.controller.purchase.PurchaseDetailResponse;
import com.junpeng.daigou.controller.purchase.PurchaseRequest;
import com.junpeng.daigou.controller.purchase.PurchaseResponse;
import com.junpeng.daigou.controller.purchase.PurchasingProductResponse;
import com.junpeng.daigou.dao.PurchaseDetailMapper;
import com.junpeng.daigou.dao.PurchaseMapper;
import com.junpeng.daigou.model.Purchase;
import com.junpeng.daigou.model.PurchaseDetail;
import com.junpeng.daigou.model.PurchasingProduct;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class PurchaseService {

	@Autowired
	private PurchaseMapper purchaseDao;
	
	@Autowired
	private PurchaseDetailMapper purchaseDetailDao;
	
	public List<PurchaseResponse> findPurchaseByBrandOrDate(Integer marketId, Date startDate) {

		List<Purchase> purchases = purchaseDao.getPurchaseByBrandOrDate(marketId , startDate , 0);
		List<PurchaseResponse> result = combList(purchases);

		return result;
	}

	public List<PurchaseDetailResponse> findPurchaseByPurchaseId(Integer purchaseId ,Integer productId, Integer marketId, Integer brandId) {
		List<PurchaseDetail> purchaseDetails = purchaseDao.getPurchaseByPurchaseId(purchaseId, productId, marketId, brandId , 0);
		List<PurchaseDetailResponse> result = new ArrayList<PurchaseDetailResponse>();
		if (Utils.isNotEmpty(purchaseDetails)) {
			for (PurchaseDetail p : purchaseDetails) {
				
				result.add(savePurchaseDetailToResponse(p));
			}
		}
		return result;
	}

	private List<PurchaseResponse> combList(List<Purchase> purchases) {
		List<PurchaseResponse> result = new ArrayList<PurchaseResponse>();

		if (Utils.isNotEmpty(purchases)) {
			for (Purchase p : purchases) {
				
				
				result.add(savePurchaseToResponse(p));
			}
		}
		return result;
	}

	public List<PurchaseResponse> addNew(PurchaseRequest p) {
		List<PurchaseResponse> result = new ArrayList<PurchaseResponse>();
		Purchase purchase = saveRequestToPurchase(p);
		
		int r = purchaseDao.insertSelective(purchase);
		
		if(r > 0){
			purchase = purchaseDao.getPurchaseByBrandOrDate(0 , null , purchase.getIdpurchase()).get(0);
			
			result.add(savePurchaseToResponse(purchase));
		}
		return result;
	}

	public List<PurchaseResponse> update(PurchaseRequest p) {
		List<PurchaseResponse> result = new ArrayList<PurchaseResponse>();
		Purchase purchase = saveRequestToPurchase(p);
		
		int r = purchaseDao.updateByPrimaryKeySelective(purchase);
		
		if(r > 0){
			purchase = purchaseDao.getPurchaseByBrandOrDate(0 , null , purchase.getIdpurchase()).get(0);
			
			result.add(savePurchaseToResponse(purchase));
		}
		return result;
	}
	
	private Purchase saveRequestToPurchase(PurchaseRequest p) {
		
		Purchase purchase = new Purchase();
		
		purchase.setIdbrand(Integer.parseInt(p.getBrandId()));
		purchase.setCardno(p.getCardNo());
		purchase.setTotalprice(p.getPrice());
		purchase.setPurchasedate(p.getPurchaseDate());
		purchase.setIdpurchase(p.getPurchaseId() == null ?  null :Integer.valueOf(p.getPurchaseId()));
		purchase.setPurchasetype(p.getPurchaseType());
		purchase.setRate(p.getRate());
		purchase.setUsescore(p.getScore());
		
		return purchase;
	}
	
	private PurchaseResponse savePurchaseToResponse(Purchase p){
		
		PurchaseResponse pr = new PurchaseResponse();
		
		double rate = p.getRate();
		double price = p.getTotalprice();
		pr.setMarketId(String.valueOf(p.getIdmarket()));
		pr.setMarketName(p.getMarketname());
//		pr.setBrandId(String.valueOf(p.getIdbrand()));
//		pr.setBrandName(p.getBrandname());
		pr.setCardNo(p.getCardno());
		pr.setPurchaseDate(Utils.convDateToString(p.getPurchasedate()));
		pr.setPurchaseId(String.valueOf(p.getIdpurchase()));
		
		pr.setPurchaseType(p.getPurchasetype());
		pr.setRate(Utils.convDoubleToRoundDouble(rate));
		pr.setScore(p.getUsescore());
		pr.setPrice(Utils.convDoubleToRoundDouble(price));
		
		pr.setPriceRmb(Utils.convDoubleToRoundDouble(price*rate*0.01));
		
		return pr;
		
	}
	
	
	
//	---------------------------purchase Detail---------------------------	
	
	private PurchaseDetailResponse savePurchaseDetailToResponse(PurchaseDetail p){
		
		PurchaseDetailResponse pr = new PurchaseDetailResponse();
		pr.setCount(p.getCount());
		pr.setGetScore(p.getGetscore());
		pr.setProductId(String.valueOf(p.getIdproduct()));
		pr.setProductName(p.getProductname());
		pr.setPurchaseDetailId(String.valueOf(p.getIdpurchasedetail()));
		pr.setRate(Utils.convDoubleToRoundDouble(p.getRate()));
		pr.setSinglePrice(Utils.convDoubleToRoundDouble(p.getSingleprice().doubleValue()));
		pr.setSumPrice(Utils.convDoubleToRoundDouble(p.getSumprice().doubleValue()));
		pr.setPurchaseId(String.valueOf(p.getIdpurchase()));
		
		pr.setSinglePriceJpy(Utils.convDoubleToRoundDouble(p.getSingleprice() * p.getRate() * 0.01));
		
		pr.setSumPriceJpy(Utils.convDoubleToRoundDouble(p.getSumprice() * p.getRate() * 0.01));
		pr.setBrandId(String.valueOf(p.getIdbrand()));
		pr.setBrandName(p.getBrandName());
		
		pr.setMarketId(String.valueOf(p.getIdmarket()));
		pr.setMarketName(p.getMarketName());
		return pr;
		
	}

	
	// --------------------------purchasing------------------------------
	
	private PurchasingProductResponse getPurchasingProduct(){
		List<PurchasingProduct> list = purchaseDao.getProductGroupByStatusForCount();
		return null;
	}
	
	private PurchasingProductResponse savePurchasingToResponse(PurchasingProduct p){
		PurchasingProductResponse response = new PurchasingProductResponse();
		
		
		return response;
		
	}

	public List<PurchaseDetailResponse> addNewPurchaseDetail(PurchaseDetailRequest pdr) {
		List<PurchaseDetailResponse> result = new ArrayList<PurchaseDetailResponse>();
		PurchaseDetail purchaseDetail = saveRequestToPurchaseDetail(pdr);
		
		int r = purchaseDetailDao.insertSelective(purchaseDetail);
		
		if(r > 0){
			purchaseDetail = purchaseDao.getPurchaseByPurchaseId(0, 0, 0, 0,purchaseDetail.getIdpurchasedetail()).get(0);
			
			result.add(savePurchaseDetailToResponse(purchaseDetail));
		}
		return result;
	}

	public List<PurchaseDetailResponse> updatePurchaseDetail(PurchaseDetailRequest pdr) {
		List<PurchaseDetailResponse> result = new ArrayList<PurchaseDetailResponse>();
		PurchaseDetail purchaseDetail = saveRequestToPurchaseDetail(pdr);
		
		int r = purchaseDetailDao.updateByPrimaryKeySelective(purchaseDetail);
		
		if(r > 0){
			purchaseDetail = purchaseDao.getPurchaseByPurchaseId(0, 0, 0, 0,purchaseDetail.getIdpurchasedetail()).get(0);
			
			result.add(savePurchaseDetailToResponse(purchaseDetail));
		}
		return result;
	}
	

	private PurchaseDetail saveRequestToPurchaseDetail(PurchaseDetailRequest pdr) {
		PurchaseDetail purchaseDetail = new PurchaseDetail();

		purchaseDetail.setIdbrand(Integer.parseInt(pdr.getBrandId()));
		purchaseDetail.setIdproduct(Integer.parseInt(pdr.getProductId()));
		purchaseDetail.setIdmarket(Integer.parseInt(pdr.getMarketId()));
		purchaseDetail.setSingleprice(pdr.getSinglePrice());
		purchaseDetail.setRate(pdr.getRate());
		purchaseDetail.setIdpurchase(pdr.getPurchaseId() == null ?  null :Integer.valueOf(pdr.getPurchaseId() ));
		purchaseDetail.setCount(pdr.getCount());
		purchaseDetail.setIdpurchasedetail(pdr.getPurchaseDetailId() == null ?  null :Integer.valueOf(pdr.getPurchaseDetailId() ));
		purchaseDetail.setSumprice(pdr.getSinglePrice() * pdr.getCount());
		
		return purchaseDetail;
	}
	
}
