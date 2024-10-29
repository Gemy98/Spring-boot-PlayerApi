package com.spring.User.service;

import com.spring.User.dao.UserDAO;
import com.spring.User.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserService(UserDAO UserDAO) {
        this.UserDao = UserDAO;
    }

    private UserDAO UserDao ;

    public User getUserByName(String name){
    return UserDao.findByName(name);
    }

    public List<User> getAllUsersByName(String name){

        List<User> Users = UserDao.findAllByName(name);
        return Users ;
    }


    public List<User> allUsers() {


        return UserDao.findAll();
    }


    public List<User> allActiveUsers() {

        return UserDao.findAllByIsDeletedIsFalse();
    }


    public void saveUser(User User) {
        UserDao.save(User);
    }

    public void saveEditedUser(User User) {
        UserDao.save(User);
    }

    public User showUser(int id) {

        return 	UserDao.findById(id).get();
    }

//    public void SoftDeleteUser(User User) {
//        int id = User.getId();
//        User.setIsDeleted(1); // Mark as deleted
//        UserDao.updateUserIsDeletedById(id, User.getIsDeleted());
//    }

    public void deleteUser(User User) {

        int id = User.getId();
        UserDao.deleteById(id);
    }



}
