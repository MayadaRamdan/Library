package com.Library.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig  {
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.httpBasic(Customizer.withDefaults());
//        http.authorizeHttpRequests((requests)-> requests
//                .requestMatchers(HttpMethod.GET , "/library/api/books/**").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.POST , "/library/api/books").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.PUT , "/library/api/books").hasRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE , "/library/api/books").hasRole("ADMIN").and().csrf().disable());
//        return http.build();
//
//    }
//
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }
//
//
//}
