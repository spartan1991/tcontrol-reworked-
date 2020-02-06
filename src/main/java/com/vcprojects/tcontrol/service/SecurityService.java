package com.vcprojects.tcontrol.service;

public interface SecurityService {

    String FindLoggedInUsername();
    void autoLogin(String username, String password);
}
