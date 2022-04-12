package com.example.projecttema2ps.viewmodel.command.commandsDoctor;

import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.viewmodel.ViewModelDoctor;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RefreshConsultsTableCommand implements ICommand {

    private ViewModelDoctor viewModelDoctor;

    public RefreshConsultsTableCommand(ViewModelDoctor viewModelDoctor) {
        this.viewModelDoctor = viewModelDoctor;
    }

    @Override
    public void execute() throws SQLException, IOException {
        ConsultDAO consultDAO = new ConsultDAO();
        List<Consult> consultList = consultDAO.getConsults();
        viewModelDoctor.consultsTable.getItems().clear();
        int selectedItem = (Integer) viewModelDoctor.comboBoxMedicalFiles.getSelectionModel().getSelectedItem();
        for (Consult consult : consultList) {
            if (consult.getIdMedFile() == selectedItem) {
                viewModelDoctor.consultsIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                viewModelDoctor.consultIdDocColumn.setCellValueFactory(new PropertyValueFactory<>("idDoctor"));
                viewModelDoctor.consultTreatmentColumn.setCellValueFactory(new PropertyValueFactory<>("treatment"));
                viewModelDoctor.consultDiagnoseColumn.setCellValueFactory(new PropertyValueFactory<>("diagnose"));
                viewModelDoctor.consultSymptomsColumn.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
                viewModelDoctor.consultsTable.getItems().add(consult);
            }
        }
    }
}
