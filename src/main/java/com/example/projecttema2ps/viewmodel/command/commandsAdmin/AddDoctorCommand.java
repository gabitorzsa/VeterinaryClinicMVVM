package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

public class AddDoctorCommand implements ICommand {

    private ViewModelAdmin viewModelAdmin;

    public AddDoctorCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    @Override
    public void execute() throws SQLException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        Doctor newDoctor = new Doctor();
        newDoctor.setUsername(viewModelAdmin.getTfDoctorUsername());
        newDoctor.setPassword(viewModelAdmin.getTfDoctorPassword());
        newDoctor.setRole(viewModelAdmin.getTfTypeDoctor());
        newDoctor.setName(viewModelAdmin.getTfDoctorName());
        newDoctor.setStartProgram("No info yet");
        newDoctor.setEndProgram("No info yet");
        doctorDAO.addDoctor(newDoctor);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("To see the updates made please press 'Refresh table' button");
        alert.showAndWait();
    }
}
