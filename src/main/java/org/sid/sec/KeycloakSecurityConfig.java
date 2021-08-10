package org.sid.sec;

import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;

@KeycloakConfiguration
public class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(keycloakAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        //http.authorizeRequests().antMatchers("/products/**").hasAuthority("user");
        http.authorizeRequests().antMatchers("/products/**").permitAll();
        http.authorizeRequests().antMatchers("/categories/**").permitAll();
        //http.authorizeRequests().antMatchers("/products/**").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/uploadPhoto/{id}/**").hasAuthority("admin");
        //http.authorizeRequests().antMatchers("/uploadPhoto/{id}/**").hasAuthority("user");
        //http.authorizeRequests().antMatchers("/photoProduct/{id}/**").hasAuthority("user");
        //http.authorizeRequests().antMatchers("/photoProduct/{id}/**").hasAuthority("admin");
        /*super.configure(http);
        http.cors().and().authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/products/**")
                .authenticated()
                .anyRequest().permitAll();
        http.csrf().disable();*/




    }


}
