package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.jdbc.util.DatabaseConnection;
import com.example.projecttema2ps.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public int addUser(User user) throws SQLException {
        String query = "insert into user(user_name," + "user_role, " + "user_username, " + "user_password) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getRole());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public void deleteUser(int id) throws SQLException {
        String query = "delete from user where user_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String query = "update user set user_name =?, " + "user_role =?, " +
                        "user_username =?, " + "user_password =? where user_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getRole());
        preparedStatement.setString(3, user.getUsername());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, String.valueOf(user.getId()));
        preparedStatement.executeUpdate();

    }

    @Override
    public User getUser(int id) throws SQLException {
        String query = "select * from user where user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        User user = new User();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean check = false;

        while(resultSet.next()) {
            check = true;
            user.setId(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("user_name"));
            user.setRole(resultSet.getString("user_role"));
            user.setUsername(resultSet.getString("user_username"));
            user.setPassword(resultSet.getString("user_password"));
        }
        if(check == true) {
            return user;
        } else return null;
    }

    public User getUserByUsername(String username) throws SQLException {
        List<User> userList = this.getUsers();
        for(User user : userList)
            if(user.getUsername().equals(username))
                return user;
        return null;
    }

    @Override
    public List<User> getUsers() throws SQLException {
        String query = "select * from user";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<User> userList = new ArrayList<>();

        while(resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("user_id"));
            user.setName(resultSet.getString("user_name"));
            user.setRole(resultSet.getString("user_role"));
            user.setUsername(resultSet.getString("user_username"));
            user.setPassword(resultSet.getString("user_password"));
            userList.add(user);
        }
        return userList;
    }
}
