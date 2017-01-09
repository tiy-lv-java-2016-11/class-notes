package com.theironyard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jeff on 1/9/17.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class SportsBookNotFoundException extends RuntimeException {
}
