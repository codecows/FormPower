package app.dao.mappers;

import app.dao.entities.SysMenu;
import app.dao.entities.SysMenuExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface SysMenuMapper {
    @SelectProvider(type = SysMenuSqlProvider.class, method = "countByExample")
    long countByExample(SysMenuExample example);

    @DeleteProvider(type = SysMenuSqlProvider.class, method = "deleteByExample")
    int deleteByExample(SysMenuExample example);

    @Delete({
            "delete from sys_menu",
            "where menu_id = #{menuId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String menuId);

    @Insert({
            "insert into sys_menu (menu_id, parent_id, ",
            "menu_type, menu_level, ",
            "menu_name, menu_code, ",
            "menu_path, menu_url, ",
            "remark, order_num, ",
            "status, create_date)",
            "values (#{menuId,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
            "#{menuType,jdbcType=VARCHAR}, #{menuLevel,jdbcType=VARCHAR}, ",
            "#{menuName,jdbcType=VARCHAR}, #{menuCode,jdbcType=VARCHAR}, ",
            "#{menuPath,jdbcType=VARCHAR}, #{menuUrl,jdbcType=VARCHAR}, ",
            "#{remark,jdbcType=VARCHAR}, #{orderNum,jdbcType=NUMERIC}, ",
            "#{status,jdbcType=VARCHAR}, #{createDate,jdbcType=DATE})"
    })
    int insert(SysMenu record);

    @InsertProvider(type = SysMenuSqlProvider.class, method = "insertSelective")
    int insertSelective(SysMenu record);

    @SelectProvider(type = SysMenuSqlProvider.class, method = "selectByExample")
    @Results({
            @Result(column = "menu_id", property = "menuId", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "parent_id", property = "parentId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_type", property = "menuType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_level", property = "menuLevel", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_name", property = "menuName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_code", property = "menuCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_path", property = "menuPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_url", property = "menuUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_num", property = "orderNum", jdbcType = JdbcType.NUMERIC),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.DATE)
    })
    List<SysMenu> selectByExample(SysMenuExample example);

    @Select({
            "select",
            "menu_id, parent_id, menu_type, menu_level, menu_name, menu_code, menu_path, ",
            "menu_url, remark, order_num, status, create_date",
            "from sys_menu",
            "where menu_id = #{menuId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column = "menu_id", property = "menuId", jdbcType = JdbcType.VARCHAR, id = true),
            @Result(column = "parent_id", property = "parentId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_type", property = "menuType", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_level", property = "menuLevel", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_name", property = "menuName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_code", property = "menuCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_path", property = "menuPath", jdbcType = JdbcType.VARCHAR),
            @Result(column = "menu_url", property = "menuUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
            @Result(column = "order_num", property = "orderNum", jdbcType = JdbcType.NUMERIC),
            @Result(column = "status", property = "status", jdbcType = JdbcType.VARCHAR),
            @Result(column = "create_date", property = "createDate", jdbcType = JdbcType.DATE)
    })
    SysMenu selectByPrimaryKey(String menuId);

    @UpdateProvider(type = SysMenuSqlProvider.class, method = "updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    @UpdateProvider(type = SysMenuSqlProvider.class, method = "updateByExample")
    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    @UpdateProvider(type = SysMenuSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMenu record);

    @Update({
            "update sys_menu",
            "set parent_id = #{parentId,jdbcType=VARCHAR},",
            "menu_type = #{menuType,jdbcType=VARCHAR},",
            "menu_level = #{menuLevel,jdbcType=VARCHAR},",
            "menu_name = #{menuName,jdbcType=VARCHAR},",
            "menu_code = #{menuCode,jdbcType=VARCHAR},",
            "menu_path = #{menuPath,jdbcType=VARCHAR},",
            "menu_url = #{menuUrl,jdbcType=VARCHAR},",
            "remark = #{remark,jdbcType=VARCHAR},",
            "order_num = #{orderNum,jdbcType=NUMERIC},",
            "status = #{status,jdbcType=VARCHAR},",
            "create_date = #{createDate,jdbcType=DATE}",
            "where menu_id = #{menuId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysMenu record);
}