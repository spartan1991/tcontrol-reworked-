package com.vcprojects.tcontrol.service;

import java.util.HashSet; // 03.20.2020
import java.util.List;
import java.util.Set;

import com.vcprojects.tcontrol.dao.RoleDAO; // 03.20.2020
import com.vcprojects.tcontrol.model.Role; // 03.20.2020
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder; // 03.20.2020
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vcprojects.tcontrol.dao.UserDAO;
import com.vcprojects.tcontrol.model.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO; // 03.20.2020

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public List < User > getUsers() {
        return userDAO.getUsers();
    }

    @Override
    @Transactional
    public void saveUser(User theUser) {
        theUser.setPassword(bCryptPasswordEncoder.encode(theUser.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleDAO.getOne(1L));
        theUser.setRoles(roles);
        userDAO.saveUser(theUser);
    }

    @Override
    @Transactional
    public User getUser(int theId) {
        return userDAO.getUser(theId);
    }

    @Override
    @Transactional
    public void deleteUser(int theId) {
        userDAO.deleteUser(theId);
    }

    @Override
    public User findByUsername(String username) {     // 03.20.2020
        return null;
    }
}