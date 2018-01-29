package app.dao.mappers;

import app.dao.entities.SysUserRoleRel;
import app.dao.entities.SysUserRoleRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserRoleRelMapper {
    long countByExample(SysUserRoleRelExample example);

    int deleteByExample(SysUserRoleRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysUserRoleRel record);

    int insertSelective(SysUserRoleRel record);

    List<SysUserRoleRel> selectByExample(SysUserRoleRelExample example);

    SysUserRoleRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysUserRoleRel record, @Param("example") SysUserRoleRelExample example);

    int updateByExample(@Param("record") SysUserRoleRel record, @Param("example") SysUserRoleRelExample example);

    int updateByPrimaryKeySelective(SysUserRoleRel record);

    int updateByPrimaryKey(SysUserRoleRel record);
}