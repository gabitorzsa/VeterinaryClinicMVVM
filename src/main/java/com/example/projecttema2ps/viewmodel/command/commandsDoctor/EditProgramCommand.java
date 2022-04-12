package com.example.projecttema2ps.viewmodel.command.commandsDoctor;

import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.viewmodel.ViewModelDoctor;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class EditProgramCommand implements ICommand {

    private ViewModelDoctor viewModelDoctor;

    public EditProgramCommand(ViewModelDoctor viewModelDoctor) {
        this.viewModelDoctor = viewModelDoctor;
    }

    @Override
    public void execute() throws SQLException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        Doctor doctor = new Doctor();
        doctor.setId(Integer.parseInt(viewModelDoctor.getTfIdToUpdate()));
        if (!viewModelDoctor.getTfEditStartProgram().isEmpty())
            doctor.setStartProgram(viewModelDoctor.getTfEditStartProgram());
        else doctor.setStartProgram(doctorDAO.getDoctor(doctor.getId()).getStartProgram());
        if (!viewModelDoctor.getTfEditEndProgram().isEmpty())
            doctor.setEndProgram(viewModelDoctor.getTfEditEndProgram());
        else doctor.setEndProgram(doctorDAO.getDoctor(doctor.getId()).getEndProgram());
        doctor.setName(doctorDAO.getDoctor(doctor.getId()).getName());
        doctor.setRole(doctorDAO.getDoctor(doctor.getId()).getRole());
        doctor.setUsername(doctorDAO.getDoctor(doctor.getId()).getUsername());
        doctor.setPassword(doctorDAO.getDoctor(doctor.getId()).getPassword());
        doctorDAO.updateDoctor(doctor);
    }
}
