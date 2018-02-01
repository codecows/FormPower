package app.management.roleinfo.converter;

import app.base.converter.ConverterBase;
import app.management.roleinfo.entities.RoleInfoEntity;
import app.management.roleinfo.model.RoleInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by real on 2018/1/27.
 */
@Component
public class RoleInfoConverter extends ConverterBase<RoleInfo, RoleInfoEntity> {
    @Override
    public RoleInfo convert2Model(RoleInfoEntity roleInfoEntity) {
        RoleInfo roleInfo = new RoleInfo();
        BeanUtils.copyProperties(roleInfoEntity, roleInfo);
        return roleInfo;
    }

    @Override
    public RoleInfoEntity convert2Entity(RoleInfo roleInfo) {
        RoleInfoEntity roleInfoEntity = new RoleInfoEntity();
        BeanUtils.copyProperties(roleInfo, roleInfoEntity);
        return roleInfoEntity;
    }
}
