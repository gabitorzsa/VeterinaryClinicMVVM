package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class AddUserCommand implements ICommand {

    private ViewModelAdmin viewModelAdmin;

    public AddUserCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    @Override
    public void execute() throws IOException, SQLException {
        UserDAO userDAO = new UserDAO();
        User newUser = new User();
        newUser.setName(viewModelAdmin.getTfName());
        newUser.setRole(viewModelAdmin.getTfType());
        newUser.setUsername(viewModelAdmin.getTfUsername());
        newUser.setPassword(viewModelAdmin.getTfPassword());
        userDAO.addUser(newUser);
    }
}
