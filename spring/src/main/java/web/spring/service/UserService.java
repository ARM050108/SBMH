package web.spring.service;



import web.spring.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findById(int id);

    void update(int id, User user);

    void delete(int id);

    List<User> findAll();
}