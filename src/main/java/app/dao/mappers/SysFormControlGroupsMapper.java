package app.dao.mappers;

import app.dao.entities.SysFormControlGroups;
import app.dao.entities.SysFormControlGroupsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFormControlGroupsMapper {
    long countByExample(SysFormControlGroupsExample example);

    int deleteByExample(SysFormControlGroupsExample example);

    int deleteByPrimaryKey(String groupId);

    int insert(SysFormControlGroups record);

    int insertSelective(SysFormControlGroups record);

    List<SysFormControlGroups> selectByExample(SysFormControlGroupsExample example);

    SysFormControlGroups selectByPrimaryKey(String groupId);

    int updateByExampleSelective(@Param("record") SysFormControlGroups record, @Param("example") SysFormControlGroupsExample example);

    int updateByExample(@Param("record") SysFormControlGroups record, @Param("example") SysFormControlGroupsExample example);

    int updateByPrimaryKeySelective(SysFormControlGroups record);

    int updateByPrimaryKey(SysFormControlGroups record);
}