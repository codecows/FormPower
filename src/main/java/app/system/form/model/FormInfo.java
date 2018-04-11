package app.system.form.model;

import app.base.model.BaseBizModel;

import java.util.List;

/**
 * FIXME 老六 新建表单实体
 * 新建一个表单后 form 表里新增一条记录
 * 然后网数据库新增一个表 表名为id 属性
 * 生成的表 采用统一前缀  比如 u_table1
 * 默认生成 一个存储过程
 * 参数有
 * 表单ID
 * 操作人
 * 操作时间
 * 操作类型 增删改 ADD/DEL/UPD
 * <p>
 * 无返回值
 */
public class FormInfo extends BaseBizModel {
    //表名
    private String code;
    private String name;
    private String remark;
    //js内容
    private String script;
    //函数名
    private String sql;

    private String status;

    List<FormFiled> fileds;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<FormFiled> getFileds() {
        return fileds;
    }

    public void setFileds(List<FormFiled> fileds) {
        this.fileds = fileds;
    }
}


