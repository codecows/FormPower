package app.dao.mappers;

import app.dao.entities.SysFormDef;
import app.dao.entities.SysFormDefExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFormDefMapper {
    long countByExample(SysFormDefExample example);

    int deleteByExample(SysFormDefExample example);

    int deleteByPrimaryKey(String formId);

    int insert(SysFormDef record);

    int insertSelective(SysFormDef record);

    List<SysFormDef> selectByExample(SysFormDefExample example);

    SysFormDef selectByPrimaryKey(String formId);

    int updateByExampleSelective(@Param("record") SysFormDef record, @Param("example") SysFormDefExample example);

    int updateByExample(@Param("record") SysFormDef record, @Param("example") SysFormDefExample example);

    int updateByPrimaryKeySelective(SysFormDef record);

    int updateByPrimaryKey(SysFormDef record);
}