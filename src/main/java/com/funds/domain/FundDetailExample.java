package com.funds.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FundDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FundDetailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFcodeIsNull() {
            addCriterion("fcode is null");
            return (Criteria) this;
        }

        public Criteria andFcodeIsNotNull() {
            addCriterion("fcode is not null");
            return (Criteria) this;
        }

        public Criteria andFcodeEqualTo(String value) {
            addCriterion("fcode =", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotEqualTo(String value) {
            addCriterion("fcode <>", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeGreaterThan(String value) {
            addCriterion("fcode >", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeGreaterThanOrEqualTo(String value) {
            addCriterion("fcode >=", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLessThan(String value) {
            addCriterion("fcode <", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLessThanOrEqualTo(String value) {
            addCriterion("fcode <=", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeLike(String value) {
            addCriterion("fcode like", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotLike(String value) {
            addCriterion("fcode not like", value, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeIn(List<String> values) {
            addCriterion("fcode in", values, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotIn(List<String> values) {
            addCriterion("fcode not in", values, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeBetween(String value1, String value2) {
            addCriterion("fcode between", value1, value2, "fcode");
            return (Criteria) this;
        }

        public Criteria andFcodeNotBetween(String value1, String value2) {
            addCriterion("fcode not between", value1, value2, "fcode");
            return (Criteria) this;
        }

        public Criteria andFdateIsNull() {
            addCriterion("fdate is null");
            return (Criteria) this;
        }

        public Criteria andFdateIsNotNull() {
            addCriterion("fdate is not null");
            return (Criteria) this;
        }

        public Criteria andFdateEqualTo(Date value) {
            addCriterion("fdate =", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotEqualTo(Date value) {
            addCriterion("fdate <>", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThan(Date value) {
            addCriterion("fdate >", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateGreaterThanOrEqualTo(Date value) {
            addCriterion("fdate >=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThan(Date value) {
            addCriterion("fdate <", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateLessThanOrEqualTo(Date value) {
            addCriterion("fdate <=", value, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateIn(List<Date> values) {
            addCriterion("fdate in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotIn(List<Date> values) {
            addCriterion("fdate not in", values, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateBetween(Date value1, Date value2) {
            addCriterion("fdate between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andFdateNotBetween(Date value1, Date value2) {
            addCriterion("fdate not between", value1, value2, "fdate");
            return (Criteria) this;
        }

        public Criteria andNavIsNull() {
            addCriterion("NAV is null");
            return (Criteria) this;
        }

        public Criteria andNavIsNotNull() {
            addCriterion("NAV is not null");
            return (Criteria) this;
        }

        public Criteria andNavEqualTo(BigDecimal value) {
            addCriterion("NAV =", value, "nav");
            return (Criteria) this;
        }

        public Criteria andNavNotEqualTo(BigDecimal value) {
            addCriterion("NAV <>", value, "nav");
            return (Criteria) this;
        }

        public Criteria andNavGreaterThan(BigDecimal value) {
            addCriterion("NAV >", value, "nav");
            return (Criteria) this;
        }

        public Criteria andNavGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NAV >=", value, "nav");
            return (Criteria) this;
        }

        public Criteria andNavLessThan(BigDecimal value) {
            addCriterion("NAV <", value, "nav");
            return (Criteria) this;
        }

        public Criteria andNavLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NAV <=", value, "nav");
            return (Criteria) this;
        }

        public Criteria andNavIn(List<BigDecimal> values) {
            addCriterion("NAV in", values, "nav");
            return (Criteria) this;
        }

        public Criteria andNavNotIn(List<BigDecimal> values) {
            addCriterion("NAV not in", values, "nav");
            return (Criteria) this;
        }

        public Criteria andNavBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NAV between", value1, value2, "nav");
            return (Criteria) this;
        }

        public Criteria andNavNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NAV not between", value1, value2, "nav");
            return (Criteria) this;
        }

        public Criteria andAccnavIsNull() {
            addCriterion("ACCNAV is null");
            return (Criteria) this;
        }

        public Criteria andAccnavIsNotNull() {
            addCriterion("ACCNAV is not null");
            return (Criteria) this;
        }

        public Criteria andAccnavEqualTo(BigDecimal value) {
            addCriterion("ACCNAV =", value, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavNotEqualTo(BigDecimal value) {
            addCriterion("ACCNAV <>", value, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavGreaterThan(BigDecimal value) {
            addCriterion("ACCNAV >", value, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCNAV >=", value, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavLessThan(BigDecimal value) {
            addCriterion("ACCNAV <", value, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACCNAV <=", value, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavIn(List<BigDecimal> values) {
            addCriterion("ACCNAV in", values, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavNotIn(List<BigDecimal> values) {
            addCriterion("ACCNAV not in", values, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCNAV between", value1, value2, "accnav");
            return (Criteria) this;
        }

        public Criteria andAccnavNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACCNAV not between", value1, value2, "accnav");
            return (Criteria) this;
        }

        public Criteria andDgrIsNull() {
            addCriterion("DGR is null");
            return (Criteria) this;
        }

        public Criteria andDgrIsNotNull() {
            addCriterion("DGR is not null");
            return (Criteria) this;
        }

        public Criteria andDgrEqualTo(String value) {
            addCriterion("DGR =", value, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrNotEqualTo(String value) {
            addCriterion("DGR <>", value, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrGreaterThan(String value) {
            addCriterion("DGR >", value, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrGreaterThanOrEqualTo(String value) {
            addCriterion("DGR >=", value, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrLessThan(String value) {
            addCriterion("DGR <", value, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrLessThanOrEqualTo(String value) {
            addCriterion("DGR <=", value, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrLike(String value) {
            addCriterion("DGR like", value, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrNotLike(String value) {
            addCriterion("DGR not like", value, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrIn(List<String> values) {
            addCriterion("DGR in", values, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrNotIn(List<String> values) {
            addCriterion("DGR not in", values, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrBetween(String value1, String value2) {
            addCriterion("DGR between", value1, value2, "dgr");
            return (Criteria) this;
        }

        public Criteria andDgrNotBetween(String value1, String value2) {
            addCriterion("DGR not between", value1, value2, "dgr");
            return (Criteria) this;
        }

        public Criteria andPstateIsNull() {
            addCriterion("pstate is null");
            return (Criteria) this;
        }

        public Criteria andPstateIsNotNull() {
            addCriterion("pstate is not null");
            return (Criteria) this;
        }

        public Criteria andPstateEqualTo(String value) {
            addCriterion("pstate =", value, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateNotEqualTo(String value) {
            addCriterion("pstate <>", value, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateGreaterThan(String value) {
            addCriterion("pstate >", value, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateGreaterThanOrEqualTo(String value) {
            addCriterion("pstate >=", value, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateLessThan(String value) {
            addCriterion("pstate <", value, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateLessThanOrEqualTo(String value) {
            addCriterion("pstate <=", value, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateLike(String value) {
            addCriterion("pstate like", value, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateNotLike(String value) {
            addCriterion("pstate not like", value, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateIn(List<String> values) {
            addCriterion("pstate in", values, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateNotIn(List<String> values) {
            addCriterion("pstate not in", values, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateBetween(String value1, String value2) {
            addCriterion("pstate between", value1, value2, "pstate");
            return (Criteria) this;
        }

        public Criteria andPstateNotBetween(String value1, String value2) {
            addCriterion("pstate not between", value1, value2, "pstate");
            return (Criteria) this;
        }

        public Criteria andRstateIsNull() {
            addCriterion("rstate is null");
            return (Criteria) this;
        }

        public Criteria andRstateIsNotNull() {
            addCriterion("rstate is not null");
            return (Criteria) this;
        }

        public Criteria andRstateEqualTo(String value) {
            addCriterion("rstate =", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotEqualTo(String value) {
            addCriterion("rstate <>", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateGreaterThan(String value) {
            addCriterion("rstate >", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateGreaterThanOrEqualTo(String value) {
            addCriterion("rstate >=", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateLessThan(String value) {
            addCriterion("rstate <", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateLessThanOrEqualTo(String value) {
            addCriterion("rstate <=", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateLike(String value) {
            addCriterion("rstate like", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotLike(String value) {
            addCriterion("rstate not like", value, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateIn(List<String> values) {
            addCriterion("rstate in", values, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotIn(List<String> values) {
            addCriterion("rstate not in", values, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateBetween(String value1, String value2) {
            addCriterion("rstate between", value1, value2, "rstate");
            return (Criteria) this;
        }

        public Criteria andRstateNotBetween(String value1, String value2) {
            addCriterion("rstate not between", value1, value2, "rstate");
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