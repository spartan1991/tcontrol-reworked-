package com.vcprojects.tcontrol.dao;

import java.util.List;

import com.vcprojects.tcontrol.model.User;

public interface UserDAO {

    public List < User > getUsers();

    public void saveUser(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);

    User findByUsername(String username); // 03.20.2020
}
