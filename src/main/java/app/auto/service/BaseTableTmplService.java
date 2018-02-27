package app.auto.service;

import app.auto.entities.SysBaseTabEntity;

import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
public interface BaseTableTmplService {

    List<SysBaseTabEntity> getTableBody(String tmplname);
}
