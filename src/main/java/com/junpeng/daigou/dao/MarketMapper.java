package com.junpeng.daigou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.junpeng.daigou.model.Market;
import com.junpeng.daigou.model.MarketExample;

@Mapper
public interface MarketMapper {
    int countByExample(MarketExample example);

    int deleteByExample(MarketExample example);
    int deleteByPrimaryKey(Integer idmarket);

    int insert(Market record);

    int insertSelective(Market record);

    List<Market> selectByExample(MarketExample example);

    Market selectByPrimaryKey(Integer idmarket);

    int updateByExampleSelective(@Param("record") Market record, @Param("example") MarketExample example);

    int updateByExample(@Param("record") Market record, @Param("example") MarketExample example);
    int updateByPrimaryKeySelective(Market record);

    int updateByPrimaryKey(Market record);
    
}