package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;

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
        Main main = new Main();
        main.changeScene("view/admin-view.fxml", "Admin");
    }
}
