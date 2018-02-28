package app.auto.service.impl;

import app.auto.mappers.OperationMapper;
import app.auto.model.BaseFunctionModel;
import app.auto.service.BaseOperationService;
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
    public void createTable(String tablename, List tablebody) {

        operationMapper.createTable(tablename, tablebody);

    }

    @Override
    public void addColumn(String tablename, List body) {
        operationMapper.addColumn(tablename, body);
    }

    @Override
    public void createFunction(BaseFunctionModel baseFunctionModel) {
        operationMapper.createFunction(baseFunctionModel);
    }
}