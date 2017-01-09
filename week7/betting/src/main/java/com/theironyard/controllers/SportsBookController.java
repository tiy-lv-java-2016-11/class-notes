package com.theironyard.controllers;

import com.sun.deploy.net.HttpResponse;
import com.theironyard.entities.Line;
import com.theironyard.entities.SportsBook;
import com.theironyard.exceptions.SportsBookNotFoundException;
import com.theironyard.repositories.LineRepository;
import com.theironyard.repositories.SportsBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public SportsBook createSportsBook(HttpResponse response, @RequestBody SportsBook sportsBook){
        sportsBookRepository.save(sportsBook);

        return sportsBook;
    }

    @RequestMapping(path = "/{spId}/", method = RequestMethod.GET)
    public SportsBook getSportsBook(@PathVariable int spId){
        SportsBook sportsBook = validateSportsBook(spId);
        return sportsBook;
    }

    @RequestMapping(path = "/{spId}/", method = RequestMethod.PUT)
    public SportsBook replaceSportsBook(@PathVariable int spId, @RequestBody SportsBook sportsBook){
        SportsBook savedSB = validateSportsBook(spId);
        sportsBook.setId(spId);

        sportsBookRepository.save(sportsBook);
        return sportsBook;
    }

    @RequestMapping(path = "/{spId}/", method = RequestMethod.DELETE)
    public void deleteSportsBook(@PathVariable int spId){
        sportsBookRepository.delete(spId);
    }

    @RequestMapping(path = "/{spId}/lines/", method = RequestMethod.GET)
    public List<Line> getLines(@PathVariable int spId){
        SportsBook sportsBook = validateSportsBook(spId);

        return lineRepository.findAllBySportsBook(sportsBook);
    }

    @RequestMapping(path = "/{spId}/lines/", method = RequestMethod.POST)
    public Line createLine(@PathVariable int spId, @RequestBody Line line){
        SportsBook sportsBook = validateSportsBook(spId);
        line.setSportsBook(sportsBook);
        lineRepository.save(line);
        return line;

    }


    public SportsBook validateSportsBook(int spId){
        SportsBook sportsBook = sportsBookRepository.findOne(spId);
        if(sportsBook == null){
            throw new SportsBookNotFoundException();
        }
        return sportsBook;
    }

}
