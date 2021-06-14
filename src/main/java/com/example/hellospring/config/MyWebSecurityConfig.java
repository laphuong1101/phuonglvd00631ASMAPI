package com.example.hellospring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
//        User.UserBuilder user = User.withDefaultPasswordEncoder();
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(user.username("user").password(("123")).roles("USER").build());
//        manager.createUser(user.username("admin").password(("123")).roles("USER", "ADMIN").build());
//        return manager;
        return new MyUserDetailsService();
    }

    @Bean(name = "bCryptPasswordEncoder")
    public BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    // cach 2
//    @Bean(name = "bCryptPasswordEncoder")
//    public PasswordEncoder passwordEncoder() {
//        //    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/district/create", "/user/*").permitAll() // bo qua k can quyen
            .antMatchers("/admin/district").hasAnyRole("ADMIN" )
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .permitAll()
            .and()
            .logout()
            .permitAll();
    }
}
