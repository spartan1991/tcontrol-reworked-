package com.vcprojects.tcontrol.service;

import java.util.List;

import com.vcprojects.tcontrol.model.User;

public interface UserService {

    public List < User > getUsers();

    public void saveUser(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);

}
