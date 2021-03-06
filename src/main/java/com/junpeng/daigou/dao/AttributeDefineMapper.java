package com.junpeng.daigou.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.junpeng.daigou.model.AttributeDefine;
import com.junpeng.daigou.model.AttributeDefineExample;

@Mapper
public interface AttributeDefineMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int countByExample(AttributeDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int deleteByExample(AttributeDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer idattributedefine);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int insert(AttributeDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int insertSelective(AttributeDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    List<AttributeDefine> selectByExample(AttributeDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    AttributeDefine selectByPrimaryKey(Integer idattributedefine);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") AttributeDefine record, @Param("example") AttributeDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") AttributeDefine record, @Param("example") AttributeDefineExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(AttributeDefine record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(AttributeDefine record);
}