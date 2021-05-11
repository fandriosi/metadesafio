package com.andriosi.fabio.metadesafio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {
    @RequestMapping ("/user")
    public Principal user(Principal user){
        return user;
    }
    @RequestMapping("/sources")
    public String getSources(){
        return "https://github/fandriosi/meta-dasafio";
    }
}
