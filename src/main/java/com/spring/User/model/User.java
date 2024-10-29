package com.spring.User.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//lombok's usage (@Gettet / @Setter / allargs construcor and no args constrctor)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name ="Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_id")
    private int id;

    @Column(name = "User_name")
    private String name;

    @Column(name = "User_number")
    private int number;

    @Column(name = "User_address")
    private String address;


    @Column(name = "User_phone")
    private String phone;


    @Getter
    @Column(name = "isDeleted")
    private int isDeleted = 0;


    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}