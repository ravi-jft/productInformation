package com.productStore.config;


import com.productStore.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@ComponentScan("com.productStore")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(customUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

   /*     http.formLogin().loginPage("/login")
                .usernameParameter("userId")
                .passwordParameter("password");
        http.formLogin().defaultSuccessUrl
                ("/market/products/add")
                .failureUrl("/login?error");
        http.logout().logoutSuccessUrl("/login");
                http.exceptionHandling().accessDeniedPage
                        ("/login?accessDenied");
        http.authorizeRequests()
                .antMatchers("/admin*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/dba*").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_DBA')")
                .and().formLogin();*/
        http.authorizeRequests().antMatchers("/login*").permitAll();
    }
}
