package com.belkam.mvc_test;

import com.belkam.mvc_test.model.User;
import com.belkam.mvc_test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@SpringBootApplication
@Import(com.belkam.mvc_test.config.MvcConfiguration.class)
public class Application /*implements CommandLineRunner*/ {
   /* @Autowired
    UserService us;

    public void run(String... strings) throws Exception {


        User user1 = new User("tsg", "adfasdfa", "Сергей Тарабара");
        User user2 = new User("abashev", "sdfghsdfh", "Андрей Абашев");
        User user3 = new User("starshev", "asdfa", "Валерий Старшев");
        User user4 = new User("panykov", "qwerq", "Евгений Панюков");
        User user5 = new User("izmestev", "qrwer", "Василий Изместьев");
        us.addList(Arrays.asList(user1, user2, user3, user4, user5));
    }*/

/*public class Application  { */

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}


