package com.belkam.mvc_test.services;

import com.belkam.mvc_test.model.User;
import com.belkam.mvc_test.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tsg on 05.06.2015.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService  {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }


    public List<User> getAllNotDeleted() {
        return userRepository.findByIsDeletedFalse();
    }
    @Override
    public User get(long id) {
        return userRepository.findOne(id);
    }
    @Override
    public void add(User user) {
        userRepository.save(user);
    }
    @Override
    public User edit(User user) {
        return userRepository.save(user);
    }
    @Override
    public void delete(User user) {
        userRepository.delete(user);

    }
    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public User getByName(String name) {
        return userRepository.findByUserName(name);
    }

    @Override
    public void addList (List<User> users) {
        userRepository.save(users);
    }
}
