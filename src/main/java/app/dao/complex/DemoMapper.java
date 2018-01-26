package app.dao.complex;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface DemoMapper {
    DemoEntity getUserInfo();

    @Select({
            "select",
            "uid, uname, deptid",
            "from test_users"
    })
    @Results({
            @Result(column="uid", property="uid", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="uname", property="uname", jdbcType=JdbcType.VARCHAR),
            @Result(column="deptid", property="testDept", jdbcType=JdbcType.VARCHAR,
                    one = @One(select = "app.dao.mappers.TestDeptMapper.selectByPrimaryKey",fetchType= FetchType.EAGER)
            )
            ,
            @Result(column="userid", property="testMenus", jdbcType=JdbcType.VARCHAR,
                    many = @Many(select = "select * from test_menus where menuid = #{userid}",fetchType= FetchType.EAGER)
            )
    })
    List<DemoEntity> getUserInfos();

}
