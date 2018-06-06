package com.junpeng.daigou.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AttributeDefineExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public AttributeDefineExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdattributedefineIsNull() {
            addCriterion("idattributedefine is null");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineIsNotNull() {
            addCriterion("idattributedefine is not null");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineEqualTo(Integer value) {
            addCriterion("idattributedefine =", value, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineNotEqualTo(Integer value) {
            addCriterion("idattributedefine <>", value, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineGreaterThan(Integer value) {
            addCriterion("idattributedefine >", value, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineGreaterThanOrEqualTo(Integer value) {
            addCriterion("idattributedefine >=", value, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineLessThan(Integer value) {
            addCriterion("idattributedefine <", value, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineLessThanOrEqualTo(Integer value) {
            addCriterion("idattributedefine <=", value, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineIn(List<Integer> values) {
            addCriterion("idattributedefine in", values, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineNotIn(List<Integer> values) {
            addCriterion("idattributedefine not in", values, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineBetween(Integer value1, Integer value2) {
            addCriterion("idattributedefine between", value1, value2, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdattributedefineNotBetween(Integer value1, Integer value2) {
            addCriterion("idattributedefine not between", value1, value2, "idattributedefine");
            return (Criteria) this;
        }

        public Criteria andIdcategoryIsNull() {
            addCriterion("idcategory is null");
            return (Criteria) this;
        }

        public Criteria andIdcategoryIsNotNull() {
            addCriterion("idcategory is not null");
            return (Criteria) this;
        }

        public Criteria andIdcategoryEqualTo(Integer value) {
            addCriterion("idcategory =", value, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryNotEqualTo(Integer value) {
            addCriterion("idcategory <>", value, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryGreaterThan(Integer value) {
            addCriterion("idcategory >", value, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("idcategory >=", value, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryLessThan(Integer value) {
            addCriterion("idcategory <", value, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryLessThanOrEqualTo(Integer value) {
            addCriterion("idcategory <=", value, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryIn(List<Integer> values) {
            addCriterion("idcategory in", values, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryNotIn(List<Integer> values) {
            addCriterion("idcategory not in", values, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryBetween(Integer value1, Integer value2) {
            addCriterion("idcategory between", value1, value2, "idcategory");
            return (Criteria) this;
        }

        public Criteria andIdcategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("idcategory not between", value1, value2, "idcategory");
            return (Criteria) this;
        }

        public Criteria andAttributenameIsNull() {
            addCriterion("attributename is null");
            return (Criteria) this;
        }

        public Criteria andAttributenameIsNotNull() {
            addCriterion("attributename is not null");
            return (Criteria) this;
        }

        public Criteria andAttributenameEqualTo(String value) {
            addCriterion("attributename =", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameNotEqualTo(String value) {
            addCriterion("attributename <>", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameGreaterThan(String value) {
            addCriterion("attributename >", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameGreaterThanOrEqualTo(String value) {
            addCriterion("attributename >=", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameLessThan(String value) {
            addCriterion("attributename <", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameLessThanOrEqualTo(String value) {
            addCriterion("attributename <=", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameLike(String value) {
            addCriterion("attributename like", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameNotLike(String value) {
            addCriterion("attributename not like", value, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameIn(List<String> values) {
            addCriterion("attributename in", values, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameNotIn(List<String> values) {
            addCriterion("attributename not in", values, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameBetween(String value1, String value2) {
            addCriterion("attributename between", value1, value2, "attributename");
            return (Criteria) this;
        }

        public Criteria andAttributenameNotBetween(String value1, String value2) {
            addCriterion("attributename not between", value1, value2, "attributename");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createuser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createuser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("createuser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("createuser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("createuser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("createuser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("createuser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("createuser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("createuser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("createuser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("createuser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("createuser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("createuser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("createuser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("updatetime is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("updatetime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("updatetime =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("updatetime <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("updatetime >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updatetime >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("updatetime <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("updatetime <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("updatetime in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("updatetime not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("updatetime between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("updatetime not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("updateuser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("updateuser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("updateuser =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("updateuser <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("updateuser >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("updateuser >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("updateuser <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("updateuser <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("updateuser like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("updateuser not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("updateuser in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("updateuser not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("updateuser between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("updateuser not between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNull() {
            addCriterion("isactive is null");
            return (Criteria) this;
        }

        public Criteria andIsactiveIsNotNull() {
            addCriterion("isactive is not null");
            return (Criteria) this;
        }

        public Criteria andIsactiveEqualTo(String value) {
            addCriterion("isactive =", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotEqualTo(String value) {
            addCriterion("isactive <>", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThan(String value) {
            addCriterion("isactive >", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveGreaterThanOrEqualTo(String value) {
            addCriterion("isactive >=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThan(String value) {
            addCriterion("isactive <", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLessThanOrEqualTo(String value) {
            addCriterion("isactive <=", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveLike(String value) {
            addCriterion("isactive like", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotLike(String value) {
            addCriterion("isactive not like", value, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveIn(List<String> values) {
            addCriterion("isactive in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotIn(List<String> values) {
            addCriterion("isactive not in", values, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveBetween(String value1, String value2) {
            addCriterion("isactive between", value1, value2, "isactive");
            return (Criteria) this;
        }

        public Criteria andIsactiveNotBetween(String value1, String value2) {
            addCriterion("isactive not between", value1, value2, "isactive");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table attributedefine
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table attributedefine
     *
     * @mbggenerated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}