package com.example.projecttema2ps.viewmodel.command.commandsAdmin;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.command.ICommand;

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
        Main main = new Main();
        main.changeScene("view/admin-view.fxml", "Admin");
    }
}
