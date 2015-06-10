package com.belkam.mvc_test.services;

import com.belkam.mvc_test.config.MvcConfiguration;
import com.belkam.mvc_test.model.User;
import com.belkam.mvc_test.services.UserService;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


/**
 * Created by tsg on 05.06.2015.
 */
@ContextConfiguration(classes = MvcConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@Transactional
public class TestUserService {
    private Logger log = Logger.getLogger(TestUserService.class);


    @Autowired
    UserService us;

    @Before
    @Rollback(true)
    public void init() {
        User user1 = new User("tsg", "adfasdfa", "Сергей Тарабара");
        User user2 = new User("abashev", "sdfghsdfh", "Андрей Абашев");
        User user3 = new User("starshev", "asdfa", "Валерий Старшев");
        User user4 = new User("panykov", "qwerq", "Евгений Панюков");
        User user5 = new User("izmestev", "qrwer", "Василий Изместьев");
        us.addList(Arrays.asList(user1, user2, user3, user4, user5));

    }


    //@Test
    public void testUserByName() {
        User user = us.getByName("abashev");
        log.info(user);
        Assert.assertEquals(user.getUserName(), "abashev");
    }

    @Test
    public void testGetAll() {
        List<User> userList= us.getAll();
        for (User user: userList) {
            log.info(user);
        }

    }

}
