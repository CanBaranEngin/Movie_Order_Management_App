package com.MovieOrderManagement.config;

import com.MovieOrderManagement.security.JwtTokenFilterConfigurer;
import com.MovieOrderManagement.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;



    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // Disable CSRF (cross site request forgery) ATTACK TYPE !!
        http.csrf().disable();

        // No session will be created or used by spring security
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // Entry points
        http.authorizeRequests()
                .antMatchers("/api/v1/users/signin").permitAll()
                .antMatchers("/api/v1/users/signup").permitAll()
                .antMatchers("/api/v1/UserAccount").permitAll()
                .antMatchers("/api/v1/subscription").permitAll()
                .antMatchers("/api/v1/userAccountBalance/{id}").permitAll()
                .antMatchers("/api/v1/ListMovies").permitAll()
                // Authorize any endpoint by a role
                .antMatchers("/api/v1/users/{username}").hasRole("ADMIN")
                .antMatchers("/api/v1/users").hasRole("ADMIN")
                .antMatchers("/api/v1/movieOrder").hasRole("SUBSCRIBER")
                .antMatchers("/api/v1/movieOrders").hasRole("ADMIN")
                .antMatchers("/api/v1/subscriptions").hasRole("ADMIN")
                .antMatchers("/api/v1/movies").hasRole("ADMIN");
                // Disallow everything else..
                //.anyRequest().authenticated();
        // Apply JWT
        http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
