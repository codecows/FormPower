package app.dao.mappers;

import app.dao.entities.SysAuthority;
import app.dao.entities.SysAuthorityExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface SysAuthorityMapper {
    @SelectProvider(type=SysAuthoritySqlProvider.class, method="countByExample")
    long countByExample(SysAuthorityExample example);

    @DeleteProvider(type=SysAuthoritySqlProvider.class, method="deleteByExample")
    int deleteByExample(SysAuthorityExample example);

    @Delete({
        "delete from sys_authority",
        "where auth_id = #{authId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String authId);

    @Insert({
        "insert into sys_authority (auth_id, parent_id, ",
        "authority_name, descripthon, ",
        "remark, status, ",
        "create_date)",
        "values (#{authId,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
        "#{authorityName,jdbcType=VARCHAR}, #{descripthon,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{createDate,jdbcType=DATE})"
    })
    int insert(SysAuthority record);

    @InsertProvider(type=SysAuthoritySqlProvider.class, method="insertSelective")
    int insertSelective(SysAuthority record);

    @SelectProvider(type=SysAuthoritySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="auth_id", property="authId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority_name", property="authorityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripthon", property="descripthon", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE)
    })
    List<SysAuthority> selectByExample(SysAuthorityExample example);

    @Select({
        "select",
        "auth_id, parent_id, authority_name, descripthon, remark, status, create_date",
        "from sys_authority",
        "where auth_id = #{authId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="auth_id", property="authId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority_name", property="authorityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripthon", property="descripthon", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE)
    })
    SysAuthority selectByPrimaryKey(String authId);

    @UpdateProvider(type=SysAuthoritySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysAuthority record, @Param("example") SysAuthorityExample example);

    @UpdateProvider(type=SysAuthoritySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysAuthority record, @Param("example") SysAuthorityExample example);

    @UpdateProvider(type=SysAuthoritySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysAuthority record);

    @Update({
        "update sys_authority",
        "set parent_id = #{parentId,jdbcType=VARCHAR},",
          "authority_name = #{authorityName,jdbcType=VARCHAR},",
          "descripthon = #{descripthon,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=DATE}",
        "where auth_id = #{authId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysAuthority record);
}