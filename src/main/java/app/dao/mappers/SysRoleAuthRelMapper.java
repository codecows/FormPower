package app.dao.mappers;

import app.dao.entities.SysRoleAuthRel;
import app.dao.entities.SysRoleAuthRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleAuthRelMapper {
    long countByExample(SysRoleAuthRelExample example);

    int deleteByExample(SysRoleAuthRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysRoleAuthRel record);

    int insertSelective(SysRoleAuthRel record);

    List<SysRoleAuthRel> selectByExample(SysRoleAuthRelExample example);

    SysRoleAuthRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysRoleAuthRel record, @Param("example") SysRoleAuthRelExample example);

    int updateByExample(@Param("record") SysRoleAuthRel record, @Param("example") SysRoleAuthRelExample example);

    int updateByPrimaryKeySelective(SysRoleAuthRel record);

    int updateByPrimaryKey(SysRoleAuthRel record);
}