package gevak.service;

import gevak.entity.User;

import java.util.List;


public interface UserService {

    void save(User user);

    void save(String name, String surName);

    void save(String name, String surName, int p1, int p2, int p3, int atestat);

    void save(String name, String surName, int p1, int p2, int p3, int atestat, String avatar);

    User findOne(int id);

    List<User> findAll();

}
