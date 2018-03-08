package app.system.form.converter;

import app.base.converter.ConverterBase;
import app.dao.entities.SysFormDef;
import app.system.form.model.Form;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class FormConverter extends ConverterBase<Form, SysFormDef> {
    @Override
    public Form convert2Model(SysFormDef formDefEntity) {
        Form form = new Form();
        BeanUtils.copyProperties(formDefEntity, form);
        return form;
    }

    @Override
    public SysFormDef convert2Entity(Form form) {
        SysFormDef formDefEntity = new SysFormDef();
        BeanUtils.copyProperties(form, formDefEntity);
        return formDefEntity;
    }

}
