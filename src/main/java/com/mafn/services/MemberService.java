package com.mafn.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mafn.domain.models.Member;
import com.mafn.repositories.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final  PasswordEncoder passwordEncoder;

    public Member registerMember(Member member){
        Member memberBuilder =  Member.builder()
        .username(member.getUsername())
        .password(passwordEncoder.encode(member.getPassword()))
        .role(member.getRole())
        .build();

        return memberRepository.save(memberBuilder);
    }
}
