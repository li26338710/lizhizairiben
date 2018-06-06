package com.junpeng.daigou.dao;

import org.apache.ibatis.annotations.Mapper;

import com.junpeng.daigou.model.Stock;

@Mapper
public interface StockMapper {
    int deleteByPrimaryKey(Integer idstock);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer idstock);

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}