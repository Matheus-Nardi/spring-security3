package com.mafn.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mafn.domain.models.Member;
import com.mafn.repositories.MemberRepository;

@Service
public class MemberDetailService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .roles(getRoles(member))
                .build();
    }

    private String[] getRoles(Member member){
        if(member.getRole() == null){
            return new String[] {"USER"};
        }
        return member.getRole().split(",");
    }

}
