package app.dao.mappers;

import app.dao.entities.SysDepartment;
import app.dao.entities.SysDepartmentExample;
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

public interface SysDepartmentMapper {
    @SelectProvider(type=SysDepartmentSqlProvider.class, method="countByExample")
    long countByExample(SysDepartmentExample example);

    @DeleteProvider(type=SysDepartmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDepartmentExample example);

    @Delete({
        "delete from sys_department",
        "where department_id = #{departmentId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String departmentId);

    @Insert({
        "insert into sys_department (department_id, parent_id, ",
        "department_name, short_name, ",
        "department_code, department_level, ",
        "department_type, create_date, ",
        "status)",
        "values (#{departmentId,jdbcType=VARCHAR}, #{parentId,jdbcType=VARCHAR}, ",
        "#{departmentName,jdbcType=VARCHAR}, #{shortName,jdbcType=VARCHAR}, ",
        "#{departmentCode,jdbcType=VARCHAR}, #{departmentLevel,jdbcType=VARCHAR}, ",
        "#{departmentType,jdbcType=VARCHAR}, #{createDate,jdbcType=DATE}, ",
        "#{status,jdbcType=VARCHAR})"
    })
    int insert(SysDepartment record);

    @InsertProvider(type=SysDepartmentSqlProvider.class, method="insertSelective")
    int insertSelective(SysDepartment record);

    @SelectProvider(type=SysDepartmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_name", property="departmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="short_name", property="shortName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_code", property="departmentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_level", property="departmentLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_type", property="departmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    List<SysDepartment> selectByExample(SysDepartmentExample example);

    @Select({
        "select",
        "department_id, parent_id, department_name, short_name, department_code, department_level, ",
        "department_type, create_date, status",
        "from sys_department",
        "where department_id = #{departmentId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="department_id", property="departmentId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_name", property="departmentName", jdbcType=JdbcType.VARCHAR),
        @Result(column="short_name", property="shortName", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_code", property="departmentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_level", property="departmentLevel", jdbcType=JdbcType.VARCHAR),
        @Result(column="department_type", property="departmentType", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_date", property="createDate", jdbcType=JdbcType.DATE),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR)
    })
    SysDepartment selectByPrimaryKey(String departmentId);

    @UpdateProvider(type=SysDepartmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    @UpdateProvider(type=SysDepartmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDepartment record, @Param("example") SysDepartmentExample example);

    @UpdateProvider(type=SysDepartmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDepartment record);

    @Update({
        "update sys_department",
        "set parent_id = #{parentId,jdbcType=VARCHAR},",
          "department_name = #{departmentName,jdbcType=VARCHAR},",
          "short_name = #{shortName,jdbcType=VARCHAR},",
          "department_code = #{departmentCode,jdbcType=VARCHAR},",
          "department_level = #{departmentLevel,jdbcType=VARCHAR},",
          "department_type = #{departmentType,jdbcType=VARCHAR},",
          "create_date = #{createDate,jdbcType=DATE},",
          "status = #{status,jdbcType=VARCHAR}",
        "where department_id = #{departmentId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SysDepartment record);
}