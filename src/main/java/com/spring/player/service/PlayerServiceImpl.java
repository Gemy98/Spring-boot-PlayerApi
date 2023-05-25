package com.spring.player.service;

import java.util.List;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.player.dao.PlayerDAO;
import com.spring.player.model.Player;



@Service
@Transactional
public class PlayerServiceImpl implements PlayerService {
	
	@Autowired
	private PlayerDAO playerDao ; 
	   
	
	public PlayerServiceImpl() {
	}

	
	@Override
	public List<Player> allPlayers() {

		
		return playerDao.getPlayers();
	}


	@Override
	public void savePlayer(Player player) {
		
		playerDao.addPlayers(player);
		
	}


	@Override
	public Player showPlayer(int id) {
		
		return 	playerDao.getPlayer(id);
	}


	@Override
	public void deletePlayer(Player player) {
	 playerDao.deletePlayer(player);
		
	}

}
