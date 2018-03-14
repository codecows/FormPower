package app.dao.mappers;

import app.dao.entities.SysAttributeInformation;
import app.dao.entities.SysAttributeInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysAttributeInformationMapper {
    long countByExample(SysAttributeInformationExample example);

    int deleteByExample(SysAttributeInformationExample example);

    int deleteByPrimaryKey(String id);

    int insert(SysAttributeInformation record);

    int insertSelective(SysAttributeInformation record);

    List<SysAttributeInformation> selectByExample(SysAttributeInformationExample example);

    SysAttributeInformation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") SysAttributeInformation record, @Param("example") SysAttributeInformationExample example);

    int updateByExample(@Param("record") SysAttributeInformation record, @Param("example") SysAttributeInformationExample example);

    int updateByPrimaryKeySelective(SysAttributeInformation record);

    int updateByPrimaryKey(SysAttributeInformation record);
}