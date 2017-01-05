package com.theironyard.controllers;

import com.theironyard.entities.GithubUser;
import com.theironyard.services.GithubApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jeff on 1/5/17.
 */
@Controller
public class UserController {

    @Autowired
    GithubApiService github;

    @RequestMapping(path = "/users/{username}", method = RequestMethod.GET)
    public String getUser(Model model, @PathVariable String username){
        GithubUser user = github.getByUsername(username);
        model.addAttribute("user", user);

        return "home";
    }

}
