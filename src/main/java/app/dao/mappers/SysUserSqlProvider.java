package app.dao.mappers;

import app.dao.entities.SysUser;
import app.dao.entities.SysUserExample;
import app.dao.entities.SysUserExample.Criteria;
import app.dao.entities.SysUserExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SysUserSqlProvider {

    public String countByExample(SysUserExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysUserExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysUser record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_user");
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.VALUES("password", "#{password,jdbcType=VARCHAR}");
        }
        
        if (record.getQuestion() != null) {
            sql.VALUES("question", "#{question,jdbcType=VARCHAR}");
        }
        
        if (record.getAnswer() != null) {
            sql.VALUES("answer", "#{answer,jdbcType=VARCHAR}");
        }
        
        if (record.getPersionName() != null) {
            sql.VALUES("persion_name", "#{persionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPersionSex() != null) {
            sql.VALUES("persion_sex", "#{persionSex,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.VALUES("mobile", "#{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.VALUES("telephone", "#{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.VALUES("email", "#{email,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPosition() != null) {
            sql.VALUES("user_position", "#{userPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.VALUES("img_url", "#{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }

        if (record.getOrderNum() != null) {
            sql.VALUES("order_num", "#{orderNum,jdbcType=NUMERIC}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=DATE}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SysUserExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("user_id");
        } else {
            sql.SELECT("user_id");
        }
        sql.SELECT("user_name");
        sql.SELECT("password");
        sql.SELECT("question");
        sql.SELECT("answer");
        sql.SELECT("persion_name");
        sql.SELECT("persion_sex");
        sql.SELECT("mobile");
        sql.SELECT("telephone");
        sql.SELECT("email");
        sql.SELECT("user_position");
        sql.SELECT("img_url");
        sql.SELECT("remark");
        sql.SELECT("order_num");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.FROM("sys_user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysUser record = (SysUser) parameter.get("record");
        SysUserExample example = (SysUserExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("sys_user");
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        }
        
        if (record.getQuestion() != null) {
            sql.SET("question = #{record.question,jdbcType=VARCHAR}");
        }
        
        if (record.getAnswer() != null) {
            sql.SET("answer = #{record.answer,jdbcType=VARCHAR}");
        }
        
        if (record.getPersionName() != null) {
            sql.SET("persion_name = #{record.persionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPersionSex() != null) {
            sql.SET("persion_sex = #{record.persionSex,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("telephone = #{record.telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPosition() != null) {
            sql.SET("user_position = #{record.userPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.SET("img_url = #{record.imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }

        if (record.getOrderNum() != null) {
            sql.SET("order_num = #{record.orderNum,jdbcType=NUMERIC}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=DATE}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_user");
        
        sql.SET("user_id = #{record.userId,jdbcType=VARCHAR}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("password = #{record.password,jdbcType=VARCHAR}");
        sql.SET("question = #{record.question,jdbcType=VARCHAR}");
        sql.SET("answer = #{record.answer,jdbcType=VARCHAR}");
        sql.SET("persion_name = #{record.persionName,jdbcType=VARCHAR}");
        sql.SET("persion_sex = #{record.persionSex,jdbcType=VARCHAR}");
        sql.SET("mobile = #{record.mobile,jdbcType=VARCHAR}");
        sql.SET("telephone = #{record.telephone,jdbcType=VARCHAR}");
        sql.SET("email = #{record.email,jdbcType=VARCHAR}");
        sql.SET("user_position = #{record.userPosition,jdbcType=VARCHAR}");
        sql.SET("img_url = #{record.imgUrl,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("order_num = #{record.orderNum,jdbcType=NUMERIC}");
        sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        sql.SET("create_time = #{record.createTime,jdbcType=DATE}");
        
        SysUserExample example = (SysUserExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysUser record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_user");
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getPassword() != null) {
            sql.SET("password = #{password,jdbcType=VARCHAR}");
        }
        
        if (record.getQuestion() != null) {
            sql.SET("question = #{question,jdbcType=VARCHAR}");
        }
        
        if (record.getAnswer() != null) {
            sql.SET("answer = #{answer,jdbcType=VARCHAR}");
        }
        
        if (record.getPersionName() != null) {
            sql.SET("persion_name = #{persionName,jdbcType=VARCHAR}");
        }
        
        if (record.getPersionSex() != null) {
            sql.SET("persion_sex = #{persionSex,jdbcType=VARCHAR}");
        }
        
        if (record.getMobile() != null) {
            sql.SET("mobile = #{mobile,jdbcType=VARCHAR}");
        }
        
        if (record.getTelephone() != null) {
            sql.SET("telephone = #{telephone,jdbcType=VARCHAR}");
        }
        
        if (record.getEmail() != null) {
            sql.SET("email = #{email,jdbcType=VARCHAR}");
        }
        
        if (record.getUserPosition() != null) {
            sql.SET("user_position = #{userPosition,jdbcType=VARCHAR}");
        }
        
        if (record.getImgUrl() != null) {
            sql.SET("img_url = #{imgUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }

        if (record.getOrderNum() != null) {
            sql.SET("order_num = #{orderNum,jdbcType=NUMERIC}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=DATE}");
        }
        
        sql.WHERE("user_id = #{userId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysUserExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}