package com.mafn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mafn.DTO.LoginFormDTO;
import com.mafn.infra.security.MemberDetailService;
import com.mafn.infra.security.webtoken.JwtService;

@RestController
public class ContentController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private MemberDetailService memberDetailService;

    @GetMapping(value = "/home")
    public String handleWelcome() {
        return "Welcome to home";
    }

    @GetMapping(value = "/user/home")
    public String handleUserHome() {
        return "Welcome to USER home";
    }

    @GetMapping(value = "/admin/home")
    public String handleAdmHome() {
        return "Welcome to ADMIN home";
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody LoginFormDTO loginFormDTO) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginFormDTO.username(), loginFormDTO.password()
        ));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(memberDetailService.loadUserByUsername(loginFormDTO.username()));
        } else {
            throw new UsernameNotFoundException("Invalid credentials");
        }
    }
}
