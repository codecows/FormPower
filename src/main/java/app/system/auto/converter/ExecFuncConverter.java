package app.system.auto.converter;

import app.base.converter.ConverterBase;
import app.system.auto.entities.SysExecFunc;
import app.system.auto.model.ExecFunc;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by real on 2018/1/25.
 */
@Component
public class ExecFuncConverter extends ConverterBase<ExecFunc, SysExecFunc> {
    @Override
    public ExecFunc convert2Model(SysExecFunc sysExecFunc) {
        ExecFunc execFunc = new ExecFunc();
        BeanUtils.copyProperties(sysExecFunc, execFunc);
        return execFunc;
    }

    @Override
    public SysExecFunc convert2Entity(ExecFunc execFunc) {
        SysExecFunc sysExecFunc = new SysExecFunc();
        BeanUtils.copyProperties(execFunc, sysExecFunc);
        return sysExecFunc;
    }
}
