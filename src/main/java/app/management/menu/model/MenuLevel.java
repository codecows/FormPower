package app.management.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Fan on 2018/2/2.
 */
@ApiModel("层级菜单业务实体")
public class MenuLevel {

    @ApiModelProperty("菜单ID")
    private String menuId;

    @ApiModelProperty("上级ID")
    private String parentId;

    @ApiModelProperty("菜单类型")
    private String menuType;

    @ApiModelProperty("菜单等级")
    private String menuLevel;

    @ApiModelProperty("菜单名称")
    private String menuName;

    @ApiModelProperty("菜单编码")
    private String menuCode;

    @ApiModelProperty("菜单路径")
    private String menuPath;

    @ApiModelProperty("表单ID")
    private String formId;

    @ApiModelProperty("URL")
    private String menuUrl;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("排序号")
    private BigDecimal orderNum;

    @ApiModelProperty("状态")
    private String status;

    @ApiModelProperty("更新时间")
    private Date createDate;

    private List<MenuLevel> menuLevels;

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(BigDecimal orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<MenuLevel> getMenuLevels() {
        return menuLevels;
    }

    public void setMenuLevels(List<MenuLevel> menuLevels) {
        this.menuLevels = menuLevels;
    }
}
