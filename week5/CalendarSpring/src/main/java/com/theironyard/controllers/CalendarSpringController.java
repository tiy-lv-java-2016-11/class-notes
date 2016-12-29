package com.theironyard.controllers;

import com.theironyard.entities.Event;
import com.theironyard.entities.User;
import com.theironyard.repositories.EventRepository;
import com.theironyard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by jeff on 12/29/16.
 */
@Controller
public class CalendarSpringController {
    public static final String SESSION_USERNAME = "userName";

    @Autowired
    EventRepository eventRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        String userName = (String)session.getAttribute(SESSION_USERNAME);
        List<Event> events = eventRepository.findAllByOrderByDateTimeDesc();

        if(userName != null){
            User user = userRepository.findFirstByName(userName);
            model.addAttribute("user", user);
            model.addAttribute("now", LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
        }
        model.addAttribute("events", events);
        return "home";
    }

    @RequestMapping(path = "/create-event", method = RequestMethod.POST)
    public String createEvent(HttpSession session, String description, String dateTime){
        String userName = (String) session.getAttribute(SESSION_USERNAME);

        if(userName != null){
            User user = userRepository.findFirstByName(userName);
            LocalDateTime localDateTime = LocalDateTime.parse(dateTime);
            Event event = new Event(description, localDateTime, user);
            eventRepository.save(event);
        }

        return "redirect:/";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String name) {
        User user = userRepository.findFirstByName(name);
        if (user == null) {
            user = new User(name);
            userRepository.save(user);
        }
        session.setAttribute(SESSION_USERNAME, name);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
