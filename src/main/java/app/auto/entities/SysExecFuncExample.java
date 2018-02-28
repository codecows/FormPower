package app.auto.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysExecFuncExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysExecFuncExample() {
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

        public Criteria andObjectIdIsNull() {
            addCriterion("object_id is null");
            return (Criteria) this;
        }

        public Criteria andObjectIdIsNotNull() {
            addCriterion("object_id is not null");
            return (Criteria) this;
        }

        public Criteria andObjectIdEqualTo(String value) {
            addCriterion("object_id =", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotEqualTo(String value) {
            addCriterion("object_id <>", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThan(String value) {
            addCriterion("object_id >", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdGreaterThanOrEqualTo(String value) {
            addCriterion("object_id >=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThan(String value) {
            addCriterion("object_id <", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLessThanOrEqualTo(String value) {
            addCriterion("object_id <=", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdLike(String value) {
            addCriterion("object_id like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotLike(String value) {
            addCriterion("object_id not like", value, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdIn(List<String> values) {
            addCriterion("object_id in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotIn(List<String> values) {
            addCriterion("object_id not in", values, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdBetween(String value1, String value2) {
            addCriterion("object_id between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectIdNotBetween(String value1, String value2) {
            addCriterion("object_id not between", value1, value2, "objectId");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNull() {
            addCriterion("object_type is null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIsNotNull() {
            addCriterion("object_type is not null");
            return (Criteria) this;
        }

        public Criteria andObjectTypeEqualTo(String value) {
            addCriterion("object_type =", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotEqualTo(String value) {
            addCriterion("object_type <>", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThan(String value) {
            addCriterion("object_type >", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("object_type >=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThan(String value) {
            addCriterion("object_type <", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLessThanOrEqualTo(String value) {
            addCriterion("object_type <=", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeLike(String value) {
            addCriterion("object_type like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotLike(String value) {
            addCriterion("object_type not like", value, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeIn(List<String> values) {
            addCriterion("object_type in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotIn(List<String> values) {
            addCriterion("object_type not in", values, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeBetween(String value1, String value2) {
            addCriterion("object_type between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andObjectTypeNotBetween(String value1, String value2) {
            addCriterion("object_type not between", value1, value2, "objectType");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNull() {
            addCriterion("func_name is null");
            return (Criteria) this;
        }

        public Criteria andFuncNameIsNotNull() {
            addCriterion("func_name is not null");
            return (Criteria) this;
        }

        public Criteria andFuncNameEqualTo(String value) {
            addCriterion("func_name =", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotEqualTo(String value) {
            addCriterion("func_name <>", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThan(String value) {
            addCriterion("func_name >", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameGreaterThanOrEqualTo(String value) {
            addCriterion("func_name >=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThan(String value) {
            addCriterion("func_name <", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLessThanOrEqualTo(String value) {
            addCriterion("func_name <=", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameLike(String value) {
            addCriterion("func_name like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotLike(String value) {
            addCriterion("func_name not like", value, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameIn(List<String> values) {
            addCriterion("func_name in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotIn(List<String> values) {
            addCriterion("func_name not in", values, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameBetween(String value1, String value2) {
            addCriterion("func_name between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncNameNotBetween(String value1, String value2) {
            addCriterion("func_name not between", value1, value2, "funcName");
            return (Criteria) this;
        }

        public Criteria andFuncParaIsNull() {
            addCriterion("func_para is null");
            return (Criteria) this;
        }

        public Criteria andFuncParaIsNotNull() {
            addCriterion("func_para is not null");
            return (Criteria) this;
        }

        public Criteria andFuncParaEqualTo(String value) {
            addCriterion("func_para =", value, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaNotEqualTo(String value) {
            addCriterion("func_para <>", value, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaGreaterThan(String value) {
            addCriterion("func_para >", value, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaGreaterThanOrEqualTo(String value) {
            addCriterion("func_para >=", value, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaLessThan(String value) {
            addCriterion("func_para <", value, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaLessThanOrEqualTo(String value) {
            addCriterion("func_para <=", value, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaLike(String value) {
            addCriterion("func_para like", value, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaNotLike(String value) {
            addCriterion("func_para not like", value, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaIn(List<String> values) {
            addCriterion("func_para in", values, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaNotIn(List<String> values) {
            addCriterion("func_para not in", values, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaBetween(String value1, String value2) {
            addCriterion("func_para between", value1, value2, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncParaNotBetween(String value1, String value2) {
            addCriterion("func_para not between", value1, value2, "funcPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaIsNull() {
            addCriterion("func_return_para is null");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaIsNotNull() {
            addCriterion("func_return_para is not null");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaEqualTo(String value) {
            addCriterion("func_return_para =", value, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaNotEqualTo(String value) {
            addCriterion("func_return_para <>", value, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaGreaterThan(String value) {
            addCriterion("func_return_para >", value, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaGreaterThanOrEqualTo(String value) {
            addCriterion("func_return_para >=", value, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaLessThan(String value) {
            addCriterion("func_return_para <", value, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaLessThanOrEqualTo(String value) {
            addCriterion("func_return_para <=", value, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaLike(String value) {
            addCriterion("func_return_para like", value, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaNotLike(String value) {
            addCriterion("func_return_para not like", value, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaIn(List<String> values) {
            addCriterion("func_return_para in", values, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaNotIn(List<String> values) {
            addCriterion("func_return_para not in", values, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaBetween(String value1, String value2) {
            addCriterion("func_return_para between", value1, value2, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncReturnParaNotBetween(String value1, String value2) {
            addCriterion("func_return_para not between", value1, value2, "funcReturnPara");
            return (Criteria) this;
        }

        public Criteria andFuncBodyIsNull() {
            addCriterion("func_body is null");
            return (Criteria) this;
        }

        public Criteria andFuncBodyIsNotNull() {
            addCriterion("func_body is not null");
            return (Criteria) this;
        }

        public Criteria andFuncBodyEqualTo(String value) {
            addCriterion("func_body =", value, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyNotEqualTo(String value) {
            addCriterion("func_body <>", value, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyGreaterThan(String value) {
            addCriterion("func_body >", value, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyGreaterThanOrEqualTo(String value) {
            addCriterion("func_body >=", value, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyLessThan(String value) {
            addCriterion("func_body <", value, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyLessThanOrEqualTo(String value) {
            addCriterion("func_body <=", value, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyLike(String value) {
            addCriterion("func_body like", value, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyNotLike(String value) {
            addCriterion("func_body not like", value, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyIn(List<String> values) {
            addCriterion("func_body in", values, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyNotIn(List<String> values) {
            addCriterion("func_body not in", values, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyBetween(String value1, String value2) {
            addCriterion("func_body between", value1, value2, "funcBody");
            return (Criteria) this;
        }

        public Criteria andFuncBodyNotBetween(String value1, String value2) {
            addCriterion("func_body not between", value1, value2, "funcBody");
            return (Criteria) this;
        }

        public Criteria andOnActionIsNull() {
            addCriterion("on_action is null");
            return (Criteria) this;
        }

        public Criteria andOnActionIsNotNull() {
            addCriterion("on_action is not null");
            return (Criteria) this;
        }

        public Criteria andOnActionEqualTo(String value) {
            addCriterion("on_action =", value, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionNotEqualTo(String value) {
            addCriterion("on_action <>", value, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionGreaterThan(String value) {
            addCriterion("on_action >", value, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionGreaterThanOrEqualTo(String value) {
            addCriterion("on_action >=", value, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionLessThan(String value) {
            addCriterion("on_action <", value, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionLessThanOrEqualTo(String value) {
            addCriterion("on_action <=", value, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionLike(String value) {
            addCriterion("on_action like", value, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionNotLike(String value) {
            addCriterion("on_action not like", value, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionIn(List<String> values) {
            addCriterion("on_action in", values, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionNotIn(List<String> values) {
            addCriterion("on_action not in", values, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionBetween(String value1, String value2) {
            addCriterion("on_action between", value1, value2, "onAction");
            return (Criteria) this;
        }

        public Criteria andOnActionNotBetween(String value1, String value2) {
            addCriterion("on_action not between", value1, value2, "onAction");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("create_date is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("create_date is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterionForJDBCDate("create_date =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("create_date >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterionForJDBCDate("create_date <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("create_date <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterionForJDBCDate("create_date in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("create_date not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("create_date not between", value1, value2, "createDate");
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