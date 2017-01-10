package com.theironyard.controllers;

import com.theironyard.command.LoginCommand;
import com.theironyard.entities.SportsBook;
import com.theironyard.exceptions.LoginFailedException;
import com.theironyard.exceptions.SportsBookNotFoundException;
import com.theironyard.exceptions.TokenExpiredException;
import com.theironyard.repositories.SportsBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeff on 1/10/17.
 */
@RestController
public class AuthenticationController {

    @Autowired
    SportsBookRepository sportsBookRepository;

    public SportsBook getSportsbookFromAuth(String auth){
        String[] parts = auth.split(" ");
        SportsBook savedSB = sportsBookRepository.findFirstByToken(parts[1]);

        if(savedSB == null || !savedSB.isTokenValid()){
            throw new LoginFailedException();
        }

        return savedSB;
    }

    @RequestMapping(path = "/token/", method = RequestMethod.POST)
    public Map getToken(@RequestBody LoginCommand command){
        SportsBook sportsBook = sportsBookRepository.findOne(command.getId());
        if(sportsBook == null) {
            throw new SportsBookNotFoundException();
        }

        if(!sportsBook.getPassword().equals(command.getPassword())){
            throw new LoginFailedException();
        }

        if(!sportsBook.isTokenValid()){
            sportsBook.regenerate();
        }

        Map<String, String > rval = new HashMap<>();
        rval.put("token", sportsBook.getToken());
        return rval;

    }

}
