package com.example.projecttema2ps.viewmodel.command.commandsDoctor;

import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.viewmodel.ViewModelDoctor;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RefreshDoctorTableCommand implements ICommand {

    private ViewModelDoctor viewModelDoctor;

    public RefreshDoctorTableCommand(ViewModelDoctor viewModelDoctor) {
        this.viewModelDoctor = viewModelDoctor;
    }

    @Override
    public void execute() throws SQLException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        List<Doctor> doctorList = doctorDAO.getDoctors();
        viewModelDoctor.getWorkProgramTableView().getItems().clear();
        for (Doctor doctor : doctorList) {
            viewModelDoctor.getIdWpColumn().setCellValueFactory(new PropertyValueFactory<>("id"));
            viewModelDoctor.getNameWpColumn().setCellValueFactory(new PropertyValueFactory<>("name"));
            viewModelDoctor.getStartProgramWpColumn().setCellValueFactory(new PropertyValueFactory<>("startProgram"));
            viewModelDoctor.getEndProgramWpColumn().setCellValueFactory(new PropertyValueFactory<>("endProgram"));
            viewModelDoctor.getWorkProgramTableView().getItems().add(doctor);

            viewModelDoctor.setTfIdToUpdate("");
            viewModelDoctor.setTfEditEndProgram("");
            viewModelDoctor.setTfEditStartProgram("");
        }
    }
}
