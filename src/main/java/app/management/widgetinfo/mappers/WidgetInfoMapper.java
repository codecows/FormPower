package app.management.widgetinfo.mappers;


import app.management.widgetinfo.entities.WidgetInfoEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by real on 2018/2/3.
 */
public interface WidgetInfoMapper {

    List<WidgetInfoEntity> selectByStatus(@Param("gStatus") String gStatus, @Param("cStatus") String cStatus);

}
