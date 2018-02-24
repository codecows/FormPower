package app.form.service;

import app.comn.PageModel;
import app.form.model.Form;

import java.util.List;

/**
 * Created by real on 2018/2/24.
 */
public interface FormService {

    List<Form> getItems();

    PageModel<Form> getItemsByPage(int pageNum, int pageSize);
}
