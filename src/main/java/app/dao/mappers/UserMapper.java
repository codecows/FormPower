package app.dao.mappers;

import app.dao.entities.UserEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("SELECT uid,uname FROM users")
    @Results({
            @Result(property = "uid", column = "uid"),
            @Result(property = "uname", column = "uname"),

    })
    List<UserEntity> getList();

    @Select("SELECT uid,uname FROM users WHERE uid=#{userId};")
    @Results({
            @Result(property = "uid", column = "uid"),
            @Result(property = "uname", column = "uname"),

    })
    List<UserEntity> get(String userId);
}
