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
    public PageModel<Form> getItemsByPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        Page<FormDefEntity> formDefEntities = (Page<FormDefEntity>) formDefMapper.selectAll();
        List<Form> forms = formConverter.convert2ModelList(formDefEntities);

        PageModel<Form> userPageModel = new PageModel<>(forms, ConstantPage.NAVIGATE_SIZE,
                formDefEntities.getPageNum(),
                formDefEntities.getPageSize(),
                formDefEntities.getPages(),
                formDefEntities.size(),
                formDefEntities.getTotal(),
                formDefEntities.getStartRow());

        return userPageModel;
    }
}
