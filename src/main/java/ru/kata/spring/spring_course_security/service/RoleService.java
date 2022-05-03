package ru.kata.spring.spring_course_security.service;

import ru.kata.spring.spring_course_security.entity.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();
    Role getRoleById(int id);
    void save(Role role);
    void update(int id, Role updatedRole);
    void delete(int id);
}