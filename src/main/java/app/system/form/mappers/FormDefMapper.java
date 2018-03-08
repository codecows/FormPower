package app.system.form.mappers;

import app.dao.entities.SysFormDef;
import app.dao.mappers.SysFormDefMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by real on 2018/2/24.
 */
public interface FormDefMapper extends SysFormDefMapper {

    List<SysFormDef> selectAll();

    List<SysFormDef> selectByPage(@Param("start") int start, @Param("length") int length);

}
