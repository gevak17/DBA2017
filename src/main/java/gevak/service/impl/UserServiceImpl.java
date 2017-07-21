package gevak.service.impl;

import gevak.dao.UserDAO;
import gevak.entity.User;
import gevak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    @Override
    public void deleteAll() {
        userDAO.deleteAll();
    }



    //!!!!!!!!!!!!!!!!
    @Override
    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUserName(username);
    }



//    @Override
//    public void save(String name, String surName, int p1, int p2, int p3, int atestat) {
//        User user = new User(name, surName, p1, p2, p3, atestat);
//        userDAO.save(user);
//    }
//    @Override
//    public void save(String name, String surName, int p1, int p2, int p3, int atestat, String avatar) {
//        User user = new User(name, surName, p1, p2, p3, atestat, avatar);
//        userDAO.save(user);
//    }

    @Override
    public User findOne(int id) {
        return userDAO.findOne(id);
    }
    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }


}
