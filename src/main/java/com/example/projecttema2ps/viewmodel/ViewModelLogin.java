package com.example.projecttema2ps.viewmodel;

import com.example.projecttema2ps.viewmodel.command.commandsLogin.LoginCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class ViewModelLogin {
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;

    @FXML
    private void loginClick(ActionEvent event) throws SQLException, IOException {
        new LoginCommand(this).execute();
    }

    public TextField getTfUsername() {
        return tfUsername;
    }

    public TextField getTfPassword() {
        return tfPassword;
    }
}
