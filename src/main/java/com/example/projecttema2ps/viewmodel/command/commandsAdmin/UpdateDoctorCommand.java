package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateDoctorCommand implements ICommand {

    private ViewModelAdmin viewModelAdmin;

    public UpdateDoctorCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    public void execute() throws SQLException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        Doctor updatedDoctor = new Doctor();
        updatedDoctor.setId(Integer.parseInt(viewModelAdmin.getTfDoctorId()));
        if (!viewModelAdmin.getTfDoctorName().isEmpty())
            updatedDoctor.setName(viewModelAdmin.getTfDoctorName());
        else updatedDoctor.setName(doctorDAO.getDoctor(updatedDoctor.getId()).getName());

        updatedDoctor.setRole(viewModelAdmin.getTfTypeDoctor());

        if (!viewModelAdmin.getTfDoctorUsername().isEmpty())
            updatedDoctor.setUsername(viewModelAdmin.getTfDoctorUsername());
        else updatedDoctor.setUsername(doctorDAO.getDoctor(updatedDoctor.getId()).getUsername());

        if (!viewModelAdmin.getTfDoctorPassword().isEmpty())
            updatedDoctor.setPassword(viewModelAdmin.getTfDoctorPassword());
        else updatedDoctor.setPassword(doctorDAO.getDoctor(updatedDoctor.getId()).getPassword());

        if (!viewModelAdmin.getTfStartProgram().isEmpty())
            updatedDoctor.setStartProgram(viewModelAdmin.getTfStartProgram());
        else updatedDoctor.setStartProgram(doctorDAO.getDoctor(updatedDoctor.getId()).getStartProgram());

        if (!viewModelAdmin.getTfEndProgram().isEmpty())
            updatedDoctor.setEndProgram(viewModelAdmin.getTfEndProgram());
        else updatedDoctor.setEndProgram(doctorDAO.getDoctor(updatedDoctor.getId()).getEndProgram());
        doctorDAO.updateDoctor(updatedDoctor);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("To see the updates made please press 'Refresh table' button");
        alert.showAndWait();
    }
}
