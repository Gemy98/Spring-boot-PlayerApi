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
        this.playerDAO = playerDAO;
    }

    private PlayerDAO playerDAO ;

    public Player getPlayerByName(String name){
    return playerDAO.findByName(name);
    }

    public List<Player> getAllPlayersByName(String name){

        List<Player> players = playerDAO.findAllByName(name);
        return players ;
    }

}
