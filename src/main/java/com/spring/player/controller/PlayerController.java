package com.spring.player.controller;

import java.util.List;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;





//localhost:8080/
@RestController
@RequestMapping("/api")
//localhost:8080/spring-crm-rest/api/
public class PlayerController {


	private PlayerService playerService ;

	@Autowired
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
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


	//localhost:8080/api/players
	@GetMapping("/players")
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

			//localhost:8080/spring-crm-rest/api/players
			@DeleteMapping("/player")
			public void deletePlayer(@RequestParam int id){
				/*Player p = playerService.showPlayer(id);
				if (p == null) {
					throw new RuntimeException("player not found id :"+id);
				}
	*/
				playerService.deletePlayer(id);

			//	return "Successfully Deleted id :"+ id ;

			}



}
