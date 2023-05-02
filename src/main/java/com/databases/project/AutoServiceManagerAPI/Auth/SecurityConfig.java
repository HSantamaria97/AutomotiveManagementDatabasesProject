package com.databases.project.AutoServiceManagerAPI.Auth;

import com.databases.project.AutoServiceManagerAPI.Service.UserDetailsServiceImpl;
import org.springframework.context.annotation.*;
import org.springframework.security.authentication.dao.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").hasAnyAuthority("TECHNICIAN", "SERVICE_MANAGER", "ADMIN")
                .antMatchers("/admin").hasAnyAuthority("ADMIN")
                .antMatchers("/servicemanager").hasAnyAuthority("ADMIN","SERVICE_MANAGER")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and().httpBasic()
                .and().build()
        ;
    }
}