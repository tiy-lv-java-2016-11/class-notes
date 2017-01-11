package com.theironyard.controllers;

import com.theironyard.command.LoginCommand;
import com.theironyard.entities.User;
import com.theironyard.repositories.UserRepository;
import com.theironyard.utilities.PasswordStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by jeff on 1/11/17.
 */
@Controller
public class UserController {
    public static final String SESSION_USERNAME = "username";

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLogin(HttpSession session){
        if(session.getAttribute(SESSION_USERNAME) != null){
            return "redirect:/";
        }

        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, LoginCommand command) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException {
        User dbUser = userRepository.findFirstByUsername(command.getUsername());

        if(dbUser == null){
            dbUser = new User(command.getUsername(), PasswordStorage.createHash(command.getPassword()));
            userRepository.save(dbUser);
        }
        else if(!PasswordStorage.verifyPassword(command.getPassword(), dbUser.getPassword())){
            return "redirect:/login";
        }

        session.setAttribute(SESSION_USERNAME, dbUser.getUsername());

        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
