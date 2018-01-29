package app.dao.mappers;

import app.dao.entities.SysUserAuthRel;
import app.dao.entities.SysUserAuthRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserAuthRelMapper {
    long countByExample(SysUserAuthRelExample example);

    int deleteByExample(SysUserAuthRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysUserAuthRel record);

    int insertSelective(SysUserAuthRel record);

    List<SysUserAuthRel> selectByExample(SysUserAuthRelExample example);

    SysUserAuthRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysUserAuthRel record, @Param("example") SysUserAuthRelExample example);

    int updateByExample(@Param("record") SysUserAuthRel record, @Param("example") SysUserAuthRelExample example);

    int updateByPrimaryKeySelective(SysUserAuthRel record);

    int updateByPrimaryKey(SysUserAuthRel record);
}