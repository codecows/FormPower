package app.dao.complex;

import app.dao.entities.SysMenu;
import app.dao.entities.TestMenus;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;
import springfox.documentation.service.ApiListing;

import java.util.List;

public interface DemoMapper {
    @Select({
            "select",
            "uid, uname, deptid",
            "from test_users",
            "where uid = #{userid}"
    })
    @Results({
            @Result(column = "uid", property = "uid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "uname", property = "uname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "deptid", property = "testDept", jdbcType = JdbcType.VARCHAR,
                    one = @One(select = "app.dao.mapper.TestDeptMapper.selectByPrimaryKey", fetchType = FetchType.EAGER)
            )
            ,
            @Result(column = "uid", property = "testMenus", jdbcType = JdbcType.VARCHAR,
                    many = @Many(select = "getMenusByUser", fetchType = FetchType.EAGER)
            )
    })
    DemoEntity getUserInfo(String userId);

    @Select({
            "select",
            "menuid, menuname, userid",
            "from test_menus",
            "where userid = #{userid}"
    })
    @Results({
            @Result(column = "menuid", property = "menuid", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "menuname", property = "menuname", jdbcType = JdbcType.VARCHAR),
            @Result(column = "userid", property = "userid", jdbcType = JdbcType.VARCHAR)})
    List<TestMenus> getMenusByUser(@Param("userid") String useid);


}
