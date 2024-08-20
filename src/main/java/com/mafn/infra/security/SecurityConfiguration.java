package com.mafn.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

    @Autowired
    private MemberDetailService memberDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.authorizeHttpRequests(costumizer -> {
            costumizer.requestMatchers("/home" , "/register").permitAll();
            costumizer.requestMatchers("/user/**").hasRole("USER");
            costumizer.requestMatchers("/admin/**").hasRole("ADMIN");
            costumizer.requestMatchers("/h2-console/**").permitAll();
            costumizer.anyRequest().authenticated();
        })
                .csrf(csrf -> csrf.disable())
                .headers(headers -> headers.disable())
                .formLogin(costumizer -> costumizer.loginPage("/login").successHandler(new AuthenticationSuccessHandler()).permitAll())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return memberDetailService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(memberDetailService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
