package com.junpeng.daigou.service.discount;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.discount.DiscountSettingResponse;
import com.junpeng.daigou.dao.DiscountSettingMapper;
import com.junpeng.daigou.model.DiscountSetting;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class DiscountSettingService {

	@Autowired
	private DiscountSettingMapper discountSettingMapper;
	
	public List<DiscountSettingResponse> listAllDiscount() {
		
		List<DiscountSetting> discountsettings = discountSettingMapper.selectByExample(null);
		List<DiscountSettingResponse> result = combList(discountsettings);
		
		return result;
	}
	
	private List<DiscountSettingResponse>  combList(List<DiscountSetting> discountsettings){
		List<DiscountSettingResponse> result = new ArrayList<DiscountSettingResponse>();
		
		if(Utils.isNotEmpty(discountsettings)){
			for(DiscountSetting b : discountsettings){
				DiscountSettingResponse br = new DiscountSettingResponse();
				
				br.setDiscount(String.valueOf(Utils.convDoubleToRoundDouble(b.getDiscount())));
				br.setDiscountSettingComment(b.getDiscountsettingcomment());
				br.setDiscountSettingName(b.getDiscountsettingname());
				br.setIdDiscountSetting(b.getIddiscountsetting().toString());
				
				result.add(br);
			}
		}
		
		return result;
	}

}
