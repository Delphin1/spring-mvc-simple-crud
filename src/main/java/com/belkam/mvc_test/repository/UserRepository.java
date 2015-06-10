package com.belkam.mvc_test.repository;

import com.belkam.mvc_test.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tsg on 05.06.2015.
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByIsDeletedFalse();
    User findByUserName(String userName);
}
