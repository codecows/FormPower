package app.dao.mappers;

import app.dao.entities.SysAuthority;
import app.dao.entities.SysAuthorityExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

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
            "remark, order_num, ",
            "status, create_date)",
        "values (#{authId,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
        "#{authorityName,jdbcType=VARCHAR}, #{descripthon,jdbcType=VARCHAR}, ",
            "#{remark,jdbcType=VARCHAR}, #{orderNum,jdbcType=NUMERIC}, ",
            "#{status,jdbcType=VARCHAR}, #{createDate,jdbcType=DATE})"
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
            @Result(column = "order_num", property = "orderNum", jdbcType = JdbcType.NUMERIC),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE)
    })
    List<SysAuthority> selectByExample(SysAuthorityExample example);

    @Select({
        "select",
            "auth_id, parent_id, authority_name, descripthon, remark, order_num, status, ",
            "create_date",
        "from sys_authority",
        "where auth_id = #{authId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="auth_id", property="authId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="authority_name", property="authorityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="descripthon", property="descripthon", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
            @Result(column = "order_num", property = "orderNum", jdbcType = JdbcType.NUMERIC),
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
            "order_num = #{orderNum,jdbcType=NUMERIC},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=DATE}",
        "where auth_id = #{authId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysAuthority record);
}