package com.revature.models;

import java.util.ArrayList;

public interface UserInterface {

    public ArrayList<UserModel> getAllUsers();

    public void addUser(UserModel user);

    public void deleteUser(UserModel user);
    
    public boolean usernameExists(String username);
    
    public UserModel getUser(String username);
}