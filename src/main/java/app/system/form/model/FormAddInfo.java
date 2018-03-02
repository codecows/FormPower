package app.system.form.model;

import app.base.model.BaseBizModel;

/**
 * FIXME 老六 新建表单实体
 * 新建一个表单后 form 表里新增一条记录
 * 然后网数据库新增一个表 表名为id 属性
 * 生成的表 采用统一前缀  比如 u_table1
 */
public class FormAddInfo extends BaseBizModel {
    //表名
    private String id;
    private String name;
    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
