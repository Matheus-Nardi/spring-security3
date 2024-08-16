package com.mafn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {

    @GetMapping(value = "/home")
    public String handleWelcome() {
        return "home";
    }

    @GetMapping(value = "/user/home")
    public String handleUserHome() {
        return "home_user";
    }

    @GetMapping(value = "/admin/home")
    public String handleAdmHome() {
        return "home_adm";
    }

    @GetMapping(value = "/login")
    public String handleLogin(){
        return "login";
    }
}
