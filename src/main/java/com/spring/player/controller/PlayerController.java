package com.spring.player.controller;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// http://localhost:8080/
@Controller
public class PlayerController {

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    private PlayerService playerService ;



    //http://localhost:8080/players
    @GetMapping("/players")
    public String getAllPlayers(Model model){
    model.addAttribute("players",playerService.allPlayers());
    return "home";
    }

    //http://localhost:8080/player-form
    @GetMapping("player-form")
    public String playerForm(Model model){
        model.addAttribute("player",new Player());
        return "playerform";
    }

    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player") Player player){
        playerService.savePlayer(player);
        return "redirect:/players";
    }
}
