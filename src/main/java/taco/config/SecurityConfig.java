package taco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import taco.domain.User;
import taco.repository.UserRepository;

@Configuration
//@EnableGlobalMethodSecurity

public class SecurityConfig {

  @Bean
  public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
  }

  @Bean
  public UserDetailsService userDetailsService(UserRepository userRepository) {

    return username -> {
      User user = userRepository.findByUsername(username);
      if(user!=null){
        return user;
      }
      throw new UsernameNotFoundException("User '" + username + "' not found");
    };
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
     return httpSecurity
             .authorizeRequests()
             .antMatchers("/","/**").permitAll()
             .antMatchers(HttpMethod.POST,"/design","/orders").access("Role('USER')")
             .antMatchers("/admin/**").access("Role('ADMIN')")

             .and().formLogin().loginPage("/login").permitAll()
             .defaultSuccessUrl("/design").permitAll()
             .and().build();
  }

}
