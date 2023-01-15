//package pl.edu.pw.elka.bdbt.athleticsclub.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//@Configuration
//@EnableWebMvc
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/address/create").hasAuthority("ROLE_TRAINER")
//                .antMatchers(HttpMethod.GET, "address/getAll").hasAuthority("ROLE_TRAINER")
//
//
//                // feature test
//                .antMatchers("/training/**").permitAll()
//                .antMatchers("/worker/**").permitAll()
//                .antMatchers("/address/**").permitAll()
//                .antMatchers("/club/**").permitAll()
//                .antMatchers("/owner/**").permitAll()
//
//
//
//                .antMatchers("/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
////                .loginPage("/login")
////                .usernameParameter("username")
////                .passwordParameter("password")
////                .permitAll()
//                .and()
//                .httpBasic();
//    }
//
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles("ADMIN", "TRAINER", "ATHLETE")
//                .and()
//                .withUser("trainer")
//                .password(passwordEncoder().encode("trainer"))
//                .roles("TRAINER")
//                .and()
//                .withUser("athlete")
//                .password(passwordEncoder().encode("athlete"))
//                .roles("ATHLETE");
//    }
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//

//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
//        UserDetails admin = User.withUsername("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();
//        UserDetails athlete = User.withUsername("athlete")
//                .password("athlete")
//                .roles("ATHLETE")
//                .build();
//
//        UserDetails trainer = User.withUsername("trainer")
//                .password("trainer")
//                .roles("TRAINER")
//                .build()
//
//    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/admin/**")
//                .hasRole("ADMIN")
//                .antMatchers("/anonymous*")
//                .anonymous()
//                .antMatchers("/login*")
//                .permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/loginPage")
//                .loginProcessingUrl("/perform_login")
//                .defaultSuccessUrl("/homepage.html", true)
//                .failureUrl("/login.html?error=true")
//                .and()
//                .logout()
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID");
//
//        return http.build();
//    }
//}
