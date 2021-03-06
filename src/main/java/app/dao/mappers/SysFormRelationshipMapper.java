package app.dao.mappers;

import app.dao.entities.SysFormRelationship;
import app.dao.entities.SysFormRelationshipExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SysFormRelationshipMapper {
    long countByExample(SysFormRelationshipExample example);

    int deleteByExample(SysFormRelationshipExample example);

    int insert(SysFormRelationship record);

    int insertSelective(SysFormRelationship record);

    List<SysFormRelationship> selectByExample(SysFormRelationshipExample example);

    int updateByExampleSelective(@Param("record") SysFormRelationship record, @Param("example") SysFormRelationshipExample example);

    int updateByExample(@Param("record") SysFormRelationship record, @Param("example") SysFormRelationshipExample example);
}