package app.auto.mappers;

import app.auto.entities.SysBaseTabEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
public interface SysBaseTabTmplMapper {

    List<SysBaseTabEntity> selectByTmplName(@Param("tab_name") String tname);

}
