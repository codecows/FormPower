package app.dao.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SysCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCodeExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeNumIsNull() {
            addCriterion("code_num is null");
            return (Criteria) this;
        }

        public Criteria andCodeNumIsNotNull() {
            addCriterion("code_num is not null");
            return (Criteria) this;
        }

        public Criteria andCodeNumEqualTo(String value) {
            addCriterion("code_num =", value, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumNotEqualTo(String value) {
            addCriterion("code_num <>", value, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumGreaterThan(String value) {
            addCriterion("code_num >", value, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumGreaterThanOrEqualTo(String value) {
            addCriterion("code_num >=", value, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumLessThan(String value) {
            addCriterion("code_num <", value, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumLessThanOrEqualTo(String value) {
            addCriterion("code_num <=", value, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumLike(String value) {
            addCriterion("code_num like", value, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumNotLike(String value) {
            addCriterion("code_num not like", value, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumIn(List<String> values) {
            addCriterion("code_num in", values, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumNotIn(List<String> values) {
            addCriterion("code_num not in", values, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumBetween(String value1, String value2) {
            addCriterion("code_num between", value1, value2, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNumNotBetween(String value1, String value2) {
            addCriterion("code_num not between", value1, value2, "codeNum");
            return (Criteria) this;
        }

        public Criteria andCodeNameIsNull() {
            addCriterion("code_name is null");
            return (Criteria) this;
        }

        public Criteria andCodeNameIsNotNull() {
            addCriterion("code_name is not null");
            return (Criteria) this;
        }

        public Criteria andCodeNameEqualTo(String value) {
            addCriterion("code_name =", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotEqualTo(String value) {
            addCriterion("code_name <>", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameGreaterThan(String value) {
            addCriterion("code_name >", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("code_name >=", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLessThan(String value) {
            addCriterion("code_name <", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLessThanOrEqualTo(String value) {
            addCriterion("code_name <=", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameLike(String value) {
            addCriterion("code_name like", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotLike(String value) {
            addCriterion("code_name not like", value, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameIn(List<String> values) {
            addCriterion("code_name in", values, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotIn(List<String> values) {
            addCriterion("code_name not in", values, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameBetween(String value1, String value2) {
            addCriterion("code_name between", value1, value2, "codeName");
            return (Criteria) this;
        }

        public Criteria andCodeNameNotBetween(String value1, String value2) {
            addCriterion("code_name not between", value1, value2, "codeName");
            return (Criteria) this;
        }

        public Criteria andParentNumIsNull() {
            addCriterion("parent_num is null");
            return (Criteria) this;
        }

        public Criteria andParentNumIsNotNull() {
            addCriterion("parent_num is not null");
            return (Criteria) this;
        }

        public Criteria andParentNumEqualTo(String value) {
            addCriterion("parent_num =", value, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumNotEqualTo(String value) {
            addCriterion("parent_num <>", value, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumGreaterThan(String value) {
            addCriterion("parent_num >", value, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumGreaterThanOrEqualTo(String value) {
            addCriterion("parent_num >=", value, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumLessThan(String value) {
            addCriterion("parent_num <", value, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumLessThanOrEqualTo(String value) {
            addCriterion("parent_num <=", value, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumLike(String value) {
            addCriterion("parent_num like", value, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumNotLike(String value) {
            addCriterion("parent_num not like", value, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumIn(List<String> values) {
            addCriterion("parent_num in", values, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumNotIn(List<String> values) {
            addCriterion("parent_num not in", values, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumBetween(String value1, String value2) {
            addCriterion("parent_num between", value1, value2, "parentNum");
            return (Criteria) this;
        }

        public Criteria andParentNumNotBetween(String value1, String value2) {
            addCriterion("parent_num not between", value1, value2, "parentNum");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNull() {
            addCriterion("c_type is null");
            return (Criteria) this;
        }

        public Criteria andCTypeIsNotNull() {
            addCriterion("c_type is not null");
            return (Criteria) this;
        }

        public Criteria andCTypeEqualTo(String value) {
            addCriterion("c_type =", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotEqualTo(String value) {
            addCriterion("c_type <>", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThan(String value) {
            addCriterion("c_type >", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeGreaterThanOrEqualTo(String value) {
            addCriterion("c_type >=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThan(String value) {
            addCriterion("c_type <", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLessThanOrEqualTo(String value) {
            addCriterion("c_type <=", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeLike(String value) {
            addCriterion("c_type like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotLike(String value) {
            addCriterion("c_type not like", value, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeIn(List<String> values) {
            addCriterion("c_type in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotIn(List<String> values) {
            addCriterion("c_type not in", values, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeBetween(String value1, String value2) {
            addCriterion("c_type between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNotBetween(String value1, String value2) {
            addCriterion("c_type not between", value1, value2, "cType");
            return (Criteria) this;
        }

        public Criteria andCTypeNameIsNull() {
            addCriterion("c_type_name is null");
            return (Criteria) this;
        }

        public Criteria andCTypeNameIsNotNull() {
            addCriterion("c_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andCTypeNameEqualTo(String value) {
            addCriterion("c_type_name =", value, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameNotEqualTo(String value) {
            addCriterion("c_type_name <>", value, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameGreaterThan(String value) {
            addCriterion("c_type_name >", value, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("c_type_name >=", value, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameLessThan(String value) {
            addCriterion("c_type_name <", value, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameLessThanOrEqualTo(String value) {
            addCriterion("c_type_name <=", value, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameLike(String value) {
            addCriterion("c_type_name like", value, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameNotLike(String value) {
            addCriterion("c_type_name not like", value, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameIn(List<String> values) {
            addCriterion("c_type_name in", values, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameNotIn(List<String> values) {
            addCriterion("c_type_name not in", values, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameBetween(String value1, String value2) {
            addCriterion("c_type_name between", value1, value2, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andCTypeNameNotBetween(String value1, String value2) {
            addCriterion("c_type_name not between", value1, value2, "cTypeName");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNull() {
            addCriterion("order_num is null");
            return (Criteria) this;
        }

        public Criteria andOrderNumIsNotNull() {
            addCriterion("order_num is not null");
            return (Criteria) this;
        }

        public Criteria andOrderNumEqualTo(BigDecimal value) {
            addCriterion("order_num =", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotEqualTo(BigDecimal value) {
            addCriterion("order_num <>", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThan(BigDecimal value) {
            addCriterion("order_num >", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_num >=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThan(BigDecimal value) {
            addCriterion("order_num <", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_num <=", value, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumIn(List<BigDecimal> values) {
            addCriterion("order_num in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotIn(List<BigDecimal> values) {
            addCriterion("order_num not in", values, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_num between", value1, value2, "orderNum");
            return (Criteria) this;
        }

        public Criteria andOrderNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_num not between", value1, value2, "orderNum");
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