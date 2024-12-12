package web.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.spring.dao.UserDao;
import web.spring.models.User;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(int id) {
        return userDao.findById(id);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        userDao.update(id, user);
    }
    @Override
    @Transactional
    public void delete(int id) {
        userDao.delete(id);
    }
    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return userDao.findAll();
    }
}
