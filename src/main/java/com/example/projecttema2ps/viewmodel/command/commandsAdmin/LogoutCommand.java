package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class LogoutCommand implements ICommand {

    private ViewModelAdmin viewModelAdmin;

    public LogoutCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    @Override
    public void execute() throws SQLException, IOException {
        Main main = new Main();
        main.changeScene("view/login-view.fxml", "Login");
    }
}
