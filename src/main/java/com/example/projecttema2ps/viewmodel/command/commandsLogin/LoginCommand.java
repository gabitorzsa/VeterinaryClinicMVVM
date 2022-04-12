package com.example.projecttema2ps.viewmodel.command.commandsLogin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.viewmodel.ViewModelLogin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

public class LoginCommand implements ICommand {
    private ViewModelLogin viewModelLogin;
    private UserDAO userDAO;
    private DoctorDAO doctorDAO;

    public LoginCommand(ViewModelLogin viewModelLogin) {
        this.viewModelLogin = viewModelLogin;
        this.userDAO = new UserDAO();
        this.doctorDAO = new DoctorDAO();
    }

    @Override
    public void execute() throws SQLException, IOException {
        Main main = new Main();
        String username = viewModelLogin.getTfUsername().getText();
        String password = viewModelLogin.getTfPassword().getText();
        User user = userDAO.getUserByUsername(username);
        Doctor doctor = doctorDAO.getDoctorByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                if (user.getRole().equals("admin")) {
                    main.changeScene("view/admin-view.fxml", "Admin");
                } else main.changeScene("view/assistant-view.fxml", "Assistant");
            }
        }
        if (doctor != null) {
            if (doctor.getPassword().equals(password)) {
                main.changeScene("view/doctor-view.fxml", "Doctor");
            }
        }

        if(user == null && doctor == null) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Authentication error");
            alert.setHeaderText("Invalid or unregistered account");
            alert.setContentText("Please try again!");
            alert.showAndWait();
        }
    }
}
