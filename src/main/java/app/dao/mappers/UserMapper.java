package app.dao.mappers;

import app.dao.entities.UserEntity;
import org.apache.ibatis.annotations.*;

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
    UserEntity get(String userId);

    @Insert("INSERT INTO users (uid,uname) VALUES (${uid},${uname})")
    void add(UserEntity userEntity);

    @Update("UPDATE users SET uid=#{uid},uname=#{uname} WHERE uid=#{uid};")
    void udpate(UserEntity userEntity);

    @Delete("DELETE FROM users WHERE uid=#{userId};")
    void delete(String userId);
}
