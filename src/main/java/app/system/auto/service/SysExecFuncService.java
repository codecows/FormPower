package app.system.auto.service;

import app.system.auto.model.ExecFunc;

import java.util.List;

/**
 * Created by real on 2018/2/28.
 */
public interface SysExecFuncService {
    List<ExecFunc> getItemByObjectId(String objectid);

    void addItems(ExecFunc execFunc);
}
