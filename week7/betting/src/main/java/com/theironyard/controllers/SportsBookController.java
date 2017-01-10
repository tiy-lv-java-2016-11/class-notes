package com.theironyard.controllers;

import com.sun.deploy.net.HttpResponse;
import com.theironyard.entities.Line;
import com.theironyard.entities.SportsBook;
import com.theironyard.exceptions.LoginFailedException;
import com.theironyard.exceptions.SportsBookNotFoundException;
import com.theironyard.repositories.LineRepository;
import com.theironyard.repositories.SportsBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by jeff on 1/9/17.
 */
@RestController
@RequestMapping(path = "/sports-books")
public class SportsBookController {

    @Autowired
    SportsBookRepository sportsBookRepository;

    @Autowired
    LineRepository lineRepository;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<SportsBook> getSportsBooks(){
        return sportsBookRepository.findAll();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public SportsBook createSportsBook(HttpServletResponse response, @Valid @RequestBody SportsBook sportsBook){
        sportsBookRepository.save(sportsBook);

        response.setStatus(HttpServletResponse.SC_CREATED);
        return sportsBook;
    }

    @RequestMapping(path = "/{spId}/", method = RequestMethod.GET)
    public SportsBook getSportsBook(@PathVariable int spId){
        SportsBook sportsBook = validateSportsBook(spId);
        return sportsBook;
    }

    @RequestMapping(path = "/{spId}/", method = RequestMethod.PUT)
    public SportsBook replaceSportsBook(@RequestHeader(value = "Authorization") String auth,
                                        @PathVariable int spId, @RequestBody SportsBook sportsBook){

        String[] parts = auth.split(" ");
        SportsBook savedSB = sportsBookRepository.findFirstByToken(parts[1]);
        if(savedSB == null || !savedSB.isTokenValid() || savedSB.getId() != spId){
            throw new LoginFailedException();
        }

        sportsBook.setId(spId);

        sportsBookRepository.save(sportsBook);
        return sportsBook;
    }

    @RequestMapping(path = "/{spId}/", method = RequestMethod.DELETE)
    public void deleteSportsBook(HttpServletResponse response, @PathVariable int spId){
        sportsBookRepository.delete(spId);
        response.setStatus(HttpServletResponse.SC_NO_CONTENT);
    }

    @RequestMapping(path = "/{spId}/lines/", method = RequestMethod.GET)
    public List<Line> getLines(@PathVariable int spId){
        SportsBook sportsBook = validateSportsBook(spId);
        return lineRepository.findAllBySportsBook(sportsBook);
    }

    /**
     * Takes a sportsBookId and makes sure it exists in the database
     * @param spId
     * @return SportsBook
     * @throws SportsBookNotFoundException when item doesn't exist
     */
    private SportsBook validateSportsBook(int spId){
        SportsBook sportsBook = sportsBookRepository.findOne(spId);
        if(sportsBook == null){
            throw new SportsBookNotFoundException();
        }
        return sportsBook;
    }

}
