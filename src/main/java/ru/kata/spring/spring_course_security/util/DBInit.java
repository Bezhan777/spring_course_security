package ru.kata.spring.spring_course_security.util;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import ru.kata.spring.spring_course_security.entity.Role;
import ru.kata.spring.spring_course_security.entity.User;
import ru.kata.spring.spring_course_security.service.RoleService;
import ru.kata.spring.spring_course_security.service.UserService;


import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DBInit {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public DBInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsersWithRoles() {

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        Role role3 = new Role("STUDENT");

        roleService.save(role1);
        roleService.save(role2);
        roleService.save(role3);

        User user1 = new User("ivan", "ivanov", 35, "ivan@email.com");
        User user2 = new User("maxim", "maximov", 28, "maksim@email.com");
        User user3 = new User("anton", "antonov", 37, "anton@email.com");
        User user4 = new User("kirill", "kirilov", 32, "kiril@email.com");
        User user5 = new User("petr", "petrov", 29, "petr@email.com");

        user1.setRoles(new HashSet<>(Set.of(role1,role2)));
        user2.setRoles(new HashSet<>(Set.of(role1)));
        user3.setRoles(new HashSet<>(Set.of(role2)));
        user4.setRoles(new HashSet<>(Set.of(role3)));

        userService.save(user1);
        userService.save(user2);
        userService.save(user3);
        userService.save(user4);
        userService.save(user5);
        System.out.println("privet"+ user1);
    }

}