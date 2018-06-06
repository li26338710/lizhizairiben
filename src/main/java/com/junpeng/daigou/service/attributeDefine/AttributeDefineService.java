package com.junpeng.daigou.service.attributeDefine;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.attributeDefine.AttributeDefineResponse;
import com.junpeng.daigou.dao.AttributeDefineMapper;
import com.junpeng.daigou.dao.CategoryMapper;
import com.junpeng.daigou.model.AttributeDefine;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class AttributeDefineService {


	@Autowired
	private AttributeDefineMapper attributeDefineDao;
	
	@Autowired
	private CategoryMapper categoryDao;
	
	public List<AttributeDefineResponse> listAllBand() {
		
		List<AttributeDefine> attributeDefines = attributeDefineDao.selectByExample(null);
		List<AttributeDefineResponse> result = combList(attributeDefines);
		
		return result;
	}

	public List<AttributeDefineResponse> findbyId(int id) {
		
		List<AttributeDefine> attributeDefines = new ArrayList<AttributeDefine>();
		AttributeDefine attributeDefine = attributeDefineDao.selectByPrimaryKey(new Integer(id));
		attributeDefines.add(attributeDefine);
		List<AttributeDefineResponse> result = combList(attributeDefines);
		
		return result;
	}
	
	public List<AttributeDefineResponse> findbyCategoryId(int id) {
		
		List<AttributeDefine> attributeDefine = categoryDao.getAttributeDefByCatgoryId(id);
		List<AttributeDefineResponse> result = new ArrayList<AttributeDefineResponse>();
		
		if(Utils.isNotEmpty(attributeDefine)){
			for(AttributeDefine c : attributeDefine){
				AttributeDefineResponse cr = new AttributeDefineResponse();
				
				cr.setAttributeDefineId(String.valueOf(c.getIdattributedefine()));
				cr.setAttributeName(c.getAttributename());
				cr.setCategoryId(String.valueOf(c.getIdcategory()));
				cr.setCategoryName(c.getCategoryname());
				
				result.add(cr);
			}
		}
		return result;
	}
	
	
	private List<AttributeDefineResponse>  combList(List<AttributeDefine> attributeDefines){
		List<AttributeDefineResponse> result = new ArrayList<AttributeDefineResponse>();
		
		if(Utils.isNotEmpty(attributeDefines)){
			for(AttributeDefine ad : attributeDefines){
				AttributeDefineResponse adr = new AttributeDefineResponse();
				adr.setAttributeDefineId(String.valueOf(ad.getIdattributedefine()));
				adr.setAttributeName(ad.getAttributename());
				adr.setCategoryId(String.valueOf(ad.getIdcategory()));
				
				result.add(adr);
			}
		}
		
		return result;
	}
	
}
