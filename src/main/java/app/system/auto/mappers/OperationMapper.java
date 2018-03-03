package app.system.auto.mappers;

import app.system.auto.model.BaseFunctionModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
public interface OperationMapper {

    /*查看表是否存在，传入参数：表名*/
    int existTable(@Param("tablename") String tablename);

    /*创建表，传入参数：表名，表描述，列属性的列表*/
    void createTable(@Param("tablename") String tablename, @Param("tablecomment") String tablecomment, @Param("tablebody") List body);

    /*删除表，传入参数：表名*/
    void dropTable(@Param("tablename") String tablename);

    /*查看列是否存在，传入参数：表名，列明*/
    int existColumn(@Param("tablename") String tablename, @Param("columnname") String columnname);

    /*增加列，传入参数：表名，列属性列表*/
    void addColumn(@Param("tablename") String tablename, @Param("columnbody") List columnbody);

    /*删除列，传入参数：表名，列名列表*/
    void dropColumn(@Param("tablename") String tablename, @Param("columnbody") List columnbody);

    /*创建函数，传入参数：基本函数对象*/
    void createFunction(@Param("func") BaseFunctionModel baseFunctionModel);

    /*删除函数，传入参数：函数名*/
    void dropFunction(@Param("funcname") String funcname);

    /*执行函数，传入参数：函数名，参数列表*/
    Object execFunction(@Param("funcname") String funcname, @Param("paralist") String paralist);
}
