package app.dao.mappers;

import app.dao.entities.SysUserGroupRel;
import app.dao.entities.SysUserGroupRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserGroupRelMapper {
    long countByExample(SysUserGroupRelExample example);

    int deleteByExample(SysUserGroupRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysUserGroupRel record);

    int insertSelective(SysUserGroupRel record);

    List<SysUserGroupRel> selectByExample(SysUserGroupRelExample example);

    SysUserGroupRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysUserGroupRel record, @Param("example") SysUserGroupRelExample example);

    int updateByExample(@Param("record") SysUserGroupRel record, @Param("example") SysUserGroupRelExample example);

    int updateByPrimaryKeySelective(SysUserGroupRel record);

    int updateByPrimaryKey(SysUserGroupRel record);
}