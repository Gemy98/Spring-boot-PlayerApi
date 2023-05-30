package com.spring.player.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class TestController {

    @GetMapping("/profile")
    public String home(Model model){
        model.addAttribute("name","Gemy");
        return "home";
    }

}
