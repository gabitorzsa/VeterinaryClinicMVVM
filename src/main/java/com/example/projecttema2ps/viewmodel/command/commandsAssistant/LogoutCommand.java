package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class LogoutCommand implements ICommand {

    ViewModelAssistant viewModelAssistant;

    public LogoutCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        Main main = new Main();
        main.changeScene("view/login-view.fxml", "Login");
    }
}
