package app.management.departmentinfo.service.impl;

import app.management.departmentinfo.converter.DepartmentInfoConverter;
import app.management.departmentinfo.entities.DepartmentInfoEntity;
import app.management.departmentinfo.mappers.DepartmentInfoMapper;
import app.management.departmentinfo.model.DepartmentInfo;
import app.management.departmentinfo.service.DepartmentInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<DepartmentInfo> getItem(String userId) {
        List<DepartmentInfoEntity> departmentInfoEntities = departmentInfoMapper.selectByUserId(userId);
        List<DepartmentInfo> departmentInfos = departmentInfoConverter.convert2ModelList(departmentInfoEntities);
        return departmentInfos;
    }
}
