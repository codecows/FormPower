package app.form.service.impl;

import app.comn.ConstantPage;
import app.comn.PageModel;
import app.form.converter.FormConverter;
import app.form.entities.FormDefEntity;
import app.form.mappers.FormDefMapper;
import app.form.model.Form;
import app.form.service.FormService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
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
