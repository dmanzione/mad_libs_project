package com.revature.models;

public class UserModel {

    public String username;
    public String password;

    public UserModel(String username, String password) {

        this.username = username;
        this.password = password;
    }

    public UserModel() {
		
	}

	@Override
    public String toString() {
        return "UserModel [username=" + username + ", password=" + password + "]";
    }

}
