package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public User findByUsername(String username) {
        try {
            String insert = "SELECT * FROM users WHERE user_name LIKE ? LIMIT 1";
            String usernameSearch = "%"+ username + "%";
            PreparedStatement stmt = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, usernameSearch);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                user = new User(
                        rs.getLong("id"),
                        rs.getString("user_name"),
                        rs.getString("email"),
                        rs.getString("password")
                );
            }
        } catch (SQLException e){
            throw new RuntimeException("Error finding a user by username.", e)
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Long insert(User user) {
        long key = -1L;
        try {
            String insert = "INSERT INTO users (user_name, email, password) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                key = rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
        return key;
    }
}
