package app.system.auto.mappers;

import app.system.auto.model.BaseFunctionModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
public interface OperationMapper {

    int existTable(@Param("tablename") String tablename);

    void createTable(@Param("tablename") String tablename, @Param("tablebody") List body);

    void dropTable(@Param("tablename") String tablename);

    int existColumn(@Param("tablename") String tablename, @Param("columnname") String columnname);

    void addColumn(@Param("tablename") String tablename, @Param("columnbody") List columnbody);

    void dropColumn(@Param("tablename") String tablename, @Param("columnbody") List columnbody);

    void createFunction(@Param("func") BaseFunctionModel baseFunctionModel);

    void dropFunction(@Param("funcname") String funcname);

    Object execFunction(@Param("funcname") String funcname, @Param("paralist") String paralist);
}
