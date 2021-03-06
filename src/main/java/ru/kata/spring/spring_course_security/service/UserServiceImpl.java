package ru.kata.spring.spring_course_security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.spring_course_security.dao.UserDao;
import ru.kata.spring.spring_course_security.entity.Role;
import ru.kata.spring.spring_course_security.entity.User;


import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Qualifier("userDetailsService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void update(long id, User updatedUser) {
        userDao.update(id, updatedUser);
    }

    @Override
    public void delete(long id) {
        userDao.delete(id);
    }

    @Override
    public void addRoleToUser(User user, Role role) {
        userDao.addRoleToUser(user, role);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователя с именем '%s' не найдено", username));
        }
        return user;
    }
}