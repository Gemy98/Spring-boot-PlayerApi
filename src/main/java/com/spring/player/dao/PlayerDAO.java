package com.spring.player.dao;

import com.spring.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



//@RepositoryRestResource(path = "persons")
public interface PlayerDAO extends JpaRepository<Player, Integer> {

    Player findByName(@RequestParam String name);

    //we can make a list if the result will be more than one player :)
    Player findByNameContaining(@RequestParam String name);
    List<Player> findAllByName(@RequestParam String name);


    /*
    * http://localhost:8080/     then take the name of the class and
    * make the first character lowercase and add s at the end of
    * Get       http://localhost:8080/api/players
    * Get       http://localhost:8080/api/players/1
    * Post      http://localhost:8080/api/players    body {object from player without id}
    * Put       http://localhost:8080/api/players/id    body {object from player with id}
    * delete    http://localhost:8080/api/players/id
    *
    *
    * Get       http://localhost:8080/api/players/search/findByName?name=
    * Get       http://localhost:8080/api/players/search/findByNameContaining?name=

     *

     *
    *
    * */


}
