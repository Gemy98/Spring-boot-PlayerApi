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
	
	private PlayerDAO playerDao ;

	@Autowired
	public PlayerServiceImpl(PlayerDAO playerDao) {
		this.playerDao = playerDao;
	}

	public PlayerServiceImpl() {
	}

	
	@Override
	public List<Player> allPlayers() {

		
		return playerDao.findAll();
	}


	@Override
	public void savePlayer(Player player) {
		
		playerDao.save(player);
		
	}


	@Override
	public Player showPlayer(int id) {
		
		return 	playerDao.getById(id);
	}


	@Override
	public void deletePlayer(int id) {
	 playerDao.deleteById(id);
	}

}