package app.dao.mappers;

import app.dao.entities.SysGroupAuthRel;
import app.dao.entities.SysGroupAuthRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysGroupAuthRelMapper {
    long countByExample(SysGroupAuthRelExample example);

    int deleteByExample(SysGroupAuthRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysGroupAuthRel record);

    int insertSelective(SysGroupAuthRel record);

    List<SysGroupAuthRel> selectByExample(SysGroupAuthRelExample example);

    SysGroupAuthRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysGroupAuthRel record, @Param("example") SysGroupAuthRelExample example);

    int updateByExample(@Param("record") SysGroupAuthRel record, @Param("example") SysGroupAuthRelExample example);

    int updateByPrimaryKeySelective(SysGroupAuthRel record);

    int updateByPrimaryKey(SysGroupAuthRel record);
}