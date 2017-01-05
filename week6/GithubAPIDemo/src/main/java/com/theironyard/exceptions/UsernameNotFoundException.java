package com.theironyard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jeff on 1/5/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Username not a github user")
public class UsernameNotFoundException extends RuntimeException {
}
