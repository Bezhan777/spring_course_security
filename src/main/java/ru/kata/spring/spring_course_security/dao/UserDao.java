package ru.kata.spring.spring_course_security.dao;

import ru.kata.spring.spring_course_security.entity.Role;
import ru.kata.spring.spring_course_security.entity.User;


import java.util.List;

public interface UserDao {
        List<User> getAllUsers();
        User getUserById(long id);
        void save(User user);
        void update(long id, User updatedUser);
        void delete(long id);

        User getUserByUsername(String username);

        void addRoleToUser(User user, Role role);

}
