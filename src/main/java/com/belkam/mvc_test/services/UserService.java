package com.belkam.mvc_test.services;

import com.belkam.mvc_test.model.User;

import java.util.List;

/**
 * Created by tsg on 05.06.2015.
 */
public interface UserService {
    List<User> getAll();
    User get(long id);
    void add(User user);
    User edit(User user);
    void delete(User user);
    long count();
    User getByName(String name);
    void addList (List<User> users);
}
