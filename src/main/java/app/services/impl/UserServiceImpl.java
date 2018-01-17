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

    public User getUser() {
        return null;
    }

    public List<User> getUsers() {
        List<UserEntity> userEntities = userMappper.getList();
        List<User> users = userConverter.convert2ModelList(userEntities);
        return users;
    }

    public List<User> getUsersByPage(int pageSize, int pageNum) {
        return null;
    }

    public void AddUser(User user) {

    }

    public void DelUser(String userId) {

    }

    public void UpdateUser(User user) {

    }
}
