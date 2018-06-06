package com.junpeng.daigou.service.market;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.junpeng.daigou.controller.market.MarketResponse;
import com.junpeng.daigou.dao.MarketMapper;
import com.junpeng.daigou.model.Market;
import com.junpeng.daigou.utils.Utils;

@Service
@Component
public class MarketService {

	@Autowired
	private MarketMapper marketDao;
	

	public List<MarketResponse> listAllMarket() {

		List<Market> markets = marketDao.selectByExample(null);
		List<MarketResponse> result = combList(markets);

		return result;
	}


	private List<MarketResponse> combList(List<Market> markets) {
		List<MarketResponse> result = new ArrayList<MarketResponse>();

		if (Utils.isNotEmpty(markets)) {
			for (Market m : markets) {
				
				result.add(saveOrderToResponse(m));
			}
		}
		return result;
	}


	private MarketResponse saveOrderToResponse(Market m) {
		
		MarketResponse mr = new MarketResponse();
		
		mr.setMarketId(String.valueOf(m.getIdmarket()));
		mr.setMarketName(m.getMarketname());
		mr.setComment(m.getComment());
		
		return mr;
	}
	
}
