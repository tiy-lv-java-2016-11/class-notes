package com.theironyard.services;

import com.theironyard.entities.GithubUser;
import com.theironyard.exceptions.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jeff on 1/5/17.
 */
@Service
public class GithubApiService {

    public static final String BASE_URL = "https://api.github.com/users/";

    @Autowired
    RestTemplate restTemplate;

    public GithubApiService() {
    }

    public GithubUser getByUsername(String username){
        GithubUser user;
        try {
            user = restTemplate.getForObject(BASE_URL + username, GithubUser.class);
        }
        catch (RestClientException e){
            throw new UsernameNotFoundException();
        }

        return user;
    }
}
