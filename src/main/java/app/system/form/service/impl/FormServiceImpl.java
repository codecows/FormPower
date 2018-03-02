package app.system.form.service.impl;

import app.system.form.converter.FormConverter;
import app.system.form.entities.FormDefEntity;
import app.system.form.mappers.FormDefMapper;
import app.system.form.model.Form;
import app.system.form.service.FormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by real on 2018/2/24.
 */
@Service
public class FormServiceImpl implements FormService {

    @Resource
    private FormDefMapper formDefMapper;

    @Resource
    private FormConverter formConverter;

    @Override
    public List<Form> getItems() {
        List<FormDefEntity> formDefEntities = formDefMapper.selectAll();
        List<Form> forms = formConverter.convert2ModelList(formDefEntities);
        return forms;
    }

    @Override
    public List<Form> getItemsByPage(int start, int length) {

        List<FormDefEntity> formDefEntities = formDefMapper.selectByPage(start, length);
        List<Form> forms = formConverter.convert2ModelList(formDefEntities);

        return forms;
    }
}
