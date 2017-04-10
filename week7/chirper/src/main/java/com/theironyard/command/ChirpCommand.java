package com.theironyard.command;

import javax.validation.constraints.Size;

/**
 * Created by jeff on 1/11/17.
 */
public class ChirpCommand {
    @Size(max = 160)
    private String message;

    private String subject;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

}
