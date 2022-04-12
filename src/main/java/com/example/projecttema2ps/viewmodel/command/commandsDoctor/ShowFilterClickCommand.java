package com.example.projecttema2ps.viewmodel.command.commandsDoctor;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.viewmodel.ViewModelDoctor;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowFilterClickCommand implements ICommand {
    ViewModelDoctor viewModelDoctor;

    public ShowFilterClickCommand(ViewModelDoctor viewModelDoctor) {
        this.viewModelDoctor = viewModelDoctor;
    }

    @Override
    public void execute() throws SQLException, IOException {
        if(viewModelDoctor.getComboBoxFilterDiagnose().getSelectionModel().getSelectedItem().equals("Filter by diagnose")
                && viewModelDoctor.getComboBoxFilterTreatment().getSelectionModel().getSelectedItem().equals("Filter by treatment") ) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid operation");
            alert.setHeaderText("Empty table");
            alert.setContentText("Please select option to filter animals");
            alert.showAndWait();
            viewModelDoctor.filterAnimalsTable.getItems().clear();
            return;
        }
        ConsultDAO consultDAO = new ConsultDAO();
        AnimalDAO animalDAO = new AnimalDAO();
        viewModelDoctor.filterAnimalsTable.getItems().clear();
        try {
            List<Consult> consultList = consultDAO.getConsults();
            List<Animal> animalList = animalDAO.getAnimals();
                String selectedDiagnoseItem = (String) viewModelDoctor.comboBoxFilterDiagnose.getSelectionModel().getSelectedItem();
                for (Consult consult : consultList) {
                    if (consult.getDiagnose().equals(selectedDiagnoseItem))
                        for (Animal animal : animalList) {
                            if (animal.getIdMedFile() == consult.getIdMedFile()) {
                               populateTable(animal);
                            }
                        }
                }

                String selectedTreatmentItem = (String) viewModelDoctor.comboBoxFilterTreatment.getSelectionModel().getSelectedItem();
                for (Consult consult : consultList) {
                    if (consult.getTreatment().equals(selectedTreatmentItem))
                        for (Animal animal : animalList) {
                            if (animal.getIdMedFile() == consult.getIdMedFile()) {
                                populateTable(animal);
                            }
                        }
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populateTable(Animal animal) {
        viewModelDoctor.filterIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        viewModelDoctor.filterNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        viewModelDoctor.filterSpeciesColumn.setCellValueFactory(new PropertyValueFactory<>("species"));
        viewModelDoctor.filterWeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        if (!viewModelDoctor.filterAnimalsTable.getItems().contains(animal))
            viewModelDoctor.filterAnimalsTable.getItems().add(animal);
    }
}
