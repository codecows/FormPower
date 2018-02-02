package app.management.departmentinfo.service.impl;

import app.management.departmentinfo.converter.DepartmentInfoConverter;
import app.management.departmentinfo.entities.DepartmentInfoEntity;
import app.management.departmentinfo.mappers.DepartmentInfoMapper;
import app.management.departmentinfo.model.DepartmentInfo;
import app.management.departmentinfo.service.DepartmentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Fan on 2018/2/2.
 */
@Service
public class DepartmentInfoServiceImpl implements DepartmentInfoService {


    @Resource
    private DepartmentInfoMapper departmentInfoMapper;

    @Resource
    private DepartmentInfoConverter departmentInfoConverter;

    @Override
    public DepartmentInfo getItem(String userId) {
        DepartmentInfoEntity departmentInfoEntity = departmentInfoMapper.selectByUserId(userId);
        DepartmentInfo departmentInfo = departmentInfoConverter.convert2Model(departmentInfoEntity);
        return departmentInfo;
    }
}
