package pl.edu.pw.elka.bdbt.athleticsclub.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                // adres
                .antMatchers( "/address/**").hasAnyRole( "ADMIN")
                // wlasciciel
                .antMatchers( "/owner/**").hasAnyRole( "ADMIN", "TRAINER")
                // klub
                .antMatchers( "/club/**").hasAnyRole( "ADMIN", "TRAINER")
                // treningi
                .antMatchers("/training/**").hasAnyRole( "ADMIN", "TRAINER", "ATHLETE")
                // obiekty
                .antMatchers("/facility/**").hasAnyRole( "ADMIN", "TRAINER", "ATHLETE")
                // pracownicy
                .antMatchers("/worker/**").hasAnyRole( "ADMIN", "TRAINER")
                // sprzet
                .antMatchers("/equipment/**").hasAnyRole( "ADMIN", "TRAINER")
                // producent
                .antMatchers("/producer/**").hasAnyRole( "ADMIN", "TRAINER")



                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .passwordParameter("password")
                .usernameParameter("username")
                .defaultSuccessUrl("/", true)
                .permitAll()

                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/")
                .and()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .and()
                .withUser("trainer")
                .password(passwordEncoder().encode("trainer"))
                .roles("TRAINER")
                .and()
                .withUser("athlete")
                .password(passwordEncoder().encode("athlete"))
                .roles("ATHLETE");
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
