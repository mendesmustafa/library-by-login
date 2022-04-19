package com.mendes.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by mendesmustafa on 09.02.2021.
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("123")
                .roles("ADMIN")
                .and()
                .withUser("user")
                .password("123")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //.antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/admin/", "/admin/save", "/admin/addBookForm", "/admin/edit/{id}", "/admin/delete/{id}", "user/save", "user/addUser").hasRole("ADMIN")
                .antMatchers("/user/book/list", "/user/book/basket/{id}").hasAnyRole("USER", "ADMIN")
                //.antMatchers("/user/list", "user/basket/{id}").hasRole("USER")
                .and()
                .formLogin();
    }

}
