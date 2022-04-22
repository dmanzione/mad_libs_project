package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.ConnectionManager;
import com.revature.models.User;
import com.revature.models.UserInterface;
import com.revature.models.UserModel;

public class UserDAO implements UserInterface {
	private Connection conn = ConnectionManager.getConnection();

	public ArrayList<UserModel> getAllUsers() {
		try {
			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery("select * from User");
			ArrayList<UserModel> users = new ArrayList<UserModel>();

			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");

				users.add(new UserModel(username, password));
			}
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addUser(UserModel newUser) {
		try {
			String query = "insert into Users (username, password) values (?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, newUser.username);
			pstmt.setString(2, newUser.password);

			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public UserModel getUser(String username) {
		try {

			String query = "SELECT * FROM Users WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				UserModel user = new UserModel();
				user.username = rs.getString("username");
				user.password = rs.getString("password");
				return user;
			} else {
				return null;
			}
		} catch (SQLException E) {
			E.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean usernameExists(String username) {
		try {

			String query = "SELECT * FROM Users WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException E) {
			E.printStackTrace();
			return false;
		}
	}

	@Override
	public void deleteUser(UserModel user) {
		try {
			String query = "DELETE FROM Users WHERE username = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, user.username);
			pstmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
