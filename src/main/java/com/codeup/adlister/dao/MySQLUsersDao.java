package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config){
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

    public User findByUsername(String username){
        String selectStatement = "SELECT * FROM users WHERE username LIKE ?";
        String searchTermWithWildcards = "%" + username + "%";
        User result = null;

        try {
            PreparedStatement stmt = null;
            stmt = connection.prepareStatement(selectStatement);
            stmt.setString(1, searchTermWithWildcards);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            result = new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")
            );

            System.out.println("result = " + result);

            return result;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;

    }

    public Long insert(User user){
        String insertQuery = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            rs.next();
            return rs.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new user.", e);
        }
    }
}
