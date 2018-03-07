package app.dao.mappers;

import app.dao.entities.SysFormAttributeInformation;
import app.dao.entities.SysFormAttributeInformationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFormAttributeInformationMapper {
    long countByExample(SysFormAttributeInformationExample example);

    int deleteByExample(SysFormAttributeInformationExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysFormAttributeInformation record);

    int insertSelective(SysFormAttributeInformation record);

    List<SysFormAttributeInformation> selectByExample(SysFormAttributeInformationExample example);

    SysFormAttributeInformation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysFormAttributeInformation record, @Param("example") SysFormAttributeInformationExample example);

    int updateByExample(@Param("record") SysFormAttributeInformation record, @Param("example") SysFormAttributeInformationExample example);

    int updateByPrimaryKeySelective(SysFormAttributeInformation record);

    int updateByPrimaryKey(SysFormAttributeInformation record);
}