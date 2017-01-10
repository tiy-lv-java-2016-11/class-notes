package com.theironyard.controllers;

import com.theironyard.entities.Line;
import com.theironyard.entities.SportsBook;
import com.theironyard.exceptions.LineNotFoundException;
import com.theironyard.exceptions.NotOwnerException;
import com.theironyard.repositories.LineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by jeff on 1/10/17.
 */
@RestController
@RequestMapping(path = "/lines")
public class LineController {
    @Autowired
    LineRepository lineRepository;

    @Autowired
    AuthenticationController authenticationController;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Line> getLines(){
        return lineRepository.findAll();
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public Line createLine(@RequestHeader(value = "Authorization") String auth,
                           HttpServletResponse response, @RequestBody Line line){
        SportsBook sp = authenticationController.getSportsbookFromAuth(auth);
        line.setSportsBook(sp);
        lineRepository.save(line);

        response.setStatus(HttpServletResponse.SC_CREATED);

        return line;
    }

    @RequestMapping(path = "/{lineId}/", method = RequestMethod.GET)
    public Line getLine(@PathVariable int lineId){
        Line line = lineRepository.findOne(lineId);

        if(line == null){
            throw new LineNotFoundException();
        }

        return line;
    }

    @RequestMapping(path = "/{lineId}/", method = RequestMethod.PUT)
    public Line updateLine(@RequestHeader(value = "Authorization") String auth,
                           HttpServletResponse response, @RequestBody Line line,
                           @PathVariable int lineId){
        SportsBook sb = authenticationController.getSportsbookFromAuth(auth);
        Line savedLine = lineRepository.findOne(lineId);

        if(sb.getId() != savedLine.getSportsBook().getId()){
            throw new NotOwnerException();
        }

        line.setId(savedLine.getId());
        lineRepository.save(line);

        response.setStatus(HttpServletResponse.SC_CREATED);

        return line;
    }


}
