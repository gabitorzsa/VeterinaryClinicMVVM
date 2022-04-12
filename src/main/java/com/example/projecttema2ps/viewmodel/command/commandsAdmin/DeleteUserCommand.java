package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteUserCommand implements ICommand {
    private ViewModelAdmin viewModelAdmin;

    public DeleteUserCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    @Override
    public void execute() throws SQLException, IOException {
        UserDAO userDAO = new UserDAO();
        userDAO.deleteUser(Integer.parseInt(viewModelAdmin.getTfId()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("To see the updates made please press 'Refresh table' button");
        alert.showAndWait();
    }
}
