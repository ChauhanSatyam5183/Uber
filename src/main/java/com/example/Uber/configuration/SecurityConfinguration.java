//package com.example.Uber.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfinguration {
//
//    @Bean
//   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.csrf(csrf->csrf.disable()).authorizeRequests((authorizeRequests)->
//                authorizeRequests
//                        .requestMatchers("/**").hasRole("ADMIN")
//                        .requestMatchers("/uber/v1/driver").hasRole("AdMIN")
//                        .requestMatchers("/uber/v1/Customer").hasRole("Emp"))
//
//
//                .httpBasic(withDefaults());
//
//  return http.build();
//    }
//
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1= User.builder().username("satyam").password(getEncoder().encode("satyam@24273")).roles("ADMIN").build();
//        UserDetails user2= User.builder().username("Garima").password("{noop}chori").roles("Emp").build();
//
//        return new InMemoryUserDetailsManager(user1,user2);
//    }
//
//    @Bean
//    public PasswordEncoder getEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//
//
//}