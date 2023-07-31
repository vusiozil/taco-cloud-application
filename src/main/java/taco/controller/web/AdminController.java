package taco.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import taco.service.AdminService;

@Controller
@RequestMapping ("/admin")
public class AdminController {

  private final AdminService adminService;

  public AdminController(AdminService adminService){
    this.adminService = adminService;
  }

  @DeleteMapping("/deleteAllOrders")
  public String deleteAllOrders(){

    adminService.deleteAllOrders();

    return "redirect:/admin";
  }
}
