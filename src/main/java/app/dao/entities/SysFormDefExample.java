package app.dao.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SysFormDefExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysFormDefExample() {
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

        public Criteria andFormIdIsNull() {
            addCriterion("form_id is null");
            return (Criteria) this;
        }

        public Criteria andFormIdIsNotNull() {
            addCriterion("form_id is not null");
            return (Criteria) this;
        }

        public Criteria andFormIdEqualTo(String value) {
            addCriterion("form_id =", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotEqualTo(String value) {
            addCriterion("form_id <>", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThan(String value) {
            addCriterion("form_id >", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdGreaterThanOrEqualTo(String value) {
            addCriterion("form_id >=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThan(String value) {
            addCriterion("form_id <", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLessThanOrEqualTo(String value) {
            addCriterion("form_id <=", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdLike(String value) {
            addCriterion("form_id like", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotLike(String value) {
            addCriterion("form_id not like", value, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdIn(List<String> values) {
            addCriterion("form_id in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotIn(List<String> values) {
            addCriterion("form_id not in", values, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdBetween(String value1, String value2) {
            addCriterion("form_id between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFormIdNotBetween(String value1, String value2) {
            addCriterion("form_id not between", value1, value2, "formId");
            return (Criteria) this;
        }

        public Criteria andFormNameIsNull() {
            addCriterion("form_name is null");
            return (Criteria) this;
        }

        public Criteria andFormNameIsNotNull() {
            addCriterion("form_name is not null");
            return (Criteria) this;
        }

        public Criteria andFormNameEqualTo(String value) {
            addCriterion("form_name =", value, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameNotEqualTo(String value) {
            addCriterion("form_name <>", value, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameGreaterThan(String value) {
            addCriterion("form_name >", value, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameGreaterThanOrEqualTo(String value) {
            addCriterion("form_name >=", value, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameLessThan(String value) {
            addCriterion("form_name <", value, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameLessThanOrEqualTo(String value) {
            addCriterion("form_name <=", value, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameLike(String value) {
            addCriterion("form_name like", value, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameNotLike(String value) {
            addCriterion("form_name not like", value, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameIn(List<String> values) {
            addCriterion("form_name in", values, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameNotIn(List<String> values) {
            addCriterion("form_name not in", values, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameBetween(String value1, String value2) {
            addCriterion("form_name between", value1, value2, "formName");
            return (Criteria) this;
        }

        public Criteria andFormNameNotBetween(String value1, String value2) {
            addCriterion("form_name not between", value1, value2, "formName");
            return (Criteria) this;
        }

        public Criteria andFormGroupIsNull() {
            addCriterion("form_group is null");
            return (Criteria) this;
        }

        public Criteria andFormGroupIsNotNull() {
            addCriterion("form_group is not null");
            return (Criteria) this;
        }

        public Criteria andFormGroupEqualTo(String value) {
            addCriterion("form_group =", value, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupNotEqualTo(String value) {
            addCriterion("form_group <>", value, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupGreaterThan(String value) {
            addCriterion("form_group >", value, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupGreaterThanOrEqualTo(String value) {
            addCriterion("form_group >=", value, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupLessThan(String value) {
            addCriterion("form_group <", value, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupLessThanOrEqualTo(String value) {
            addCriterion("form_group <=", value, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupLike(String value) {
            addCriterion("form_group like", value, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupNotLike(String value) {
            addCriterion("form_group not like", value, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupIn(List<String> values) {
            addCriterion("form_group in", values, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupNotIn(List<String> values) {
            addCriterion("form_group not in", values, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupBetween(String value1, String value2) {
            addCriterion("form_group between", value1, value2, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormGroupNotBetween(String value1, String value2) {
            addCriterion("form_group not between", value1, value2, "formGroup");
            return (Criteria) this;
        }

        public Criteria andFormImgIsNull() {
            addCriterion("form_img is null");
            return (Criteria) this;
        }

        public Criteria andFormImgIsNotNull() {
            addCriterion("form_img is not null");
            return (Criteria) this;
        }

        public Criteria andFormImgEqualTo(String value) {
            addCriterion("form_img =", value, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgNotEqualTo(String value) {
            addCriterion("form_img <>", value, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgGreaterThan(String value) {
            addCriterion("form_img >", value, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgGreaterThanOrEqualTo(String value) {
            addCriterion("form_img >=", value, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgLessThan(String value) {
            addCriterion("form_img <", value, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgLessThanOrEqualTo(String value) {
            addCriterion("form_img <=", value, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgLike(String value) {
            addCriterion("form_img like", value, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgNotLike(String value) {
            addCriterion("form_img not like", value, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgIn(List<String> values) {
            addCriterion("form_img in", values, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgNotIn(List<String> values) {
            addCriterion("form_img not in", values, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgBetween(String value1, String value2) {
            addCriterion("form_img between", value1, value2, "formImg");
            return (Criteria) this;
        }

        public Criteria andFormImgNotBetween(String value1, String value2) {
            addCriterion("form_img not between", value1, value2, "formImg");
            return (Criteria) this;
        }

        public Criteria andFTypeIsNull() {
            addCriterion("f_type is null");
            return (Criteria) this;
        }

        public Criteria andFTypeIsNotNull() {
            addCriterion("f_type is not null");
            return (Criteria) this;
        }

        public Criteria andFTypeEqualTo(String value) {
            addCriterion("f_type =", value, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeNotEqualTo(String value) {
            addCriterion("f_type <>", value, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeGreaterThan(String value) {
            addCriterion("f_type >", value, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeGreaterThanOrEqualTo(String value) {
            addCriterion("f_type >=", value, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeLessThan(String value) {
            addCriterion("f_type <", value, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeLessThanOrEqualTo(String value) {
            addCriterion("f_type <=", value, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeLike(String value) {
            addCriterion("f_type like", value, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeNotLike(String value) {
            addCriterion("f_type not like", value, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeIn(List<String> values) {
            addCriterion("f_type in", values, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeNotIn(List<String> values) {
            addCriterion("f_type not in", values, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeBetween(String value1, String value2) {
            addCriterion("f_type between", value1, value2, "fType");
            return (Criteria) this;
        }

        public Criteria andFTypeNotBetween(String value1, String value2) {
            addCriterion("f_type not between", value1, value2, "fType");
            return (Criteria) this;
        }

        public Criteria andIsSingleIsNull() {
            addCriterion("is_single is null");
            return (Criteria) this;
        }

        public Criteria andIsSingleIsNotNull() {
            addCriterion("is_single is not null");
            return (Criteria) this;
        }

        public Criteria andIsSingleEqualTo(String value) {
            addCriterion("is_single =", value, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleNotEqualTo(String value) {
            addCriterion("is_single <>", value, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleGreaterThan(String value) {
            addCriterion("is_single >", value, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleGreaterThanOrEqualTo(String value) {
            addCriterion("is_single >=", value, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleLessThan(String value) {
            addCriterion("is_single <", value, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleLessThanOrEqualTo(String value) {
            addCriterion("is_single <=", value, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleLike(String value) {
            addCriterion("is_single like", value, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleNotLike(String value) {
            addCriterion("is_single not like", value, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleIn(List<String> values) {
            addCriterion("is_single in", values, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleNotIn(List<String> values) {
            addCriterion("is_single not in", values, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleBetween(String value1, String value2) {
            addCriterion("is_single between", value1, value2, "isSingle");
            return (Criteria) this;
        }

        public Criteria andIsSingleNotBetween(String value1, String value2) {
            addCriterion("is_single not between", value1, value2, "isSingle");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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

        public Criteria andOperationTimeIsNull() {
            addCriterion("operation_time is null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIsNotNull() {
            addCriterion("operation_time is not null");
            return (Criteria) this;
        }

        public Criteria andOperationTimeEqualTo(Date value) {
            addCriterionForJDBCDate("operation_time =", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("operation_time <>", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("operation_time >", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("operation_time >=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThan(Date value) {
            addCriterionForJDBCDate("operation_time <", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("operation_time <=", value, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeIn(List<Date> values) {
            addCriterionForJDBCDate("operation_time in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("operation_time not in", values, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("operation_time between", value1, value2, "operationTime");
            return (Criteria) this;
        }

        public Criteria andOperationTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("operation_time not between", value1, value2, "operationTime");
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