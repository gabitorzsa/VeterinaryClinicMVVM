package com.example.projecttema2ps.viewmodel.command.commandsDoctor;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.viewmodel.ViewModelDoctor;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class LogoutCommandDoctor implements ICommand {

    private ViewModelDoctor viewModelDoctor;

    public LogoutCommandDoctor(ViewModelDoctor viewModelDoctor) {
        this.viewModelDoctor = viewModelDoctor;
    }

    @Override
    public void execute() throws SQLException, IOException {
        Main main = new Main();
        main.changeScene("view/login-view.fxml", "Login");
    }
}
