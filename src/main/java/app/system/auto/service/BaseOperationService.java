package app.system.auto.service;

import app.system.auto.model.BaseFunctionModel;

import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
public interface BaseOperationService {

    void createTable(String tablename, String tablecomment, List tablebody);

    void dropTable(String tablename);

    void addColumn(String tablename, List body);

    void createFunction(BaseFunctionModel baseFunctionModel);

    Object execFunction(String funcname, String paralist);

}
