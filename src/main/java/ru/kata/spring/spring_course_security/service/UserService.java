package ru.kata.spring.spring_course_security.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.spring_course_security.entity.Role;
import ru.kata.spring.spring_course_security.entity.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(long id);
    void save(User user);
    void update(long id, User updatedUser);
    void delete(long id);

    void addRoleToUser(User user, Role role);

    User getUserByUsername(String username);
}