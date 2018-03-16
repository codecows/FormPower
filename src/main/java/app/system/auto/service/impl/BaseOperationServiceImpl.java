package app.system.auto.service.impl;

import app.system.auto.mappers.OperationMapper;
import app.system.auto.model.BaseColumnModel;
import app.system.auto.model.BaseFunctionModel;
import app.system.auto.service.BaseOperationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
@Service
public class BaseOperationServiceImpl implements BaseOperationService {


    @Resource
    private OperationMapper operationMapper;

    @Override
    public void createTable(String tablename, String tablecomment, List<BaseColumnModel> baseColumnModels) {

        operationMapper.createTable(tablename, tablecomment, baseColumnModels);

    }

    @Override
    public void dropTable(String tablename) {
        operationMapper.dropTable(tablename);
    }

    @Override
    public void addColumn(String tablename, List<BaseColumnModel> baseColumnModels) {
        operationMapper.addColumn(tablename, baseColumnModels);
    }

    @Override
    public void dropColumn(String tablename, List<BaseColumnModel> baseColumnModels) {
        operationMapper.dropColumn(tablename, baseColumnModels);
    }

    @Override
    public void createFunction(BaseFunctionModel baseFunctionModel) {
        String fBody = baseFunctionModel.getFuncBody().replace("<br/>", "\n");
        baseFunctionModel.setFuncBody(fBody);
        operationMapper.createFunction(baseFunctionModel);
    }

    @Override
    public Object execFunction(String funcname, String paralist) {
        Object o = operationMapper.execFunction(funcname, paralist);
        return o;
    }
}
