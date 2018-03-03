package app.system.auto.mappers;

import app.system.auto.entities.SysBaseTabEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Fan on 2018/2/27.
 */
public interface SysBaseTabTmplMapper {

    /*根据模版表名称查看模版表数据，传入参数：模版名称*/
    List<SysBaseTabEntity> selectByTmplName(@Param("tab_name") String tname);

}
