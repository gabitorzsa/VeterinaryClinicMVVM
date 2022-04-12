package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateUserCommand implements ICommand {

    private ViewModelAdmin viewModelAdmin;

    public UpdateUserCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    public void execute() throws IOException, SQLException {
        UserDAO userDAO = new UserDAO();
        User updatedUser = new User();
        updatedUser.setId(Integer.parseInt(viewModelAdmin.getTfId()));
        if(!viewModelAdmin.getTfName().isEmpty())
            updatedUser.setName(viewModelAdmin.getTfName());
        else updatedUser.setName(userDAO.getUser(updatedUser.getId()).getName());
        if(!viewModelAdmin.getTfType().isEmpty())
            updatedUser.setRole(viewModelAdmin.getTfType());
        else updatedUser.setRole(userDAO.getUser(updatedUser.getId()).getRole());
        if(!viewModelAdmin.getTfUsername().isEmpty())
            updatedUser.setUsername(viewModelAdmin.getTfUsername());
        else updatedUser.setUsername(userDAO.getUser(updatedUser.getId()).getUsername());
        if(!viewModelAdmin.getTfPassword().isEmpty())
            updatedUser.setPassword(viewModelAdmin.getTfPassword());
        else updatedUser.setPassword(userDAO.getUser(updatedUser.getId()).getPassword());
        userDAO.updateUser(updatedUser);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("To see the updates made please press 'Refresh table' button");
        alert.showAndWait();
    }
}
