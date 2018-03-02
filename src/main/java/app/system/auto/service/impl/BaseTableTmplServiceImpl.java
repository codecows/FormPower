package app.system.auto.service.impl;

import app.system.auto.entities.SysBaseTabEntity;
import app.system.auto.mappers.SysBaseTabTmplMapper;
import app.system.auto.service.BaseTableTmplService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
@Service
public class BaseTableTmplServiceImpl implements BaseTableTmplService {

    @Resource
    private SysBaseTabTmplMapper sysBaseTabTmplMapper;

    @Override
    public List<SysBaseTabEntity> getTableBody(String tmplname) {
        List<SysBaseTabEntity> sysBaseTabEntities = sysBaseTabTmplMapper.selectByTmplName(tmplname);
        return sysBaseTabEntities;
    }
}
