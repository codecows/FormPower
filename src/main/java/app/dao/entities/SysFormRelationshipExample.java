package app.dao.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysFormRelationshipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFormRelationshipExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andRIdIsNull() {
            addCriterion("r_id is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("r_id is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(String value) {
            addCriterion("r_id =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(String value) {
            addCriterion("r_id <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(String value) {
            addCriterion("r_id >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(String value) {
            addCriterion("r_id >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(String value) {
            addCriterion("r_id <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(String value) {
            addCriterion("r_id <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLike(String value) {
            addCriterion("r_id like", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotLike(String value) {
            addCriterion("r_id not like", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<String> values) {
            addCriterion("r_id in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<String> values) {
            addCriterion("r_id not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(String value1, String value2) {
            addCriterion("r_id between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(String value1, String value2) {
            addCriterion("r_id not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(String value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(String value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(String value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(String value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(String value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(String value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLike(String value) {
            addCriterion("parent_id like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotLike(String value) {
            addCriterion("parent_id not like", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<String> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<String> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(String value1, String value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(String value1, String value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andChildIdIsNull() {
            addCriterion("child_id is null");
            return (Criteria) this;
        }

        public Criteria andChildIdIsNotNull() {
            addCriterion("child_id is not null");
            return (Criteria) this;
        }

        public Criteria andChildIdEqualTo(String value) {
            addCriterion("child_id =", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdNotEqualTo(String value) {
            addCriterion("child_id <>", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdGreaterThan(String value) {
            addCriterion("child_id >", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdGreaterThanOrEqualTo(String value) {
            addCriterion("child_id >=", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdLessThan(String value) {
            addCriterion("child_id <", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdLessThanOrEqualTo(String value) {
            addCriterion("child_id <=", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdLike(String value) {
            addCriterion("child_id like", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdNotLike(String value) {
            addCriterion("child_id not like", value, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdIn(List<String> values) {
            addCriterion("child_id in", values, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdNotIn(List<String> values) {
            addCriterion("child_id not in", values, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdBetween(String value1, String value2) {
            addCriterion("child_id between", value1, value2, "childId");
            return (Criteria) this;
        }

        public Criteria andChildIdNotBetween(String value1, String value2) {
            addCriterion("child_id not between", value1, value2, "childId");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeIsNull() {
            addCriterion("relationship_type is null");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeIsNotNull() {
            addCriterion("relationship_type is not null");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeEqualTo(String value) {
            addCriterion("relationship_type =", value, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeNotEqualTo(String value) {
            addCriterion("relationship_type <>", value, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeGreaterThan(String value) {
            addCriterion("relationship_type >", value, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeGreaterThanOrEqualTo(String value) {
            addCriterion("relationship_type >=", value, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeLessThan(String value) {
            addCriterion("relationship_type <", value, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeLessThanOrEqualTo(String value) {
            addCriterion("relationship_type <=", value, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeLike(String value) {
            addCriterion("relationship_type like", value, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeNotLike(String value) {
            addCriterion("relationship_type not like", value, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeIn(List<String> values) {
            addCriterion("relationship_type in", values, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeNotIn(List<String> values) {
            addCriterion("relationship_type not in", values, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeBetween(String value1, String value2) {
            addCriterion("relationship_type between", value1, value2, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andRelationshipTypeNotBetween(String value1, String value2) {
            addCriterion("relationship_type not between", value1, value2, "relationshipType");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNull() {
            addCriterion("operation_date is null");
            return (Criteria) this;
        }

        public Criteria andOperationDateIsNotNull() {
            addCriterion("operation_date is not null");
            return (Criteria) this;
        }

        public Criteria andOperationDateEqualTo(Date value) {
            addCriterionForJDBCDate("operation_date =", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("operation_date <>", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("operation_date >", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("operation_date >=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThan(Date value) {
            addCriterionForJDBCDate("operation_date <", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("operation_date <=", value, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateIn(List<Date> values) {
            addCriterionForJDBCDate("operation_date in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("operation_date not in", values, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("operation_date between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("operation_date not between", value1, value2, "operationDate");
            return (Criteria) this;
        }

        public Criteria andOperationPersionIsNull() {
            addCriterion("operation_persion is null");
            return (Criteria) this;
        }

        public Criteria andOperationPersionIsNotNull() {
            addCriterion("operation_persion is not null");
            return (Criteria) this;
        }

        public Criteria andOperationPersionEqualTo(String value) {
            addCriterion("operation_persion =", value, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionNotEqualTo(String value) {
            addCriterion("operation_persion <>", value, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionGreaterThan(String value) {
            addCriterion("operation_persion >", value, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionGreaterThanOrEqualTo(String value) {
            addCriterion("operation_persion >=", value, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionLessThan(String value) {
            addCriterion("operation_persion <", value, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionLessThanOrEqualTo(String value) {
            addCriterion("operation_persion <=", value, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionLike(String value) {
            addCriterion("operation_persion like", value, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionNotLike(String value) {
            addCriterion("operation_persion not like", value, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionIn(List<String> values) {
            addCriterion("operation_persion in", values, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionNotIn(List<String> values) {
            addCriterion("operation_persion not in", values, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionBetween(String value1, String value2) {
            addCriterion("operation_persion between", value1, value2, "operationPersion");
            return (Criteria) this;
        }

        public Criteria andOperationPersionNotBetween(String value1, String value2) {
            addCriterion("operation_persion not between", value1, value2, "operationPersion");
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
    }
}