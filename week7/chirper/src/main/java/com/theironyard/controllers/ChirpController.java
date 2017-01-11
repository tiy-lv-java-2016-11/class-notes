package com.theironyard.controllers;

import com.theironyard.command.ChirpCommand;
import com.theironyard.entities.Chirp;
import com.theironyard.entities.User;
import com.theironyard.repositories.ChirpRepository;
import com.theironyard.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by jeff on 1/11/17.
 */
@Controller
public class ChirpController {

    @Autowired
    ChirpRepository chirpRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getChirps(HttpSession session, Model model){

        Sort sort = new Sort(Sort.Direction.DESC, "createdAt");
        model.addAttribute("chirps", chirpRepository.findAll(sort));
        model.addAttribute("username", session.getAttribute(UserController.SESSION_USERNAME));
        return "chirps";
    }

    @RequestMapping(path = "/chirp-detail/{chirpId}", method = RequestMethod.GET)
    public String getChirp(Model model, @PathVariable int chirpId){
        Chirp chirp = chirpRepository.findOne(chirpId);

        if(chirp == null){
            return "404";
        }

        model.addAttribute("chirp", chirp);
        return "chirp-detail";
    }

    @RequestMapping(path = "/chirp-create", method = RequestMethod.GET)
    public String getCreateForm(HttpSession session){
        if(session.getAttribute(UserController.SESSION_USERNAME) == null){
            return "redirect:/login";
        }

        return "chirp-create";
    }

    @RequestMapping(path = "/chirp-create", method = RequestMethod.POST)
    public String createChirp(HttpSession session, @Valid ChirpCommand command){
        User user = userRepository.findFirstByUsername((String)session.getAttribute(UserController.SESSION_USERNAME));
        if(user == null){
            return "redirect:/login";
        }

        Chirp chirp = new Chirp(command.getMessage(), command.getSubject(), user);
        chirpRepository.save(chirp);

        return "redirect:/";
    }
}
