package app.system.form.mappers;

import app.system.form.entities.FormDefEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by real on 2018/2/24.
 */
public interface FormDefMapper {

    List<FormDefEntity> selectAll();

    List<FormDefEntity> selectByPage(@Param("start") int start, @Param("length") int length);
}
