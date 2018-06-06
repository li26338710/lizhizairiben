package com.junpeng.daigou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.junpeng.daigou.model.Status;

@Mapper
public interface StatusMapper {
    int deleteByPrimaryKey(Integer idstatus);

    int insert(Status record);

    int insertSelective(Status record);

    Status selectByPrimaryKey(Integer idstatus);
    
    List<Status> getStatusByStatusType(String statusType);

    int updateByPrimaryKeySelective(Status record);

    int updateByPrimaryKey(Status record);
}