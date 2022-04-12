package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RefreshDoctorTableAdminCommand implements ICommand {
    private ViewModelAdmin viewModelAdmin;

    public RefreshDoctorTableAdminCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    @Override
    public void execute() throws SQLException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        List<Doctor> doctorList = doctorDAO.getDoctors();
        viewModelAdmin.getDoctorTableView().getItems().clear();
        for (Doctor doctor : doctorList) {
            viewModelAdmin.getIdDoctorColumn().setCellValueFactory(new PropertyValueFactory<>("id"));
            viewModelAdmin.getTypeDoctorColumn().setCellValueFactory(new PropertyValueFactory<>("role"));
            viewModelAdmin.getNameDoctorColumn().setCellValueFactory(new PropertyValueFactory<>("name"));
            viewModelAdmin.getStartProgramColumn().setCellValueFactory(new PropertyValueFactory<>("startProgram"));
            viewModelAdmin.getEndProgramColumn().setCellValueFactory(new PropertyValueFactory<>("endProgram"));
            viewModelAdmin.getUsernameDoctorColumn().setCellValueFactory(new PropertyValueFactory<>("username"));
            viewModelAdmin.getPasswordDoctorColumn().setCellValueFactory(new PropertyValueFactory<>("password"));
            viewModelAdmin.getDoctorTableView().getItems().add(doctor);

            viewModelAdmin.setTfIdDoctor("");
            viewModelAdmin.setTfNameDoctor("");
            viewModelAdmin.setTfStartProgram("No info yet");
            viewModelAdmin.setTfEndProgram("No info yet");
            viewModelAdmin.setTfUsernameDoctor("");
            viewModelAdmin.setTfPasswordDoctor("");
        }
    }
}
