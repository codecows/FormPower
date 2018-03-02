package app.system.auto.service.impl;

import app.system.auto.converter.ExecFuncConverter;
import app.system.auto.entities.SysExecFunc;
import app.system.auto.entities.SysExecFuncExample;
import app.system.auto.mappers.SysExecFuncMapper;
import app.system.auto.model.ExecFunc;
import app.system.auto.service.SysExecFuncService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by real on 2018/2/28.
 */
@Service
public class SysExecFuncServiceImpl implements SysExecFuncService {

    @Resource
    private SysExecFuncMapper sysExecFuncMapper;

    @Resource
    private ExecFuncConverter execFuncConverter;

    @Override
    public List<ExecFunc> getItemByObjectId(String objectid) {
        SysExecFuncExample sysExecFuncExample = new SysExecFuncExample();
        sysExecFuncExample.createCriteria().andObjectIdEqualTo(objectid);
        List<SysExecFunc> sysExecFuncs = sysExecFuncMapper.selectByExample(sysExecFuncExample);
        List<ExecFunc> execFuncs = execFuncConverter.convert2ModelList(sysExecFuncs);
        return execFuncs;
    }

    @Override
    public void addItems(ExecFunc execFunc) {
        SysExecFunc sysExecFunc = execFuncConverter.convert2Entity(execFunc);
        sysExecFuncMapper.insertSelective(sysExecFunc);
    }
}
