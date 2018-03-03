package app.dao.mappers;

import app.dao.entities.SysFormFieldGroup;
import app.dao.entities.SysFormFieldGroupExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFormFieldGroupMapper {
    long countByExample(SysFormFieldGroupExample example);

    int deleteByExample(SysFormFieldGroupExample example);

    int deleteByPrimaryKey(String groupId);

    int insert(SysFormFieldGroup record);

    int insertSelective(SysFormFieldGroup record);

    List<SysFormFieldGroup> selectByExample(SysFormFieldGroupExample example);

    SysFormFieldGroup selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") SysFormFieldGroup record, @Param("example") SysFormFieldGroupExample example);

    int updateByExample(@Param("record") SysFormFieldGroup record, @Param("example") SysFormFieldGroupExample example);

    int updateByPrimaryKeySelective(SysFormFieldGroup record);

    int updateByPrimaryKey(SysFormFieldGroup record);
}