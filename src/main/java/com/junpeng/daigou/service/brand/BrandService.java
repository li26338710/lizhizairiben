package com.junpeng.daigou.service.brand;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.brand.BrandRequest;
import com.junpeng.daigou.controller.brand.BrandResponse;
import com.junpeng.daigou.dao.BrandMapper;
import com.junpeng.daigou.model.Brand;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class BrandService {

	@Autowired
	private BrandMapper brandDao;
	
	public List<BrandResponse> listAllBand() {
		
		List<Brand> brands = brandDao.selectByExample(null);
		List<BrandResponse> result = combList(brands);
		
		return result;
	}

	public List<BrandResponse> findbyId(int id) {
		
		List<Brand> brands = new ArrayList<Brand>();
		Brand brand = brandDao.selectByPrimaryKey(new Integer(id));
		brands.add(brand);
		List<BrandResponse> result = combList(brands);
		
		return result;
	}
	
	private List<BrandResponse>  combList(List<Brand> brands){
		List<BrandResponse> result = new ArrayList<BrandResponse>();
		
		if(Utils.isNotEmpty(brands)){
			for(Brand b : brands){
				BrandResponse br = new BrandResponse();
				br.setBrandId(String.valueOf(b.getIdbrand()));
				br.setBrandName(b.getBrandname());
				br.setType(b.getType().equals("0")? "官网":b.getType().equals("1")?"电商":b.getType().equals("2")?"官网+电商":"其他");
				br.setUrl(b.getUrl());
				
				result.add(br);
			}
		}
		
		return result;
	}

	public List<BrandResponse> addNew(BrandRequest b) {
		
		List<BrandResponse> result = new ArrayList<BrandResponse>();
		Brand brand = new Brand();
		brand.setBrandname(b.getBrandName());
		brand.setType(b.getType());
		brand.setUrl(b.getUrl());
		brand.setCreatetime(new Date());
		brand.setCreateuser("admin");
		brand.setUpdatetime(new Date());
		brand.setUpdateuser("admin");
		brand.setIsactive("1");
		int r = brandDao.insertSelective(brand);
		
		if(r > 0){
			BrandResponse br = new BrandResponse();
			br.setBrandId(String.valueOf(brand.getIdbrand()));
			br.setType(brand.getType());
			br.setBrandName(brand.getBrandname());
			br.setUrl(brand.getUrl());
			result.add(br);
		}
		return result;
	}

	public List<BrandResponse> update(BrandRequest b) {

		List<BrandResponse> result = new ArrayList<BrandResponse>();
		Brand brand = new Brand();
		brand.setIdbrand(Integer.valueOf(b.getBrandId()));
		brand.setBrandname(b.getBrandName());
		brand.setType(b.getType());
		brand.setUrl(b.getUrl());
		brand.setUpdatetime(new Date());
		brand.setUpdateuser("admin");
		brand.setIsactive("1");
		int r = brandDao.updateByPrimaryKey(brand);
		
		if(r > 0){
			BrandResponse br = new BrandResponse();
			br.setBrandId(String.valueOf(brand.getIdbrand()));
			br.setType(brand.getType());
			br.setBrandName(brand.getBrandname());
			br.setUrl(brand.getUrl());
			result.add(br);
		}
		return result;
	}

}
