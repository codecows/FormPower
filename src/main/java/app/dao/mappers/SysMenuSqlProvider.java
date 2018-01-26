package app.dao.mappers;

import app.dao.entities.SysMenu;
import app.dao.entities.SysMenuExample;
import app.dao.entities.SysMenuExample.Criteria;
import app.dao.entities.SysMenuExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class SysMenuSqlProvider {

    public String countByExample(SysMenuExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("sys_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SysMenuExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("sys_menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SysMenu record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("sys_menu");

        if (record.getMenuId() != null) {
            sql.VALUES("menu_id", "#{menuId,jdbcType=VARCHAR}");
        }

        if (record.getParentId() != null) {
            sql.VALUES("parent_id", "#{parentId,jdbcType=VARCHAR}");
        }

        if (record.getMenuType() != null) {
            sql.VALUES("menu_type", "#{menuType,jdbcType=VARCHAR}");
        }

        if (record.getMenuLevel() != null) {
            sql.VALUES("menu_level", "#{menuLevel,jdbcType=VARCHAR}");
        }

        if (record.getMenuName() != null) {
            sql.VALUES("menu_name", "#{menuName,jdbcType=VARCHAR}");
        }

        if (record.getMenuCode() != null) {
            sql.VALUES("menu_code", "#{menuCode,jdbcType=VARCHAR}");
        }

        if (record.getMenuPath() != null) {
            sql.VALUES("menu_path", "#{menuPath,jdbcType=VARCHAR}");
        }

        if (record.getMenuUrl() != null) {
            sql.VALUES("menu_url", "#{menuUrl,jdbcType=VARCHAR}");
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

        if (record.getCreateDate() != null) {
            sql.VALUES("create_date", "#{createDate,jdbcType=DATE}");
        }

        return sql.toString();
    }

    public String selectByExample(SysMenuExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("menu_id");
        } else {
            sql.SELECT("menu_id");
        }
        sql.SELECT("parent_id");
        sql.SELECT("menu_type");
        sql.SELECT("menu_level");
        sql.SELECT("menu_name");
        sql.SELECT("menu_code");
        sql.SELECT("menu_path");
        sql.SELECT("menu_url");
        sql.SELECT("remark");
        sql.SELECT("order_num");
        sql.SELECT("status");
        sql.SELECT("create_date");
        sql.FROM("sys_menu");
        applyWhere(sql, example, false);

        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }

        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SysMenu record = (SysMenu) parameter.get("record");
        SysMenuExample example = (SysMenuExample) parameter.get("example");

        SQL sql = new SQL();
        sql.UPDATE("sys_menu");

        if (record.getMenuId() != null) {
            sql.SET("menu_id = #{record.menuId,jdbcType=VARCHAR}");
        }

        if (record.getParentId() != null) {
            sql.SET("parent_id = #{record.parentId,jdbcType=VARCHAR}");
        }

        if (record.getMenuType() != null) {
            sql.SET("menu_type = #{record.menuType,jdbcType=VARCHAR}");
        }

        if (record.getMenuLevel() != null) {
            sql.SET("menu_level = #{record.menuLevel,jdbcType=VARCHAR}");
        }

        if (record.getMenuName() != null) {
            sql.SET("menu_name = #{record.menuName,jdbcType=VARCHAR}");
        }

        if (record.getMenuCode() != null) {
            sql.SET("menu_code = #{record.menuCode,jdbcType=VARCHAR}");
        }

        if (record.getMenuPath() != null) {
            sql.SET("menu_path = #{record.menuPath,jdbcType=VARCHAR}");
        }

        if (record.getMenuUrl() != null) {
            sql.SET("menu_url = #{record.menuUrl,jdbcType=VARCHAR}");
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

        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{record.createDate,jdbcType=DATE}");
        }

        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("sys_menu");

        sql.SET("menu_id = #{record.menuId,jdbcType=VARCHAR}");
        sql.SET("parent_id = #{record.parentId,jdbcType=VARCHAR}");
        sql.SET("menu_type = #{record.menuType,jdbcType=VARCHAR}");
        sql.SET("menu_level = #{record.menuLevel,jdbcType=VARCHAR}");
        sql.SET("menu_name = #{record.menuName,jdbcType=VARCHAR}");
        sql.SET("menu_code = #{record.menuCode,jdbcType=VARCHAR}");
        sql.SET("menu_path = #{record.menuPath,jdbcType=VARCHAR}");
        sql.SET("menu_url = #{record.menuUrl,jdbcType=VARCHAR}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("order_num = #{record.orderNum,jdbcType=NUMERIC}");
        sql.SET("status = #{record.status,jdbcType=VARCHAR}");
        sql.SET("create_date = #{record.createDate,jdbcType=DATE}");

        SysMenuExample example = (SysMenuExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SysMenu record) {
        SQL sql = new SQL();
        sql.UPDATE("sys_menu");

        if (record.getParentId() != null) {
            sql.SET("parent_id = #{parentId,jdbcType=VARCHAR}");
        }

        if (record.getMenuType() != null) {
            sql.SET("menu_type = #{menuType,jdbcType=VARCHAR}");
        }

        if (record.getMenuLevel() != null) {
            sql.SET("menu_level = #{menuLevel,jdbcType=VARCHAR}");
        }

        if (record.getMenuName() != null) {
            sql.SET("menu_name = #{menuName,jdbcType=VARCHAR}");
        }

        if (record.getMenuCode() != null) {
            sql.SET("menu_code = #{menuCode,jdbcType=VARCHAR}");
        }

        if (record.getMenuPath() != null) {
            sql.SET("menu_path = #{menuPath,jdbcType=VARCHAR}");
        }

        if (record.getMenuUrl() != null) {
            sql.SET("menu_url = #{menuUrl,jdbcType=VARCHAR}");
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

        if (record.getCreateDate() != null) {
            sql.SET("create_date = #{createDate,jdbcType=DATE}");
        }

        sql.WHERE("menu_id = #{menuId,jdbcType=VARCHAR}");

        return sql.toString();
    }

    protected void applyWhere(SQL sql, SysMenuExample example, boolean includeExamplePhrase) {
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
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j, criterion.getTypeHandler()));
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