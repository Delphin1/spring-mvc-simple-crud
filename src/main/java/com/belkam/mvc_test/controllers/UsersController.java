package com.belkam.mvc_test.controllers;

import com.belkam.mvc_test.model.User;
import com.belkam.mvc_test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by tsg on 05.06.2015.
 */
@Controller
@RequestMapping("/mvc/users")        //root mapping
public class UsersController {
    @Autowired
    UserService userService;

    //@RequestMapping(value = "/")                    //Все пользователи
    @RequestMapping(method=RequestMethod.GET)
    public String users(Model model) {
        model.addAttribute("users", userService.getAll());
        return "users/users";
    }

    @RequestMapping(params="new", method=RequestMethod.GET)    //Создаём пустого для отображения на форме
    public String userAddView(Model model) {
        model.addAttribute(new User());
        return "users/edit";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addUserFromForm(@Valid User user, BindingResult bindingResult, @RequestParam(value="action", required=true) String action) {    //Сохраняем пользователя с формы
        if (action.equals("save")) {
            if (bindingResult.hasErrors()) {
                return "users/edit";
            }
            user.setIsDeleted(!user.getIsDeleted());    //Инвертируем признак удаления для сохранения в БД
            userService.add(user);
        }

        if (action.equals("delete")) {
            userService.delete(user);

        }
        return "redirect:/mvc/users";
    }



    @RequestMapping(value = "/edit/{userId}", method=RequestMethod.GET)           ///mvc/users/1                  //Показываем конкретного на редактирование
     public String userEditView(@PathVariable("userId") long userId, Model model) {
        User user = userService.get(userId);
        user.setIsDeleted(!user.getIsDeleted()); //Инвертируем признак удаления для показа в checkbox
        model.addAttribute("user", user);
        return "users/edit";
    }


    @RequestMapping(value = "/edit/{userId}", method=RequestMethod.POST)           ///mvc/users/1                  //Принимаем с формы на редактирование
    public String userUpdate(@PathVariable("userId") long userId, Model model, @Valid User user, BindingResult bindingResult,  @RequestParam(value="action", required=true) String action ) {
        addUserFromForm(user, bindingResult, action);
        return "redirect:/mvc/users";
    }


    @RequestMapping(value = "/delete/{userId}", method=RequestMethod.GET)                           //Показываем конкретного на удаление
    public String userDeleteView(@PathVariable("userId") long userId, Model model) {
        model.addAttribute("user", userService.get(userId));
        return "users/delete";
    }

    @RequestMapping(value = "/delete/{userId}", method=RequestMethod.POST)           ///mvc/users/1                  //Принимаем с формы на удаление
    public String userDelete(@PathVariable("userId") long userId, Model model, @Valid User user, BindingResult bindingResult,  @RequestParam(value="action", required=true) String action ) {
        addUserFromForm(user, bindingResult, action);
        return "redirect:/mvc/users";
    }

}
