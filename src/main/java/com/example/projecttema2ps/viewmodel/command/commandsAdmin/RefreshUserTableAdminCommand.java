package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;
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
        viewModelAdmin.getUsersTableView().getItems().clear();
        if(viewModelAdmin.getTfUsername().equals("")
                || viewModelAdmin.getTfPassword().equals("")
                || viewModelAdmin.getTfId().equals("")
                || viewModelAdmin.getTfType().equals("")
                || viewModelAdmin.getTfName().equals("")
        ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid operation");
            alert.setHeaderText("Empty fields");
            alert.setContentText("Please select/enter info into fields");
            alert.showAndWait();
        }
        for (User user : userList) {
            viewModelAdmin.getIdUserColumn().setCellValueFactory(new PropertyValueFactory<>("id"));
            viewModelAdmin.getTypeUserColumn().setCellValueFactory(new PropertyValueFactory<>("role"));
            viewModelAdmin.getNameUserColumn().setCellValueFactory(new PropertyValueFactory<>("name"));
            viewModelAdmin.getUsernameUserColumn().setCellValueFactory(new PropertyValueFactory<>("username"));
            viewModelAdmin.getPasswordUserColumn().setCellValueFactory(new PropertyValueFactory<>("password"));
            viewModelAdmin.getUsersTableView().getItems().add(user);

            viewModelAdmin.setTfId("");
            viewModelAdmin.setTfName("");
            viewModelAdmin.setTfType("");
            viewModelAdmin.setTfUsername("");
            viewModelAdmin.setTfPassword("");
        }
    }
}
