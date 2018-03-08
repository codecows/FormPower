package app.system.form.service.impl;

import app.comn.ResponseCode;
import app.comn.ServiceException;
import app.dao.entities.SysFormDef;
import app.dao.entities.SysFormDefExample;
import app.system.form.converter.FormConverter;
import app.system.form.mappers.FormDefMapper;
import app.system.form.model.Form;
import app.system.form.service.FormService;
import org.springframework.dao.DataAccessException;
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
        List<SysFormDef> formDefEntities = formDefMapper.selectAll();
        List<Form> forms = formConverter.convert2ModelList(formDefEntities);
        return forms;
    }

    @Override
    public List<Form> getItemsByPage(int start, int length) {

        List<SysFormDef> formDefEntities = formDefMapper.selectByPage(start, length);
        List<Form> forms = formConverter.convert2ModelList(formDefEntities);
        return forms;
    }

    @Override
    public void addItem(Form form) throws ServiceException {
        SysFormDefExample sysFormDefExample = new SysFormDefExample();
        sysFormDefExample.createCriteria().andFormIdEqualTo(form.getFormId());

        if (formDefMapper.countByExample(sysFormDefExample) > 0) {
            throw new ServiceException(ResponseCode.InformationExist);
        }
        SysFormDef sysFormDef = formConverter.convert2Entity(form);

        try {
            formDefMapper.insertSelective(sysFormDef);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }
    }

    @Override
    public void delItem(String formId) throws ServiceException {
        SysFormDefExample sysFormDefExample = new SysFormDefExample();
        sysFormDefExample.createCriteria().andFormIdEqualTo(formId);

        if (formDefMapper.countByExample(sysFormDefExample) == 0) {
            throw new ServiceException(ResponseCode.InformationUnexist);
        }

        try {
            formDefMapper.deleteByPrimaryKey(formId);
        } catch (DataAccessException e) {
            throw new ServiceException(ResponseCode.UnknowSqlException);
        }


    }


}
