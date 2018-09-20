package com.qa.lmsproject.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
@RequestMapping("/security")
public class SecurityController {
 
    @RequestMapping(value = "/getUsername", method = RequestMethod.GET)
    public String currentUserName(Principal principal) {
    	String json = "{\"username\": \"" + principal.getName() + "\"}";
        return json;
    }
}
