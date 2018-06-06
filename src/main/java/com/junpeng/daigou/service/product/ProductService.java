package com.junpeng.daigou.service.product;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.product.ProductRequest;
import com.junpeng.daigou.controller.product.ProductResponse;
import com.junpeng.daigou.dao.ProductMapper;
import com.junpeng.daigou.model.Product;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class ProductService {

	@Autowired
	private ProductMapper productDao;

//	public List<ProductResponse> listAllProduct() {
//
//		List<Product> products = productDao.selectByExample(null);
//		List<ProductResponse> result = combList(products);
//
//		return result;
//	}

	public List<ProductResponse> findbyId(int id) {

		List<Product> products = new ArrayList<Product>();
		Product product = productDao.selectByPrimaryKey(new Integer(id));
		products.add(product);
		List<ProductResponse> result = combList(products);

		return result;
	}

	public List<ProductResponse> findbyCategoryIdOrBrandId(Integer idcategory , Integer idbrand) {

		List<Product> products = productDao.selectByCategoryIdOrBrandId(idcategory , idbrand);
		List<ProductResponse> result = combList(products);
		
		return result;
	}

	private List<ProductResponse> combList(List<Product> products) {
		List<ProductResponse> result = new ArrayList<ProductResponse>();

		if (Utils.isNotEmpty(products)) {
			for (Product p : products) {
				result.add(saveProductToResponse(p));
			}
		}

		return result;
	}

	public List<ProductResponse> addNew(ProductRequest p) {
		List<ProductResponse> result = new ArrayList<ProductResponse>();
		Product product = saveRequestToProduct(p);
		
		int r = productDao.insertSelective(product);
		
		if(r > 0){
			product = productDao.selectByPrimaryKey(product.getIdproduct());
			
			result.add(saveProductToResponse(product));
		}
		return result;
	}

	public List<ProductResponse> update(ProductRequest p) {
		List<ProductResponse> result = new ArrayList<ProductResponse>();
		Product product = saveRequestToProduct(p);
		
		product.setIdproduct(Integer.valueOf(p.getProductId()));
		int r = productDao.updateByPrimaryKeySelective(product);
		
		if(r > 0){
			product = productDao.selectByPrimaryKey(product.getIdproduct());
			
			result.add(saveProductToResponse(product));
		}
		return result;
	}
	
	private ProductResponse saveProductToResponse(Product product){
		ProductResponse pr = new ProductResponse();
		
		double officalPrice = Utils.convDoubleToRoundDouble(product.getOfficalprice());
		
		// 0 免税价格    1含税价格
		String isTax = product.getIstax();
		double discount = product.getDiscount().doubleValue();
		double taxFee = product.getTaxfee().doubleValue();
		
		int weight = product.getWeight();
		
//		double costPrice = Double.parseDouble(Utils.convDouble((officalPrice / (1 + taxFee + (0.08 * Integer.valueOf(isTax)))) * discount));

		double costPrice = product.getCostpricejpy();

		double costPriceRmb = product.getCostprice();
		
		pr.setBrandId(String.valueOf(product.getIdbrand()));
		pr.setBrandName(product.getBrandname());
		pr.setCategoryId(String.valueOf(product.getIdcategory()));
		pr.setCategoryName(product.getCategoryname());
		pr.setIstax(Integer.valueOf(isTax));
		pr.setOfficalPrice(officalPrice);
		pr.setProductId(String.valueOf(product.getIdproduct()));
		pr.setProductName(product.getProductname());
		pr.setProductNameJapan(product.getProductnamejapan());
		pr.setRecentlyBookPrice(Utils.convDoubleToRoundDouble(product.getRecentlybookprice()));
		pr.setDiscount(discount);
		pr.setTaxfee(taxFee);
		pr.setCostPrice(Utils.convDoubleToRoundDouble(costPrice));
		pr.setWeight(weight);
		pr.setCostPriceRmb(Utils.convDoubleToRoundDouble(costPriceRmb));
		pr.setIddiscountsetting(product.getIddiscountsetting().toString());
		pr.setDiscountsettingcomment(product.getDiscountsettingcomment());
		pr.setDiscountsettingname(product.getDiscountsettingname());
		
		pr.setSalePrice(product.getSaleprice());
		
		return pr;
	}
	
	private Product saveRequestToProduct(ProductRequest p){
		Product product = new Product();
		
		product.setIdproduct(p.getProductId() == null ?  null :Integer.valueOf(p.getProductId()));
		product.setIdbrand(Integer.valueOf(p.getBrandId()));
		product.setIdcategory(Integer.valueOf(p.getCategoryId()));
		product.setProductnamejapan(p.getProductNameJapan());
		product.setProductname(p.getProductName());
		product.setRecentlybookprice(p.getRecentlyBookPrice());
		
		double officalPrice = p.getOfficalPrice();
		double taxfee = p.getTaxfee();
		double discount = p.getDiscount();
		String istax = p.getIstax();
		int weight = p.getWeight();
		
		product.setOfficalprice(officalPrice);
		product.setTaxfee(taxfee);
		product.setDiscount(discount);
		
		// {{((productDetail.officalPrice / (1.0 + productDetail.taxfee + (0.08 * productDetail.istax))) * productDetail.discount) |number:2}}
		
		double costPriceJpy = (officalPrice / (1.0 + (0.08 * Integer.parseInt(istax) - taxfee))) * discount + ( weight * 0.06) / Utils.getCurrentRate();
		double costPrice = costPriceJpy * Utils.getCurrentRate();
		product.setCostprice(costPrice);
		product.setCostpricejpy(costPriceJpy);
		
		product.setWeight(weight);
		product.setUpdatetime(new Date());
		product.setUpdateuser("admin");
		product.setIsactive("1");
		product.setIstax(istax);
		
		product.setIddiscountsetting(Integer.parseInt(p.getIddiscountsetting()));
		
		product.setSaleprice(p.getSalePrice());
		
		return product;
	}

}
