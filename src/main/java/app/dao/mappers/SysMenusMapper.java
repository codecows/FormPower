package app.dao.mappers;

import app.dao.entities.SysMenus;
import app.dao.entities.SysMenusExample;
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

public interface SysMenusMapper {
    @SelectProvider(type=SysMenusSqlProvider.class, method="countByExample")
    long countByExample(SysMenusExample example);

    @DeleteProvider(type=SysMenusSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysMenusExample example);

    @Delete({
        "delete from sys_menus",
        "where menuid = #{menuid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String menuid);

    @Insert({
        "insert into sys_menus (menuid, menuname, ",
        "url, isenabled)",
        "values (#{menuid,jdbcType=VARCHAR}, #{menuname,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{isenabled,jdbcType=VARCHAR})"
    })
    int insert(SysMenus record);

    @InsertProvider(type=SysMenusSqlProvider.class, method="insertSelective")
    int insertSelective(SysMenus record);

    @SelectProvider(type=SysMenusSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="menuid", property="menuid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menuname", property="menuname", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="isenabled", property="isenabled", jdbcType=JdbcType.VARCHAR)
    })
    List<SysMenus> selectByExample(SysMenusExample example);

    @Select({
        "select",
        "menuid, menuname, url, isenabled",
        "from sys_menus",
        "where menuid = #{menuid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="menuid", property="menuid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menuname", property="menuname", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="isenabled", property="isenabled", jdbcType=JdbcType.VARCHAR)
    })
    SysMenus selectByPrimaryKey(String menuid);

    @UpdateProvider(type=SysMenusSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMenus record, @Param("example") SysMenusExample example);

    @UpdateProvider(type=SysMenusSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysMenus record, @Param("example") SysMenusExample example);

    @UpdateProvider(type=SysMenusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMenus record);

    @Update({
        "update sys_menus",
        "set menuname = #{menuname,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "isenabled = #{isenabled,jdbcType=VARCHAR}",
        "where menuid = #{menuid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysMenus record);
}