package com.pureshots.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
  {
    auth.inMemoryAuthentication().withUser("atanas").password("1234").roles("USER");
    auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN");
    auth.inMemoryAuthentication().withUser("dba").password("1234").roles("DBA");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {

    http.authorizeRequests()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/profile/**").hasRole("USER")
            .and()
            .formLogin()
//            .formLogin().loginPage("/login").permitAll();
//            .usernameParameter("username")
//            .passwordParameter("password")
            .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
//            .logoutSuccessHandler(logoutSuccessHandler)
            .invalidateHttpSession(true)
//            .addLogoutHandler(logoutHandler)
            ;

  }
}
