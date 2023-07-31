package taco.controller.web;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import taco.domain.User;
import taco.helper.RegistrationForm;
import taco.repository.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class UserController {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder){
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @GetMapping
  public String getForm(Model model){
    model.addAttribute("user",new User());
    return "registerUser";
  }

  @PostMapping
  public String processRegistration(RegistrationForm registrationForm) {
    userRepository.save(registrationForm.toUser(passwordEncoder));
    return "redirect:/login";
  }

//  @PostMapping
//  public String saveUser(@Valid User user, RedirectAttributes redirectAttributes){
//
//    String password = passwordEncoder.encode(user.getPassword());
//    user.setPassword(password);
//
//    if(user==null){
//      redirectAttributes.addAttribute("error","registered successfully");
//      return "redirect:/registerForm";
//    }
//
//    userRepository.save(user);
//    redirectAttributes.addAttribute("message","registered successfully");
//
//    return "redirect:/login";
//  }

}
