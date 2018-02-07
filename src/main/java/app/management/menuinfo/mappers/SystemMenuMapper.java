package app.management.menuinfo.mappers;

import app.management.menuinfo.entities.SystemMenuEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by real on 2018/2/7.
 */
public interface SystemMenuMapper {

    List<SystemMenuEntity> selectByUserId(@Param("userId") String userId, @Param("status") String status);
}
