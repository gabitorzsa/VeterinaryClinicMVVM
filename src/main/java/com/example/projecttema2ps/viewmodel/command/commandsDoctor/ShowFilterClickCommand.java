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
        if(viewModelDoctor.getComboBoxFilterTreatment().valueProperty().equals("Filter by treatment")
                && viewModelDoctor.getComboBoxFilterDiagnose().valueProperty().equals("Filter by diagnose")
                && viewModelDoctor.getComboBoxFilterDiagnose().getSelectionModel().getSelectedItem().equals("Filter by diagnose")
                && viewModelDoctor.getComboBoxFilterTreatment().getSelectionModel().getSelectedItem().equals("Filter by treatment") ) {
            viewModelDoctor.getFilterAnimalsTable().getItems().clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Invalid operation");
            alert.setHeaderText("Empty table");
            alert.setContentText("Please select option to filter animals");
            alert.showAndWait();
            return;
        }
        ConsultDAO consultDAO = new ConsultDAO();
        AnimalDAO animalDAO = new AnimalDAO();
        viewModelDoctor.getFilterAnimalsTable().getItems().clear();
        try {
            List<Consult> consultList = consultDAO.getConsults();
            List<Animal> animalList = animalDAO.getAnimals();
                String selectedDiagnoseItem = (String) viewModelDoctor.getComboBoxFilterDiagnose().getSelectionModel().getSelectedItem();
                for (Consult consult : consultList) {
                    if (consult.getDiagnose().equals(selectedDiagnoseItem))
                        for (Animal animal : animalList) {
                            if (animal.getIdMedFile() == consult.getIdMedFile()) {
                               populateTable(animal);
                            }
                        }
                }

                String selectedTreatmentItem = (String) viewModelDoctor.getComboBoxFilterTreatment().getSelectionModel().getSelectedItem();
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
        viewModelDoctor.getFilterIdColumn().setCellValueFactory(new PropertyValueFactory<>("id"));
        viewModelDoctor.getFilterNameColumn().setCellValueFactory(new PropertyValueFactory<>("name"));
        viewModelDoctor.getFilterSpeciesColumn().setCellValueFactory(new PropertyValueFactory<>("species"));
        viewModelDoctor.getFilterWeightColumn().setCellValueFactory(new PropertyValueFactory<>("weight"));
        if (!viewModelDoctor.getFilterAnimalsTable().getItems().contains(animal))
            viewModelDoctor.getFilterAnimalsTable().getItems().add(animal);
    }
}
