package app.system.form.model;

import app.base.model.BaseBizModel;
import app.comn.DataSourceType;

/**
 * FIXME 老六前台 拖到表单里一个 控件后
 * 表单控件列表 中插入一行
 * 然后 数据库里生成一列 更具字段类型 生成不同的 类型
 *
 */
public class FieldInfo extends BaseBizModel {
    private String code;
    private String name;
    //控件类型 参考sys_from_controls
    private String fieldType;
    /**数据库类型 FIXME 老六
     * 这个值前台不会穿  需改根据 fieldType后台自己生成
     * 比如 文本框 类型 就是varchar
     * 日期框就是 date
     * 这个对应关系可以建一张表或者 在sys_from_controls里加一列 存对应的数据库字段类型
     */
    //数据长度
    private int length;

    private int size;
    //小数位数0-6
    private int digits;
    //展示空间宽度1-12
    private int width;
    //提示
    private String prompt;
    //格式
    private String format;
    //正则
    private String regEx;
    //最大值
    private int max;
    private int min;
    //默认值
    private String defaultValue;
    //公式
    private String formula;
    //数据源类型
    private DataSourceType dataSourceType;
    //数据源
    private String dataSource;
    //选项
    private String options;
    //备注
    private String remark;

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

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getDigits() {
        return digits;
    }

    public void setDigits(int digits) {
        this.digits = digits;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRegEx() {
        return regEx;
    }

    public void setRegEx(String regEx) {
        this.regEx = regEx;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public DataSourceType getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(DataSourceType dataSourceType) {
        this.dataSourceType = dataSourceType;
    }

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
