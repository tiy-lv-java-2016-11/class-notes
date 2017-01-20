package com.theironyard.services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by jeff on 1/19/17.
 */
@Service
public class TwilioService {

    @Value("${twilio.sid}")
    private String accountSid;

    @Value("${twilio.token}")
    private String authToken;

    @Value("${twilio.phone}")
    private String fromPhone;

    @PostConstruct
    public void init(){
        Twilio.init(accountSid, authToken);
    }

    public String sendSMS(String phone){

        Message message = Message.creator(
                new PhoneNumber(phone),  // To number
                new PhoneNumber(fromPhone),  // From number
                "I am a twilio message"                    // SMS body
        ).create();

        return message.getSid();
    }

    public String callNumber(String phone) throws URISyntaxException {

        Call call = Call.creator(
                new PhoneNumber(phone),  // To number
                new PhoneNumber(fromPhone),  // From number

                // Read TwiML at this URL when a call connects (hold music)
                new URI("http://twimlets.com/holdmusic?Bucket=com.twilio.music.ambient")
        ).create();

        return call.getSid();
    }

//    @Scheduled(cron = "*/15 * * * * *")
    public void textSomeone(){
        Message message = Message.creator(
                new PhoneNumber(fromPhone),  // To number
                new PhoneNumber(fromPhone),  // From number
                "I am a twilio message"                    // SMS body
        ).create();


    }


}
