package app.dao.mappers;

import app.dao.entities.SysUserDepartmentRel;
import app.dao.entities.SysUserDepartmentRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserDepartmentRelMapper {
    long countByExample(SysUserDepartmentRelExample example);

    int deleteByExample(SysUserDepartmentRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysUserDepartmentRel record);

    int insertSelective(SysUserDepartmentRel record);

    List<SysUserDepartmentRel> selectByExample(SysUserDepartmentRelExample example);

    SysUserDepartmentRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysUserDepartmentRel record, @Param("example") SysUserDepartmentRelExample example);

    int updateByExample(@Param("record") SysUserDepartmentRel record, @Param("example") SysUserDepartmentRelExample example);

    int updateByPrimaryKeySelective(SysUserDepartmentRel record);

    int updateByPrimaryKey(SysUserDepartmentRel record);
}