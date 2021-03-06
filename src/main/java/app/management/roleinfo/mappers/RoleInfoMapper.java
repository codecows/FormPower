package app.management.roleinfo.mappers;

import app.management.roleinfo.entities.RoleInfoEntity;
import app.management.roleinfo.entities.RolePojoEntity;

import java.util.List;

/**
 * Created by real on 2018/2/1.
 */
public interface RoleInfoMapper {

    List<RoleInfoEntity> selectAllRecord();

    RoleInfoEntity selectByPrimaryKey(String roleId);

    List<RolePojoEntity> selectByUserId(String userId);
}
