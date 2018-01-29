package app.dao.mappers;

import app.dao.entities.SysGroupRoleRel;
import app.dao.entities.SysGroupRoleRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysGroupRoleRelMapper {
    long countByExample(SysGroupRoleRelExample example);

    int deleteByExample(SysGroupRoleRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysGroupRoleRel record);

    int insertSelective(SysGroupRoleRel record);

    List<SysGroupRoleRel> selectByExample(SysGroupRoleRelExample example);

    SysGroupRoleRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysGroupRoleRel record, @Param("example") SysGroupRoleRelExample example);

    int updateByExample(@Param("record") SysGroupRoleRel record, @Param("example") SysGroupRoleRelExample example);

    int updateByPrimaryKeySelective(SysGroupRoleRel record);

    int updateByPrimaryKey(SysGroupRoleRel record);
}