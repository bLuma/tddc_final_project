package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.CommandLinePropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class FinalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalApplication.class, args);
    }

    @Configuration
    @EnableWebSecurity
    public static class SecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .authorizeRequests().antMatchers("/**").permitAll()
                    .anyRequest().authenticated();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
        }

    }

    @Component
    public static class RunAtStartup implements CommandLineRunner {

        @Value("${spring.datasource.url}")
        private String datasource;

        @Override
        public void run(String... args) throws Exception {
            System.out.println("RunAtStartup " + datasource);
        }

    }

}
