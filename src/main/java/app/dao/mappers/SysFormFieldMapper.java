package app.dao.mappers;

import app.dao.entities.SysFormField;
import app.dao.entities.SysFormFieldExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFormFieldMapper {
    long countByExample(SysFormFieldExample example);

    int deleteByExample(SysFormFieldExample example);

    int deleteByPrimaryKey(String fieldId);

    int insert(SysFormField record);

    int insertSelective(SysFormField record);

    List<SysFormField> selectByExample(SysFormFieldExample example);

    SysFormField selectByPrimaryKey(String fieldId);

    int updateByExampleSelective(@Param("record") SysFormField record, @Param("example") SysFormFieldExample example);

    int updateByExample(@Param("record") SysFormField record, @Param("example") SysFormFieldExample example);

    int updateByPrimaryKeySelective(SysFormField record);

    int updateByPrimaryKey(SysFormField record);
}