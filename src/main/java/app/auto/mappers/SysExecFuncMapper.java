package app.auto.mappers;

import app.auto.entities.SysExecFunc;
import app.auto.entities.SysExecFuncExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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