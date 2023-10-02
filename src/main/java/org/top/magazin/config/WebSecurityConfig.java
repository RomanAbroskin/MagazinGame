package org.top.magazin.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.top.magazin.postgres.repository.ClientRepository;
import org.top.magazin.postgres.security.DbUserDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((request) -> request
                        .requestMatchers("/", "webjars/**","img/**").permitAll()
                        .requestMatchers("develop/create-admin","develop/create-user").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .failureUrl("/login?error=true")
                        .successForwardUrl("/")
                )
                .logout((customizer) -> customizer
                        .logoutSuccessUrl("/login")
                );
        return  http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public final ClientRepository clientRepository;

      @Bean
       public UserDetailsService userDetailsService(){
          return new DbUserDetailsService(clientRepository);
    }
      @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
          final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
          authProvider.setUserDetailsService(userDetailsService());
          authProvider.setPasswordEncoder(passwordEncoder());
          return authProvider;
      }

      protected final DataSource dataSource;

    @Bean
    public UserDetailsManager users(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .passwordEncoder(passwordEncoder())
                .and()
                .authenticationProvider(daoAuthenticationProvider())
                .build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setAuthenticationManager(authenticationManager);
        return jdbcUserDetailsManager;
    }

    }


 /* @Bean
        public UserDetailsService userDetailsService() {
            UserDetails user = User.builder()
                    .username("user")
                    .password("qwerty")
                    .roles("USER")
                    .passwordEncoder(passwordEncoder()::encode)
                    .build();

            UserDetails admin = User.builder()
                    .username("admin")
                    .password("qwerty")
                    .roles("ADMIN")
                    .passwordEncoder(passwordEncoder()::encode)
                    .build();
            return new InMemoryUserDetailsManager(user, admin);
        }*/
