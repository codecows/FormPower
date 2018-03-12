package app.system.form.mappers;

import app.system.form.entities.FieldInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by real on 2018/3/12.
 */
public interface FieldInfoMapper {
    List<FieldInfoEntity> getItemsByFormId(@Param("formid") String formId);
}
