package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public int addUser(User user) throws SQLException;
    public void deleteUser(int id) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public User getUser(int id) throws SQLException;
    public List<User> getUsers() throws SQLException;
}
