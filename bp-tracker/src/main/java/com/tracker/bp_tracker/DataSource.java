package com.tracker.bp_tracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tracker.bp_tracker.user.User;
import com.tracker.bp_tracker.user.UserProfile;

public class DataSource {

    public static Connection connect() {
        String db_file = "jdbc:sqlite:resources/user-data.db";
        Connection connection = null;
        
        try {
            connection = DriverManager.getConnection(db_file);
            System.out.println("Connection to SQLite has been established.");
        } catch(SQLException e) {
            e.printStackTrace();
        } 

        return connection;
    }

    public static User getUser(String username) {
        // from db
        String sql = "SELECT * FROM users WHERE username = ?";
        User user = null;
        try (Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql)){

                statement.setString(1, username);
                try (ResultSet resultSet = statement.executeQuery()){
                    user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getInt("userDataId"));
                } 
        } catch (SQLException e) {
            e.printStackTrace();        
        }

        return user; 
    }

    public static UserProfile getUserProfile(int userDataId) {

        String sql = "SELECT * FROM userData WHERE userDataId = ?";
        UserProfile userProfile = null;
        try (Connection connection = connect();
            PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, userDataId);
                try(ResultSet resultSet = statement.executeQuery()){
                    userProfile = new UserProfile(
                        resultSet.getInt("id"),
                        resultSet.getString("privateData"),
                        resultSet.getString("medicalRecord")
                    );
                } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userProfile;

    }

    public static void main(String[] args) {
        // Test the connection
        connect();

    
    }
}
