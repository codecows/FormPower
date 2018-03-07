package app.dao.mappers;

import app.dao.entities.SysFormInformation;
import app.dao.entities.SysFormInformationExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFormInformationMapper {
    long countByExample(SysFormInformationExample example);

    int deleteByExample(SysFormInformationExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysFormInformation record);

    int insertSelective(SysFormInformation record);

    List<SysFormInformation> selectByExample(SysFormInformationExample example);

    SysFormInformation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysFormInformation record, @Param("example") SysFormInformationExample example);

    int updateByExample(@Param("record") SysFormInformation record, @Param("example") SysFormInformationExample example);

    int updateByPrimaryKeySelective(SysFormInformation record);

    int updateByPrimaryKey(SysFormInformation record);
}