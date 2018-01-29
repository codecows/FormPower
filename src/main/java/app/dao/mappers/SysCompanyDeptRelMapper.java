package app.dao.mappers;

import app.dao.entities.SysCompanyDeptRel;
import app.dao.entities.SysCompanyDeptRelExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysCompanyDeptRelMapper {
    long countByExample(SysCompanyDeptRelExample example);

    int deleteByExample(SysCompanyDeptRelExample example);

    int deleteByPrimaryKey(String guid);

    int insert(SysCompanyDeptRel record);

    int insertSelective(SysCompanyDeptRel record);

    List<SysCompanyDeptRel> selectByExample(SysCompanyDeptRelExample example);

    SysCompanyDeptRel selectByPrimaryKey(String guid);

    int updateByExampleSelective(@Param("record") SysCompanyDeptRel record, @Param("example") SysCompanyDeptRelExample example);

    int updateByExample(@Param("record") SysCompanyDeptRel record, @Param("example") SysCompanyDeptRelExample example);

    int updateByPrimaryKeySelective(SysCompanyDeptRel record);

    int updateByPrimaryKey(SysCompanyDeptRel record);
}