package app.services;

import app.model.User;

import java.util.List;

public interface UserService {
    User getUser();

    List<User> getUsers();

    List<User> getUsersByPage(int pageSize, int pageNum);

    void AddUser(User user);

    void DelUser(String userId);

    void UpdateUser(User user);
}
