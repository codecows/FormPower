package app.system.form.service;

import app.comn.ServiceException;
import app.system.form.model.FieldInfo;
import app.system.form.model.Form;

import java.util.List;

/**
 * Created by real on 2018/2/24.
 */
public interface FormService {

    /**
     * 获取formdef表中的数据
     */
    List<Form> getItems();

    /**
     * 分页获取formdef表中的数据
     */
    List<Form> getItemsByPage(int start, int length);

    /**
     * 前端创建form后，在定义表中添加数据，在数据库中创建相应的表
     */
    void createForm(Form form) throws ServiceException;

    /**
     * 前端删除form后，在定义表中删除数据，在数据库中删除相应的表
     */
    void dropForm(String formId) throws ServiceException;

    /**
     * 根据formid查找该form中的控件及控件属性
     */
    List<FieldInfo> selectFieldByFormId(String formId);

    /**
     * 设计表使添加控件后，保存数据到forminfomation表中，并修改相应的数据表
     */
    void designForm(List<FieldInfo> fieldInfo) throws ServiceException;

    /**
     * 传入formid获取该form的表单设计信息
     **/
    List<FieldInfo> fatchFormDesignInformation(String formId);
}
