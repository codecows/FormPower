package app.system.auto.mappers;

import app.system.auto.entities.SysExecFunc;
import app.system.auto.entities.SysExecFuncExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysExecFuncMapper {
    long countByExample(SysExecFuncExample example);

    int deleteByExample(SysExecFuncExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysExecFunc record);

    int insertSelective(SysExecFunc record);

    List<SysExecFunc> selectByExample(SysExecFuncExample example);

    SysExecFunc selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysExecFunc record, @Param("example") SysExecFuncExample example);

    int updateByExample(@Param("record") SysExecFunc record, @Param("example") SysExecFuncExample example);

    int updateByPrimaryKeySelective(SysExecFunc record);

    int updateByPrimaryKey(SysExecFunc record);
}