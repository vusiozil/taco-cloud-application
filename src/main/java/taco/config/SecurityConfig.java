package taco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
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
  public UserDetailsService userDetailsService(UserRepository userRepository){

    return username -> {
      User user = userRepository.findByUsername(username);
      if(user != null){
        return user;
      }
      throw new UsernameNotFoundException("User '" + username + "' not found");
    };
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
    return httpSecurity
            .csrf().disable() // Disable CSRF for stateless APIs
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No sessions
            .and()
            .authorizeHttpRequests()
            .antMatchers(HttpMethod.GET, "/", "/public/**","/api-docs","/swagger-ui").permitAll() // Public endpoints
            .antMatchers(HttpMethod.POST, "/orders").hasRole("USER") // Require USER role
            .antMatchers("/admin/**").hasRole("ADMIN") // Require ADMIN role
            .anyRequest().authenticated() // Other requests require authentication
            .and()
            .httpBasic() // Use basic authentication (or replace with JWT authentication)
            .and().build();
  }

}
