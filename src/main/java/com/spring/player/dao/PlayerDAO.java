package com.spring.player.dao;

import com.spring.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;



@RepositoryRestResource(path = "persons")
public interface PlayerDAO extends JpaRepository<Player, Integer> {


    /*
    * http://localhost:8080/     then take the name of the class and
    * make the first character lowercase and add s at the end of
    * Get       http://localhost:8080/players
    * Get       http://localhost:8080/players/1
    * Post      http://localhost:8080/players    body {object from player without id}
    * Put       http://localhost:8080/players/id    body {object from player with id}
    * delete    http://localhost:8080/players/id
    *
    * */


}
