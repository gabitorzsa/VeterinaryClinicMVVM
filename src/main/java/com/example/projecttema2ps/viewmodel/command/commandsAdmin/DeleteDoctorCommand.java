package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteDoctorCommand implements ICommand {

    private ViewModelAdmin viewModelAdmin;

    public DeleteDoctorCommand(ViewModelAdmin viewModelAdmin) {
        this.viewModelAdmin = viewModelAdmin;
    }

    @Override
    public void execute() throws SQLException, IOException {
        DoctorDAO doctorDAO = new DoctorDAO();
        doctorDAO.deleteDoctor(Integer.parseInt(viewModelAdmin.getTfDoctorId()));
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("");
        alert.setHeaderText("");
        alert.setContentText("To see the updates made please press 'Refresh table' button");
        alert.showAndWait();
    }
}
