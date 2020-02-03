package com.vcprojects.tcontrol.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "login")
    private String login;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "country")
    private String country;

    public User(){
    }

    public User(int id, String login, String email, String password, String country){
        this.id = id;
        this.login = login;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public User(String login, String email, String password, String country){
        this.login = login;
        this.email = email;
        this.password = password;
        this.country = country;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getLogin(){
        return login;
    }

    public void setLogin(String login){
        this.login = login;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    @Override
    public String toString(){
        return "User{" +
                "id = " + id +
                "login = " + login +
                "email = " + email +
                "password = " + password +
                "country = " + country +
                '}';
    }
}
