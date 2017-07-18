package gevak.service.impl;

import gevak.dao.UserDAO;
import gevak.entity.User;
import gevak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void save(String name, String surName) {
        User user = new User(name, surName);
        userDAO.save(user);
    }

    @Override
    public void save(String name, String surName, int p1, int p2, int p3, int atestat) {
        User user = new User(name, surName, p1, p2, p3, atestat);
        userDAO.save(user);
    }

    @Override
    public void save(String name, String surName, int p1, int p2, int p3, int atestat, String avatar) {
        User user = new User(name, surName, p1, p2, p3, atestat, avatar);
        userDAO.save(user);
    }

    @Override
    public User findOne(int id) {
        return userDAO.findOne(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }
}
