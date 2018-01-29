package app.dao.mappers;

import app.dao.entities.TestUsers;
import app.dao.entities.TestUsersExample;
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

public interface TestUsersMapper {
    @SelectProvider(type=TestUsersSqlProvider.class, method="countByExample")
    long countByExample(TestUsersExample example);

    @DeleteProvider(type=TestUsersSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestUsersExample example);

    @Delete({
        "delete from test_users",
        "where uid = #{uid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String uid);

    @Insert({
        "insert into test_users (uid, uname, ",
        "deptid)",
        "values (#{uid,jdbcType=VARCHAR}, #{uname,jdbcType=VARCHAR}, ",
        "#{deptid,jdbcType=VARCHAR})"
    })
    int insert(TestUsers record);

    @InsertProvider(type=TestUsersSqlProvider.class, method="insertSelective")
    int insertSelective(TestUsers record);

    @SelectProvider(type=TestUsersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="uname", property="uname", jdbcType=JdbcType.VARCHAR),
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.VARCHAR)
    })
    List<TestUsers> selectByExample(TestUsersExample example);

    @Select({
        "select",
        "uid, uname, deptid",
        "from test_users",
        "where uid = #{uid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="uname", property="uname", jdbcType=JdbcType.VARCHAR),
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.VARCHAR)
    })
    TestUsers selectByPrimaryKey(String uid);

    @UpdateProvider(type=TestUsersSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TestUsers record, @Param("example") TestUsersExample example);

    @UpdateProvider(type=TestUsersSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TestUsers record, @Param("example") TestUsersExample example);

    @UpdateProvider(type=TestUsersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TestUsers record);

    @Update({
        "update test_users",
        "set uname = #{uname,jdbcType=VARCHAR},",
          "deptid = #{deptid,jdbcType=VARCHAR}",
        "where uid = #{uid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TestUsers record);
}