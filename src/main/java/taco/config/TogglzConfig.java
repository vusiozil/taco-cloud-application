package taco.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;

@Configuration
public class TogglzConfig {

//  @Bean
//  public UserProvider userProvider(){
//    // Provide a default anonymous user with admin privileges
//    return () -> new SimpleFeatureUser("admin", true);
//  }
}
