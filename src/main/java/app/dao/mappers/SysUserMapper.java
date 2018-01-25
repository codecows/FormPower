package app.dao.mappers;

import app.dao.entities.SysUser;
import app.dao.entities.SysUserExample;
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

public interface SysUserMapper {
    @SelectProvider(type=SysUserSqlProvider.class, method="countByExample")
    long countByExample(SysUserExample example);

    @DeleteProvider(type=SysUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserExample example);

    @Delete({
        "delete from sys_user",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String userId);

    @Insert({
        "insert into sys_user (user_id, user_name, ",
        "password, question, ",
        "answer, persion_name, ",
        "persion_sex, mobile, ",
        "telephone, email, ",
        "user_position, img_url, ",
        "remark, status, ",
        "create_time)",
        "values (#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{question,jdbcType=VARCHAR}, ",
        "#{answer,jdbcType=VARCHAR}, #{persionName,jdbcType=VARCHAR}, ",
        "#{persionSex,jdbcType=VARCHAR}, #{mobile,jdbcType=VARCHAR}, ",
        "#{telephone,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR}, ",
        "#{userPosition,jdbcType=VARCHAR}, #{imgUrl,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=DATE})"
    })
    int insert(SysUser record);

    @InsertProvider(type=SysUserSqlProvider.class, method="insertSelective")
    int insertSelective(SysUser record);

    @SelectProvider(type=SysUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="persion_name", property="persionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="persion_sex", property="persionSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_position", property="userPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_url", property="imgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE)
    })
    List<SysUser> selectByExample(SysUserExample example);

    @Select({
        "select",
        "user_id, user_name, password, question, answer, persion_name, persion_sex, mobile, ",
        "telephone, email, user_position, img_url, remark, status, create_time",
        "from sys_user",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="question", property="question", jdbcType=JdbcType.VARCHAR),
        @Result(column="answer", property="answer", jdbcType=JdbcType.VARCHAR),
        @Result(column="persion_name", property="persionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="persion_sex", property="persionSex", jdbcType=JdbcType.VARCHAR),
        @Result(column="mobile", property="mobile", jdbcType=JdbcType.VARCHAR),
        @Result(column="telephone", property="telephone", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_position", property="userPosition", jdbcType=JdbcType.VARCHAR),
        @Result(column="img_url", property="imgUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.DATE)
    })
    SysUser selectByPrimaryKey(String userId);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUser record, @Param("example") SysUserExample example);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUser record, @Param("example") SysUserExample example);

    @UpdateProvider(type=SysUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysUser record);

    @Update({
        "update sys_user",
        "set user_name = #{userName,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "question = #{question,jdbcType=VARCHAR},",
          "answer = #{answer,jdbcType=VARCHAR},",
          "persion_name = #{persionName,jdbcType=VARCHAR},",
          "persion_sex = #{persionSex,jdbcType=VARCHAR},",
          "mobile = #{mobile,jdbcType=VARCHAR},",
          "telephone = #{telephone,jdbcType=VARCHAR},",
          "email = #{email,jdbcType=VARCHAR},",
          "user_position = #{userPosition,jdbcType=VARCHAR},",
          "img_url = #{imgUrl,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=DATE}",
        "where user_id = #{userId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysUser record);
}