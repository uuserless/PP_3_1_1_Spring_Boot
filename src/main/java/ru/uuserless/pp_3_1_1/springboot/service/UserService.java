package ru.uuserless.pp_3_1_1.springboot.service;

import ru.uuserless.pp_3_1_1.springboot.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<User> findAllUsers();

    User findOneUser(int id);

    void updateUser(int id, User user);

    void deleteUser(int id);
}
