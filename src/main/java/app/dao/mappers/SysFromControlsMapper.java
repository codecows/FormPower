package app.dao.mappers;

import app.dao.entities.SysFromControls;
import app.dao.entities.SysFromControlsExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFromControlsMapper {
    long countByExample(SysFromControlsExample example);

    int deleteByExample(SysFromControlsExample example);

    int deleteByPrimaryKey(String controlId);

    int insert(SysFromControls record);

    int insertSelective(SysFromControls record);

    List<SysFromControls> selectByExample(SysFromControlsExample example);

    SysFromControls selectByPrimaryKey(String controlId);

    int updateByExampleSelective(@Param("record") SysFromControls record, @Param("example") SysFromControlsExample example);

    int updateByExample(@Param("record") SysFromControls record, @Param("example") SysFromControlsExample example);

    int updateByPrimaryKeySelective(SysFromControls record);

    int updateByPrimaryKey(SysFromControls record);
}