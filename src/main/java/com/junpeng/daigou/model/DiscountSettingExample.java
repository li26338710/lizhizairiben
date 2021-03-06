package com.junpeng.daigou.model;

import java.util.ArrayList;
import java.util.List;

public class DiscountSettingExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    public DiscountSettingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
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
     * This method corresponds to the database table discountsetting
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
     * This method corresponds to the database table discountsetting
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table discountsetting
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
     * This class corresponds to the database table discountsetting
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

        public Criteria andIddiscountsettingIsNull() {
            addCriterion("iddiscountsetting is null");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingIsNotNull() {
            addCriterion("iddiscountsetting is not null");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingEqualTo(Integer value) {
            addCriterion("iddiscountsetting =", value, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingNotEqualTo(Integer value) {
            addCriterion("iddiscountsetting <>", value, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingGreaterThan(Integer value) {
            addCriterion("iddiscountsetting >", value, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingGreaterThanOrEqualTo(Integer value) {
            addCriterion("iddiscountsetting >=", value, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingLessThan(Integer value) {
            addCriterion("iddiscountsetting <", value, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingLessThanOrEqualTo(Integer value) {
            addCriterion("iddiscountsetting <=", value, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingIn(List<Integer> values) {
            addCriterion("iddiscountsetting in", values, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingNotIn(List<Integer> values) {
            addCriterion("iddiscountsetting not in", values, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingBetween(Integer value1, Integer value2) {
            addCriterion("iddiscountsetting between", value1, value2, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andIddiscountsettingNotBetween(Integer value1, Integer value2) {
            addCriterion("iddiscountsetting not between", value1, value2, "iddiscountsetting");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameIsNull() {
            addCriterion("discountsettingname is null");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameIsNotNull() {
            addCriterion("discountsettingname is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameEqualTo(String value) {
            addCriterion("discountsettingname =", value, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameNotEqualTo(String value) {
            addCriterion("discountsettingname <>", value, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameGreaterThan(String value) {
            addCriterion("discountsettingname >", value, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameGreaterThanOrEqualTo(String value) {
            addCriterion("discountsettingname >=", value, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameLessThan(String value) {
            addCriterion("discountsettingname <", value, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameLessThanOrEqualTo(String value) {
            addCriterion("discountsettingname <=", value, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameLike(String value) {
            addCriterion("discountsettingname like", value, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameNotLike(String value) {
            addCriterion("discountsettingname not like", value, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameIn(List<String> values) {
            addCriterion("discountsettingname in", values, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameNotIn(List<String> values) {
            addCriterion("discountsettingname not in", values, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameBetween(String value1, String value2) {
            addCriterion("discountsettingname between", value1, value2, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingnameNotBetween(String value1, String value2) {
            addCriterion("discountsettingname not between", value1, value2, "discountsettingname");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentIsNull() {
            addCriterion("discountsettingcomment is null");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentIsNotNull() {
            addCriterion("discountsettingcomment is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentEqualTo(String value) {
            addCriterion("discountsettingcomment =", value, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentNotEqualTo(String value) {
            addCriterion("discountsettingcomment <>", value, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentGreaterThan(String value) {
            addCriterion("discountsettingcomment >", value, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentGreaterThanOrEqualTo(String value) {
            addCriterion("discountsettingcomment >=", value, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentLessThan(String value) {
            addCriterion("discountsettingcomment <", value, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentLessThanOrEqualTo(String value) {
            addCriterion("discountsettingcomment <=", value, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentLike(String value) {
            addCriterion("discountsettingcomment like", value, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentNotLike(String value) {
            addCriterion("discountsettingcomment not like", value, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentIn(List<String> values) {
            addCriterion("discountsettingcomment in", values, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentNotIn(List<String> values) {
            addCriterion("discountsettingcomment not in", values, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentBetween(String value1, String value2) {
            addCriterion("discountsettingcomment between", value1, value2, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountsettingcommentNotBetween(String value1, String value2) {
            addCriterion("discountsettingcomment not between", value1, value2, "discountsettingcomment");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(Double value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(Double value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(Double value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(Double value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(Double value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(Double value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<Double> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<Double> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(Double value1, Double value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(Double value1, Double value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table discountsetting
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
     * This class corresponds to the database table discountsetting
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