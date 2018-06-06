package com.junpeng.daigou.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MarketExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MarketExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andIdmarketIsNull() {
            addCriterion("idmarket is null");
            return (Criteria) this;
        }

        public Criteria andIdmarketIsNotNull() {
            addCriterion("idmarket is not null");
            return (Criteria) this;
        }

        public Criteria andIdmarketEqualTo(Integer value) {
            addCriterion("idmarket =", value, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketNotEqualTo(Integer value) {
            addCriterion("idmarket <>", value, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketGreaterThan(Integer value) {
            addCriterion("idmarket >", value, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketGreaterThanOrEqualTo(Integer value) {
            addCriterion("idmarket >=", value, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketLessThan(Integer value) {
            addCriterion("idmarket <", value, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketLessThanOrEqualTo(Integer value) {
            addCriterion("idmarket <=", value, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketIn(List<Integer> values) {
            addCriterion("idmarket in", values, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketNotIn(List<Integer> values) {
            addCriterion("idmarket not in", values, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketBetween(Integer value1, Integer value2) {
            addCriterion("idmarket between", value1, value2, "idmarket");
            return (Criteria) this;
        }

        public Criteria andIdmarketNotBetween(Integer value1, Integer value2) {
            addCriterion("idmarket not between", value1, value2, "idmarket");
            return (Criteria) this;
        }

        public Criteria andMarketnameIsNull() {
            addCriterion("marketname is null");
            return (Criteria) this;
        }

        public Criteria andMarketnameIsNotNull() {
            addCriterion("marketname is not null");
            return (Criteria) this;
        }

        public Criteria andMarketnameEqualTo(String value) {
            addCriterion("marketname =", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameNotEqualTo(String value) {
            addCriterion("marketname <>", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameGreaterThan(String value) {
            addCriterion("marketname >", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameGreaterThanOrEqualTo(String value) {
            addCriterion("marketname >=", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameLessThan(String value) {
            addCriterion("marketname <", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameLessThanOrEqualTo(String value) {
            addCriterion("marketname <=", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameLike(String value) {
            addCriterion("marketname like", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameNotLike(String value) {
            addCriterion("marketname not like", value, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameIn(List<String> values) {
            addCriterion("marketname in", values, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameNotIn(List<String> values) {
            addCriterion("marketname not in", values, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameBetween(String value1, String value2) {
            addCriterion("marketname between", value1, value2, "marketname");
            return (Criteria) this;
        }

        public Criteria andMarketnameNotBetween(String value1, String value2) {
            addCriterion("marketname not between", value1, value2, "marketname");
            return (Criteria) this;
        }

        public Criteria andCommentIsNull() {
            addCriterion("comment is null");
            return (Criteria) this;
        }

        public Criteria andCommentIsNotNull() {
            addCriterion("comment is not null");
            return (Criteria) this;
        }

        public Criteria andCommentEqualTo(String value) {
            addCriterion("comment =", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotEqualTo(String value) {
            addCriterion("comment <>", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThan(String value) {
            addCriterion("comment >", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentGreaterThanOrEqualTo(String value) {
            addCriterion("comment >=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThan(String value) {
            addCriterion("comment <", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLessThanOrEqualTo(String value) {
            addCriterion("comment <=", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentLike(String value) {
            addCriterion("comment like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotLike(String value) {
            addCriterion("comment not like", value, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentIn(List<String> values) {
            addCriterion("comment in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotIn(List<String> values) {
            addCriterion("comment not in", values, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentBetween(String value1, String value2) {
            addCriterion("comment between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCommentNotBetween(String value1, String value2) {
            addCriterion("comment not between", value1, value2, "comment");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNull() {
            addCriterion("createUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateuserIsNotNull() {
            addCriterion("createUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateuserEqualTo(String value) {
            addCriterion("createUser =", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotEqualTo(String value) {
            addCriterion("createUser <>", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThan(String value) {
            addCriterion("createUser >", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserGreaterThanOrEqualTo(String value) {
            addCriterion("createUser >=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThan(String value) {
            addCriterion("createUser <", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLessThanOrEqualTo(String value) {
            addCriterion("createUser <=", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserLike(String value) {
            addCriterion("createUser like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotLike(String value) {
            addCriterion("createUser not like", value, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserIn(List<String> values) {
            addCriterion("createUser in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotIn(List<String> values) {
            addCriterion("createUser not in", values, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserBetween(String value1, String value2) {
            addCriterion("createUser between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreateuserNotBetween(String value1, String value2) {
            addCriterion("createUser not between", value1, value2, "createuser");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNull() {
            addCriterion("createDate is null");
            return (Criteria) this;
        }

        public Criteria andCreatedateIsNotNull() {
            addCriterion("createDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedateEqualTo(Date value) {
            addCriterion("createDate =", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotEqualTo(Date value) {
            addCriterion("createDate <>", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThan(Date value) {
            addCriterion("createDate >", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("createDate >=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThan(Date value) {
            addCriterion("createDate <", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateLessThanOrEqualTo(Date value) {
            addCriterion("createDate <=", value, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateIn(List<Date> values) {
            addCriterion("createDate in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotIn(List<Date> values) {
            addCriterion("createDate not in", values, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateBetween(Date value1, Date value2) {
            addCriterion("createDate between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andCreatedateNotBetween(Date value1, Date value2) {
            addCriterion("createDate not between", value1, value2, "createdate");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNull() {
            addCriterion("updateUser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIsNotNull() {
            addCriterion("updateUser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateuserEqualTo(String value) {
            addCriterion("updateUser =", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotEqualTo(String value) {
            addCriterion("updateUser <>", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThan(String value) {
            addCriterion("updateUser >", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserGreaterThanOrEqualTo(String value) {
            addCriterion("updateUser >=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThan(String value) {
            addCriterion("updateUser <", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLessThanOrEqualTo(String value) {
            addCriterion("updateUser <=", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserLike(String value) {
            addCriterion("updateUser like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotLike(String value) {
            addCriterion("updateUser not like", value, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserIn(List<String> values) {
            addCriterion("updateUser in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotIn(List<String> values) {
            addCriterion("updateUser not in", values, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserBetween(String value1, String value2) {
            addCriterion("updateUser between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdateuserNotBetween(String value1, String value2) {
            addCriterion("updateUser not between", value1, value2, "updateuser");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedateEqualTo(Date value) {
            addCriterion("updateDate =", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotEqualTo(Date value) {
            addCriterion("updateDate <>", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThan(Date value) {
            addCriterion("updateDate >", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateGreaterThanOrEqualTo(Date value) {
            addCriterion("updateDate >=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThan(Date value) {
            addCriterion("updateDate <", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateLessThanOrEqualTo(Date value) {
            addCriterion("updateDate <=", value, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateIn(List<Date> values) {
            addCriterion("updateDate in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotIn(List<Date> values) {
            addCriterion("updateDate not in", values, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateBetween(Date value1, Date value2) {
            addCriterion("updateDate between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andUpdatedateNotBetween(Date value1, Date value2) {
            addCriterion("updateDate not between", value1, value2, "updatedate");
            return (Criteria) this;
        }

        public Criteria andIsacticeIsNull() {
            addCriterion("isactice is null");
            return (Criteria) this;
        }

        public Criteria andIsacticeIsNotNull() {
            addCriterion("isactice is not null");
            return (Criteria) this;
        }

        public Criteria andIsacticeEqualTo(String value) {
            addCriterion("isactice =", value, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeNotEqualTo(String value) {
            addCriterion("isactice <>", value, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeGreaterThan(String value) {
            addCriterion("isactice >", value, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeGreaterThanOrEqualTo(String value) {
            addCriterion("isactice >=", value, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeLessThan(String value) {
            addCriterion("isactice <", value, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeLessThanOrEqualTo(String value) {
            addCriterion("isactice <=", value, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeLike(String value) {
            addCriterion("isactice like", value, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeNotLike(String value) {
            addCriterion("isactice not like", value, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeIn(List<String> values) {
            addCriterion("isactice in", values, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeNotIn(List<String> values) {
            addCriterion("isactice not in", values, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeBetween(String value1, String value2) {
            addCriterion("isactice between", value1, value2, "isactice");
            return (Criteria) this;
        }

        public Criteria andIsacticeNotBetween(String value1, String value2) {
            addCriterion("isactice not between", value1, value2, "isactice");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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