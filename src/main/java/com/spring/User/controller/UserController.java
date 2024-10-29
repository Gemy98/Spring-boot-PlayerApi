package com.spring.User.controller;

import com.spring.User.model.User;
import com.spring.User.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// http://localhost:8080/
@Controller
public class UserController {

    @Autowired
    public UserController(UserService UserService) {
        this.UserService = UserService;
    }

    @Autowired
    private UserService UserService ;



    //http://localhost:8080/Users
    @GetMapping("/Users")
    public String getAllActiveUsers(Model model){
    model.addAttribute("Users",UserService.allActiveUsers());
    //return UserService.allUsers();
    return "home";
    }


    //http://localhost:8080/UsersAdmin
    @GetMapping("/UsersAdmin")
    public String getAllUsers(Model model){
        model.addAttribute("Users",UserService.allUsers());
        //return UserService.allUsers();
        return "home";
    }


    //http://localhost:8080/User-form
    @GetMapping("User-form")
    public String UserForm(Model model){
        model.addAttribute("User",new User());
        return "Userform";
    }


    @GetMapping("User-form/{pid}")
    public String UserFormE(@PathVariable int pid , Model model){
       // int id = Integer.parseInt(pid);
        model.addAttribute("User",UserService.showUser(pid));
        return "/Userform";
      //  return UserService.showUser(pid);
    }

    @GetMapping("/Remover/{id}")
    public String RemoveP(@PathVariable int id){
        User u = UserService.showUser(id);
        u.setIsDeleted(1);
        UserService.saveEditedUser(u);
        return "redirect:/Users";
    }

    @GetMapping("/Retriever/{id}")
    public String RetrieveP(@PathVariable int id){
        User u = UserService.showUser(id);
        u.setIsDeleted(0);
        UserService.saveEditedUser(u);
        return "redirect:/Users";
    }


    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("User") User User, RedirectAttributes redirectAttributes) {
        if (User.getName().equals("") || User.getAddress().equals("") || User.getPhone().equals("") || User.getNumber()==0 ){
            redirectAttributes.addFlashAttribute("errorMessage", "Please fill in all required fields.");
            return "redirect:/User-form";
        }
        else
        {
            UserService.saveUser(User);
            return "redirect:/Users";

        }
    }

}
