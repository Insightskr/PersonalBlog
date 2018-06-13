package com.ins.blog.entity;

import java.util.ArrayList;
import java.util.List;

public class VictorExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VictorExample() {
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

        public Criteria andVictorNameIsNull() {
            addCriterion("victor_name is null");
            return (Criteria) this;
        }

        public Criteria andVictorNameIsNotNull() {
            addCriterion("victor_name is not null");
            return (Criteria) this;
        }

        public Criteria andVictorNameEqualTo(String value) {
            addCriterion("victor_name =", value, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameNotEqualTo(String value) {
            addCriterion("victor_name <>", value, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameGreaterThan(String value) {
            addCriterion("victor_name >", value, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameGreaterThanOrEqualTo(String value) {
            addCriterion("victor_name >=", value, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameLessThan(String value) {
            addCriterion("victor_name <", value, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameLessThanOrEqualTo(String value) {
            addCriterion("victor_name <=", value, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameLike(String value) {
            addCriterion("victor_name like", value, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameNotLike(String value) {
            addCriterion("victor_name not like", value, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameIn(List<String> values) {
            addCriterion("victor_name in", values, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameNotIn(List<String> values) {
            addCriterion("victor_name not in", values, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameBetween(String value1, String value2) {
            addCriterion("victor_name between", value1, value2, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorNameNotBetween(String value1, String value2) {
            addCriterion("victor_name not between", value1, value2, "victorName");
            return (Criteria) this;
        }

        public Criteria andVictorEmailIsNull() {
            addCriterion("victor_email is null");
            return (Criteria) this;
        }

        public Criteria andVictorEmailIsNotNull() {
            addCriterion("victor_email is not null");
            return (Criteria) this;
        }

        public Criteria andVictorEmailEqualTo(String value) {
            addCriterion("victor_email =", value, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailNotEqualTo(String value) {
            addCriterion("victor_email <>", value, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailGreaterThan(String value) {
            addCriterion("victor_email >", value, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailGreaterThanOrEqualTo(String value) {
            addCriterion("victor_email >=", value, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailLessThan(String value) {
            addCriterion("victor_email <", value, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailLessThanOrEqualTo(String value) {
            addCriterion("victor_email <=", value, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailLike(String value) {
            addCriterion("victor_email like", value, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailNotLike(String value) {
            addCriterion("victor_email not like", value, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailIn(List<String> values) {
            addCriterion("victor_email in", values, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailNotIn(List<String> values) {
            addCriterion("victor_email not in", values, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailBetween(String value1, String value2) {
            addCriterion("victor_email between", value1, value2, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorEmailNotBetween(String value1, String value2) {
            addCriterion("victor_email not between", value1, value2, "victorEmail");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordIsNull() {
            addCriterion("victor_password is null");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordIsNotNull() {
            addCriterion("victor_password is not null");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordEqualTo(String value) {
            addCriterion("victor_password =", value, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordNotEqualTo(String value) {
            addCriterion("victor_password <>", value, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordGreaterThan(String value) {
            addCriterion("victor_password >", value, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("victor_password >=", value, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordLessThan(String value) {
            addCriterion("victor_password <", value, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordLessThanOrEqualTo(String value) {
            addCriterion("victor_password <=", value, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordLike(String value) {
            addCriterion("victor_password like", value, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordNotLike(String value) {
            addCriterion("victor_password not like", value, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordIn(List<String> values) {
            addCriterion("victor_password in", values, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordNotIn(List<String> values) {
            addCriterion("victor_password not in", values, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordBetween(String value1, String value2) {
            addCriterion("victor_password between", value1, value2, "victorPassword");
            return (Criteria) this;
        }

        public Criteria andVictorPasswordNotBetween(String value1, String value2) {
            addCriterion("victor_password not between", value1, value2, "victorPassword");
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