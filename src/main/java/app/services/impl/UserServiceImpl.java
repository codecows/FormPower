package app.services.impl;

import app.converter.UserConverter;
import app.dao.entities.UserEntity;
import app.dao.mappers.UserMapper;
import app.model.User;
import app.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMappper;
    @Resource
    private UserConverter userConverter;

    public User getUser(String userId) {
        UserEntity userEntities = userMappper.get(userId);
        User user = userConverter.convert2Model(userEntities);
        return user;
    }

    public List<User> getUsers() {
        List<UserEntity> userEntities = userMappper.getList();
        List<User> users = userConverter.convert2ModelList(userEntities);
        return users;
    }

    //分页集合
    public List<User> getUsersByPage(int pageSize, int pageNum) {
        return null;
    }

    public void AddUser(User user) {
        UserEntity userEntity = userConverter.convert2Entity(user);
        userMappper.add(userEntity);
    }

    public void DelUser(String userId) {
        userMappper.delete(userId);
    }

    public void UpdateUser(User user) {
        UserEntity userEntity = userConverter.convert2Entity(user);
        userMappper.udpate(userEntity);
    }
}
