package com.mafn.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mafn.domain.models.Member;
import com.mafn.services.MemberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @PostMapping(value = "/register")
    public ResponseEntity<Member> registerMember(@Valid @RequestBody Member memberBody) {
        Member memberCreated = memberService.registerMember(memberBody);
        return ResponseEntity.status(HttpStatus.CREATED).body(memberCreated);
    }

}
