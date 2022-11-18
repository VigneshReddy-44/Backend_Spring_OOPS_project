package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Gmart_Users")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "User_id")
    protected int id;
    @Column(name = "Name")
    protected String name;
    @Column(name="Mobile_Number")
    protected String mobileNumber;
    @Column(name = "Email")
    protected String email;
    @Column(name = "User_Category")
    protected  String type_of_user;
    @Column(name = "Password")
    protected String password;

    public String getType_of_user() {
        return type_of_user;
    }

    public User(String name, String mobileNumber, String email, String password, String type_of_user) {
//        this.id=UUID.randomUUID();
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password=password;
        this.type_of_user=type_of_user;
    }

//    public UUID getId() {
//        return id;
//    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void changePassword(String new_password){
        password=new_password;
    }
    public void removeUser(){};
}

