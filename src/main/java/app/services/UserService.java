package app.services;

import app.comn.ServiceException;
import app.model.User;

import java.util.List;

public interface UserService {
    User getUser(String userId);

    List<User> getUsers();

    List<User> getUsersByPage(int pageSize, int pageNum);

    void addUser(User user) throws ServiceException;

    void delUser(String userId);

    void updateUser(User user);

    boolean exist(String userId);
}
