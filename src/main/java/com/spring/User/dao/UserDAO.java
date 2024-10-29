package com.spring.User.dao;

import com.spring.User.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



//@RepositoryRestResource(path = "persons")
public interface UserDAO extends JpaRepository<User, Integer> {

    User findByName(String name);

    //we can make a list if the result will be more than one User :)
    User findByNameContaining(@RequestParam String name);
    List<User> findAllByName(String name);

    List<User> findAllByIsDeletedIsFalse();







    /*
    * http://localhost:8080/     then take the name of the class and
    * make the first character lowercase and add s at the end of
    * Get       http://localhost:8080/api/Users
    * Get       http://localhost:8080/api/Users/1
    * Post      http://localhost:8080/api/Users    body {object from User without id}
    * Put       http://localhost:8080/api/Users/id    body {object from User with id}
    * delete    http://localhost:8080/api/Users/id
    *
    *
    * Get       http://localhost:8080/api/Users/search/findByName?name=
    * Get       http://localhost:8080/api/Users/search/findByNameContaining?name=

     *

     *
    *
    * */


}
