package com.spring.player.controller;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//localhost:8080/
@RestController
//localhost:8080/api/
@RequestMapping("/myapi")
public class PlayerController {


    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    PlayerService playerService ;


    //localhost:8080/api/getplayer
    @GetMapping("/getplayer")
    private Player getPlayer(@RequestParam String name){
        return playerService.getPlayerByName(name);
    }

    //localhost:8080/api/getallplayers
    @GetMapping("/getallplayers")
    private List<Player> getAllPlayers(@RequestParam String name){
        List<Player> players = new ArrayList<>();
        players = playerService.getAllPlayersByName(name);
        return players ;
    }


    //localhost:8080/api/players
    @GetMapping("/player")
    public Player player(@RequestParam int id){
        Player p = playerService.showPlayer(id);
        if (p == null) {
            throw new RuntimeException("player not found id :"+id);
        }


        return p;
    }


    //localhost:8080/api/myplayers
    @GetMapping("/myplayers")
    public List<Player> players(){

        return playerService.allPlayers()	;
    }

    //localhost:8080/api/players
    @PostMapping("/players")
    public String savePlayer(@RequestBody Player player) {

        playerService.savePlayer(player);
        return"Successfully added";
    }

    //localhost:8080/api/players
    @PutMapping("/players")
    public Player updatePlayer(@RequestBody Player player) {
        playerService.savePlayer(player);
        return player ;
    }


	/*
	//localhost:8080/api/players
			@GetMapping("/deleteplayer")
			public String deletePlayer(@RequestParam int id){
				Player p = playerService.showPlayer(id);
				if (p == null) {
					throw new StudentException("player not found id :"+id);
				}

				playerService.deletePlayer(p);

				return "Successfully Deleted id :"+ id ;

			}
		*/

    //localhost:8080/api/players
    @DeleteMapping("/player")
    public String deletePlayer(@RequestParam int id){
        Player p = playerService.showPlayer(id);
        if (p == null) {
            throw new RuntimeException("player not found id :"+id);
        }

        playerService.deletePlayer(p);

        return "Successfully Deleted id :"+ id ;

    }








}
