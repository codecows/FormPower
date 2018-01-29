package app.dao.mappers;

import app.dao.entities.SysAuthMenuRel;
import app.dao.entities.SysAuthMenuRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysAuthMenuRelMapper {
    long countByExample(SysAuthMenuRelExample example);

    int deleteByExample(SysAuthMenuRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysAuthMenuRel record);

    int insertSelective(SysAuthMenuRel record);

    List<SysAuthMenuRel> selectByExample(SysAuthMenuRelExample example);

    SysAuthMenuRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysAuthMenuRel record, @Param("example") SysAuthMenuRelExample example);

    int updateByExample(@Param("record") SysAuthMenuRel record, @Param("example") SysAuthMenuRelExample example);

    int updateByPrimaryKeySelective(SysAuthMenuRel record);

    int updateByPrimaryKey(SysAuthMenuRel record);
}