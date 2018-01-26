package app.dao.mappers;

import app.dao.entities.TestDept;
import app.dao.entities.TestDeptExample;
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

public interface TestDeptMapper {
    @SelectProvider(type=TestDeptSqlProvider.class, method="countByExample")
    long countByExample(TestDeptExample example);

    @DeleteProvider(type=TestDeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(TestDeptExample example);

    @Delete({
        "delete from test_dept",
        "where deptid = #{deptid,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String deptid);

    @Insert({
        "insert into test_dept (deptid, deptname)",
        "values (#{deptid,jdbcType=VARCHAR}, #{deptname,jdbcType=VARCHAR})"
    })
    int insert(TestDept record);

    @InsertProvider(type=TestDeptSqlProvider.class, method="insertSelective")
    int insertSelective(TestDept record);

    @SelectProvider(type=TestDeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="deptname", property="deptname", jdbcType=JdbcType.VARCHAR)
    })
    List<TestDept> selectByExample(TestDeptExample example);

    @Select({
        "select",
        "deptid, deptname",
        "from test_dept",
        "where deptid = #{deptid,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="deptid", property="deptid", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="deptname", property="deptname", jdbcType=JdbcType.VARCHAR)
    })
    TestDept selectByPrimaryKey(String deptid);

    @UpdateProvider(type=TestDeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TestDept record, @Param("example") TestDeptExample example);

    @UpdateProvider(type=TestDeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TestDept record, @Param("example") TestDeptExample example);

    @UpdateProvider(type=TestDeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TestDept record);

    @Update({
        "update test_dept",
        "set deptname = #{deptname,jdbcType=VARCHAR}",
        "where deptid = #{deptid,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(TestDept record);
}