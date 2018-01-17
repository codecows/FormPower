package app.services.impl;

import app.comn.ResponseCode;
import app.comn.ServiceException;
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
        //TODO 未实现
        return null;
    }

    public void addUser(User user) throws ServiceException {
        if (exist(user.getUid())) {
            throw new ServiceException(ResponseCode.UserExist);
        }
        UserEntity userEntity = userConverter.convert2Entity(user);
        userMappper.add(userEntity);
    }

    public void delUser(String userId) {
        userMappper.delete(userId);
    }

    public void updateUser(User user) {
        UserEntity userEntity = userConverter.convert2Entity(user);
        userMappper.udpate(userEntity);
    }

    @Override
    public boolean exist(String userId) {
        //TODO 未实现
        return false;
    }
}
