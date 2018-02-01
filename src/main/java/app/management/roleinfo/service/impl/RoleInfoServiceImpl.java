package app.management.roleinfo.service.impl;


import app.management.roleinfo.converter.RoleInfoConverter;
import app.management.roleinfo.entities.RoleInfoEntity;
import app.management.roleinfo.mappers.RoleInfoMapper;
import app.management.roleinfo.model.RoleInfo;
import app.management.roleinfo.service.RoleInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by real on 2018/2/1.
 */
@Service
public class RoleInfoServiceImpl implements RoleInfoService {
    private final static Logger logger = LoggerFactory.getLogger(RoleInfoServiceImpl.class);

    @Resource
    private RoleInfoMapper roleInfoMapper;

    @Resource
    private RoleInfoConverter roleInfoConverter;

    @Override
    public RoleInfo getItem(String roleId) {
        RoleInfoEntity roleInfoEntity = roleInfoMapper.selectByPrimaryKey(roleId);
        RoleInfo roleInfo = roleInfoConverter.convert2Model(roleInfoEntity);
        return roleInfo;
    }

    @Override
    public List<RoleInfo> getItems() {
        List<RoleInfoEntity> roleInfoEntities = roleInfoMapper.selectAllRecord();

        List<RoleInfo> roleInfos = roleInfoConverter.convert2ModelList(roleInfoEntities);


        return roleInfos;
    }
}
