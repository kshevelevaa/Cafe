package com.example.cafe.config;

import com.example.cafe.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/register", "/", "/index", "/about", "/login", "/dishes*")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/index")
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/**/**/**.css", "/**/**/**/**.jpg", "/**/**/**.jpg", "/**/**/**.png", "/**/**/**/**.png", "/**/**/**.js",
                        "/**/**/**jpeg", "/**/**/**.gif", "/**/**/**.webm", "/**/**.png", "/**/**/**.otf", "/**/**/**.eot", "/**/**/**.svg", "/**/**/**.ttf",
                        "/**/**/**.woff", "/**/**/**woff2", "/**/**.xml", "/**/**.iml", "/**/**.html", "/**/**/**.min.css", "/**/**/**.scss", "/**/**/**.jpeg", "/**/**/**.mp4");
    }

    //    @Autowired
//    private UserService userService;
//    @Bean
//public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    http
//            .csrf(AbstractHttpConfigurer::disable);
//    http
//            .authorizeRequests()
//            .antMatchers("/login*", "/register","/api/**")
//            .permitAll()
//            .anyRequest()
//            .authenticated();
//    http
//            .formLogin(form -> form
//                    .loginPage("/login").permitAll()
//                    .loginProcessingUrl("/login")
//                    .usernameParameter("username")
//                    .passwordParameter("password")
//                    .defaultSuccessUrl("/")
//                    .failureUrl("/login?error=true")
//            );
//    http.
//            logout()
//            .invalidateHttpSession(true)
//            .clearAuthentication(true)
//            .deleteCookies("JSESSIONID").permitAll();
//
//    http.rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400).userDetailsService(userService);
//
//    return http.build();
//}
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/**/**/**/**.css", "/**/**/**/**.js");
//    }
    @Bean
    public AuthenticationManager authManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService)
            throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }
}