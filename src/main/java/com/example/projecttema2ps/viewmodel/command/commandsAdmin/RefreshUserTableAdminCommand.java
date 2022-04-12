package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RefreshUserTableAdminCommand implements ICommand {
    private ViewModelAdmin viewModelAdmin;

    public RefreshUserTableAdminCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    @Override
    public void execute() throws SQLException, IOException {
        UserDAO userDAO = new UserDAO();
        List<User> userList = userDAO.getUsers();
        viewModelAdmin.usersTableView.getItems().clear();
        for (User user : userList) {
            viewModelAdmin.idUserColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            viewModelAdmin.typeUserColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
            viewModelAdmin.nameUserColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            viewModelAdmin.usernameUserColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            viewModelAdmin.passwordUserColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
            viewModelAdmin.usersTableView.getItems().add(user);

            viewModelAdmin.setTfId("");
            viewModelAdmin.setTfName("");
            viewModelAdmin.setTfType("");
            viewModelAdmin.setTfUsername("");
            viewModelAdmin.setTfPassword("");
        }
    }
}
