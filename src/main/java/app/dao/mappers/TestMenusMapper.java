package app.dao.mappers;

import app.dao.entities.TestMenus;
import app.dao.entities.TestMenusExample;
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

public interface TestMenusMapper {
    @SelectProvider(type=TestMenusSqlProvider.class, method="countByExample")
    long countByExample(TestMenusExample example);

    @DeleteProvider(type=TestMenusSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestMenusExample example);

    @Delete({
        "delete from test_menus",
        "where menuid = #{menuid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String menuid);

    @Insert({
        "insert into test_menus (menuid, menuname, ",
        "userid)",
        "values (#{menuid,jdbcType=VARCHAR}, #{menuname,jdbcType=VARCHAR}, ",
        "#{userid,jdbcType=VARCHAR})"
    })
    int insert(TestMenus record);

    @InsertProvider(type=TestMenusSqlProvider.class, method="insertSelective")
    int insertSelective(TestMenus record);

    @SelectProvider(type=TestMenusSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menuid", property="menuid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menuname", property="menuname", jdbcType=JdbcType.VARCHAR),
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR)
    })
    List<TestMenus> selectByExample(TestMenusExample example);

    @Select({
        "select",
        "menuid, menuname, userid",
        "from test_menus",
        "where menuid = #{menuid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="menuid", property="menuid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menuname", property="menuname", jdbcType=JdbcType.VARCHAR),
        @Result(column="userid", property="userid", jdbcType=JdbcType.VARCHAR)
    })
    TestMenus selectByPrimaryKey(String menuid);

    @UpdateProvider(type=TestMenusSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TestMenus record, @Param("example") TestMenusExample example);

    @UpdateProvider(type=TestMenusSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TestMenus record, @Param("example") TestMenusExample example);

    @UpdateProvider(type=TestMenusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TestMenus record);

    @Update({
        "update test_menus",
        "set menuname = #{menuname,jdbcType=VARCHAR},",
          "userid = #{userid,jdbcType=VARCHAR}",
        "where menuid = #{menuid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TestMenus record);
}