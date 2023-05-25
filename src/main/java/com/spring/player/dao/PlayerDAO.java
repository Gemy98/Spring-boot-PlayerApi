package com.spring.player.dao;

import com.spring.player.model.Player;

import java.util.List;




public interface PlayerDAO {

	
	public List<Player> getPlayers();
	
	public void addPlayers(Player player);
	
	public Player getPlayer(int id);
	
	public void deletePlayer(Player player);
}
