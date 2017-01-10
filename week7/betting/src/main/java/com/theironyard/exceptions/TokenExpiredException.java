package com.theironyard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jeff on 1/10/17.
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class TokenExpiredException extends RuntimeException{
}
