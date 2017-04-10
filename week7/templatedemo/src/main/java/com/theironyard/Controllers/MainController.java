package com.theironyard.Controllers;

import com.theironyard.entities.Reviewer;
import com.theironyard.repositories.ReviewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jeff on 1/11/17.
 */
@Controller
public class MainController {

    @Autowired
    ReviewerRepository reviewerRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String getHome(Model model){
        List<Reviewer> reviewers = reviewerRepository.findAll();

        model.addAttribute("reviewers", reviewers);

        return "index";
    }
}
