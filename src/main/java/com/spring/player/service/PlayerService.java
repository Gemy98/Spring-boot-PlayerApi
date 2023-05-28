package com.spring.player.service;

import com.spring.player.dao.PlayerDAO;
import com.spring.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    @Autowired
    public PlayerService(PlayerDAO playerDAO) {
        this.playerDao = playerDAO;
    }

    private PlayerDAO playerDao ;

    public Player getPlayerByName(String name){
    return playerDao.findByName(name);
    }

    public List<Player> getAllPlayersByName(String name){

        List<Player> players = playerDao.findAllByName(name);
        return players ;
    }


    public List<Player> allPlayers() {


        return playerDao.findAll();
    }


    public void savePlayer(Player player) {
        playerDao.save(player);
    }

    public Player showPlayer(int id) {

        return 	playerDao.findById(id).get();
    }

    public void deletePlayer(Player player) {

        int id = player.getId();
        playerDao.deleteById(id);
    }



}
