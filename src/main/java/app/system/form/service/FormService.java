package app.system.form.service;

import app.comn.ServiceException;
import app.system.form.model.FieldInfo;
import app.system.form.model.Form;

import java.util.List;

/**
 * Created by real on 2018/2/24.
 */
public interface FormService {

    List<Form> getItems();

    List<Form> getItemsByPage(int start, int length);

    void addItem(Form form) throws ServiceException;

    void delItem(String formId) throws ServiceException;

    List<FieldInfo> selectFieldByFormId(String formId);

    void designForm(List<FieldInfo> fieldInfo);
}
