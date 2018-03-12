package app.system.form.service;

import app.system.form.model.FieldInfo;

import java.util.List;

/**
 * Created by real on 2018/3/12.
 */
public interface FieldInfoService {

    List<FieldInfo> selectFieldByFormId(String formId);
}
