package app.system.form.converter;

import app.base.converter.ConverterBase;
import app.system.form.entities.FormDefEntity;
import app.system.form.model.Form;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FormConverter extends ConverterBase<Form, FormDefEntity> {
    @Override
    public Form convert2Model(FormDefEntity formDefEntity) {
        Form form = new Form();
        BeanUtils.copyProperties(formDefEntity, form);
        return form;
    }

    @Override
    public FormDefEntity convert2Entity(Form form) {
        FormDefEntity formDefEntity = new FormDefEntity();
        BeanUtils.copyProperties(form, formDefEntity);
        return formDefEntity;
    }

}
