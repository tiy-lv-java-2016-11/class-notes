package com.theironyard.controllers;

import com.theironyard.services.StripeService;
import com.theironyard.services.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URISyntaxException;

/**
 * Created by jeff on 1/19/17.
 */
@Controller
public class MainController {

    @Autowired
    StripeService stripe;

    @Autowired
    TwilioService twilio;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(){
        return "home";
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public String pay(String stripeToken){

        String chargeId = stripe.chargeCard(stripeToken, 1499);

        return "redirect:/thank-you";

    }

    @RequestMapping(path = "/thank-you", method = RequestMethod.GET)
    public String thankYou(){
        return "thankyou";
    }

    @RequestMapping(path = "/send-sms", method = RequestMethod.GET)
    public String sendSMS(){
        twilio.sendSMS("+15558881234");

        return "redirect:/";
    }

    @RequestMapping(path = "/call", method = RequestMethod.GET)
    public String callSomeone() throws URISyntaxException {
        twilio.callNumber("+15558881234");

        return "redirect:/";
    }
}
