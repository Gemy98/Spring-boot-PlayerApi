package com.spring.player.controller;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//localhost:8080/api/
@RestController
//localhost:8080/api/C
@RequestMapping("/C")
public class PlayerController {


    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    PlayerService playerService ;


    //localhost:8080/C/getplayer
    @GetMapping("/getplayer")
    private Player getPlayer(@RequestParam String name){
        return playerService.getPlayerByName(name);
    }

    //localhost:8080/C/getallplayers
    @GetMapping("/getallplayers")
    private List<Player> getAllPlayers(@RequestParam String name){
        List<Player> players = new ArrayList<>();
        players = playerService.getAllPlayersByName(name);
        return players ;
    }

}
