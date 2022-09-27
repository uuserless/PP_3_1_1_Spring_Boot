package ru.uuserless.pp_3_1_1.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.uuserless.pp_3_1_1.springboot.model.User;
import ru.uuserless.pp_3_1_1.springboot.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findOneUser(int id) {
        Optional<User> foundOptional = userRepository.findById(id);
        return foundOptional.orElse(null);
    }
    @Override
    @Transactional
    public void updateUser(int id, User user) {
        userRepository.save(user);
    }
    @Override
    @Transactional
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
