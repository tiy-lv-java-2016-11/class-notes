package com.theironyard.controllers;

import com.theironyard.models.Person;
import com.theironyard.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;


@Controller
public class HelloSpringController {
    public static final String SESSION_USER_NAME = "userName";

    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public String person(Model model, String name, String city, int age) {
        Person p = new Person(name, city, age);
        model.addAttribute("person", p);
        return "person";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
//        User user = (User)session.getAttribute("user");
//        if(user != null) {
//            model.addAttribute("name", user.getName());
//        }
        String userName = (String)session.getAttribute(SESSION_USER_NAME);
        model.addAttribute("name", userName);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName){
//        User user = new User(userName, "password");
//        session.setAttribute("user", user);

        session.setAttribute(SESSION_USER_NAME, userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
