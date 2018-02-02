package app.management.roleinfo.converter;

import app.base.converter.ConverterBase;
import app.management.roleinfo.entities.RoleInfoEntity;
import app.management.roleinfo.entities.RolePojoEntity;
import app.management.roleinfo.model.RoleInfo;
import app.management.roleinfo.model.RolePojo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by real on 2018/1/27.
 */
@Component
public class RolePojoConverter extends ConverterBase<RolePojo, RolePojoEntity> {
    @Override
    public RolePojo convert2Model(RolePojoEntity rolePojoEntity) {
        RolePojo rolePojo = new RolePojo();
        BeanUtils.copyProperties(rolePojoEntity, rolePojo);
        return rolePojo;
    }

    @Override
    public RolePojoEntity convert2Entity(RolePojo rolePojo) {
        RolePojoEntity rolePojoEntity = new RolePojoEntity();
        BeanUtils.copyProperties(rolePojo, rolePojoEntity);
        return rolePojoEntity;
    }
}
