package com.theironyard.controllers;

import com.theironyard.Utilities.PasswordStorage;
import com.theironyard.models.Game;
import com.theironyard.models.User;
import com.theironyard.repositories.GameRepository;
import com.theironyard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import java.util.List;

/**
 * Created by jeff on 12/28/16.
 */
@Controller
public class GameTrackerController {
    public static final String SESSION_USERNAME = "userName";

    @Autowired
    GameRepository gameRepository;

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void init(){
        if(userRepository.count() == 0){
            User user = new User("bob", "bob");
            userRepository.save(user);
        }
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session, Model model, String genre, @RequestParam(name = "releaseYear", required = false) Integer year, String search){
        List<Game> games;
        if(genre != null){
            games = gameRepository.findByGenre(genre);
        }
        else if(year != null && year > 1950){
            games = gameRepository.findByReleaseYear(year);
        }
        else if(search != null){
            games = gameRepository.findByNameStartsWith(search);
        }
        else{
            games = gameRepository.findAll();
        }
        model.addAttribute("user", session.getAttribute(SESSION_USERNAME));
        model.addAttribute("games", games);
        return "home";
    }

    @RequestMapping(path = "/add-game", method = RequestMethod.POST)
    public String addGame(HttpSession session, String gameName, String gamePlatform, String gameGenre, int gameYear){
        String userName = (String)session.getAttribute(SESSION_USERNAME);
        User user = userRepository.findFirstByName(userName);
        if(user != null){
            Game game = new Game(gameName, gamePlatform, gameGenre, gameYear, user);
            gameRepository.save(game);
        }

        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        User user = userRepository.findFirstByName(userName);
        if(user == null){
            user = new User(userName, PasswordStorage.createHash(password));
            userRepository.save(user);
        }
        else if(!PasswordStorage.verifyPassword(password, user.getPassword())){
            throw new Exception("Incorrect password");
        }
        session.setAttribute(SESSION_USERNAME, userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
