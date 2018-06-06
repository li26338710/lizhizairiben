package com.junpeng.daigou.service.attribute;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.attribute.AttributeResponse;
import com.junpeng.daigou.dao.AttributeMapper;
import com.junpeng.daigou.model.Attribute;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class AttributeService {
	@Autowired
	private AttributeMapper attributeDao;

	public List<AttributeResponse> listAllAttribute() {

		List<Attribute> attributes = attributeDao.selectByExample(null);
		List<AttributeResponse> result = combList(attributes);

		return result;
	}
	public List<AttributeResponse> findbyProductId(Integer idcategory , Integer idproduct) {

		List<Attribute> attributes = attributeDao.selectAttributeByProductId(idcategory , idproduct);
		List<AttributeResponse> result = combList(attributes);
		
		return result;
	}

	private List<AttributeResponse> combList(List<Attribute> attributes) {
		List<AttributeResponse> result = new ArrayList<AttributeResponse>();

		if (Utils.isNotEmpty(attributes)) {
			for (Attribute a : attributes) {
				AttributeResponse ar = new AttributeResponse();
				
				ar.setAttributeId(String.valueOf(a.getIdattribute()));
				ar.setAttributeName(a.getAttributename());
				ar.setValue(a.getValue());

				result.add(ar);
			}
		}

		return result;
	}

}
