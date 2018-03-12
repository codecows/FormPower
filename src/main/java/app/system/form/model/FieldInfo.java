package app.system.form.model;


import io.swagger.annotations.ApiModel;

import java.util.List;

@ApiModel("为form添加控件的模型")
public class FieldInfo extends FieldModel {

    private List<AttributeModel> attributeModels;

    public List<AttributeModel> getAttributeModels() {
        return attributeModels;
    }

    public void setAttributeModels(List<AttributeModel> attributeModels) {
        this.attributeModels = attributeModels;
    }
}
