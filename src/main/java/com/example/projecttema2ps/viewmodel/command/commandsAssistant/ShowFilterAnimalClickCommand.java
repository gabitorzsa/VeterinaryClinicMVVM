package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowFilterAnimalClickCommand implements ICommand {

    ViewModelAssistant viewModelAssistant;

    public ShowFilterAnimalClickCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        ConsultDAO consultDAO = new ConsultDAO();
        AnimalDAO animalDAO = new AnimalDAO();
        viewModelAssistant.filterAnimalTableView.getItems().clear();

        try {
            List<Consult> consultList = consultDAO.getConsults();
            List<Animal> animalList = animalDAO.getAnimals();
            int selectedDoctorItem = (int) viewModelAssistant.comboBoxFilterDoctor.getSelectionModel().getSelectedItem();
            String selectedDiagnoseItem = (String) viewModelAssistant.comboboxFilterDiagnose.getSelectionModel().getSelectedItem();
            String selectedSpeciesItem = (String) viewModelAssistant.comboboxFilterSpecies.getSelectionModel().getSelectedItem();


            if (!viewModelAssistant.comboboxFilterDiagnose.valueProperty().equals("Filter by diagnose")) {
                for (Animal animal : animalList) {
                    for (Consult consult : consultList) {
                        if (consult.getDiagnose().equals(selectedDiagnoseItem)) {
                            if (consult.getIdMedFile() == animal.getIdMedFile()) {
                                populateTable(animal);
                            }
                        }
                    }
                }
            }

            if (!viewModelAssistant.comboboxFilterSpecies.valueProperty().equals("Filter by species")) {
                for (Animal animal : animalList) {
                    if (animal.getSpecies().equals(selectedSpeciesItem)) {
                        populateTable(animal);
                    }
                }
            }

            if (!viewModelAssistant.comboBoxFilterDoctor.getSelectionModel().getSelectedItem().equals(0)) {
                for (Animal animal : animalList) {
                    for (Consult consult : consultList) {
                        if (consult.getIdDoctor() == selectedDoctorItem) {
                            if (consult.getIdMedFile() == animal.getIdMedFile()) {
                                populateTable(animal);
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        animalDAO.deleteAllFilteredAnimals();
    }

    public void populateTable(Animal animal) {
        viewModelAssistant.idFilterColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        viewModelAssistant.animalFilterColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        viewModelAssistant.speciesFilterColumn.setCellValueFactory(new PropertyValueFactory<>("species"));
        viewModelAssistant.weightFilterColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        if (!viewModelAssistant.filterAnimalTableView.getItems().contains(animal))
            viewModelAssistant.filterAnimalTableView.getItems().add(animal);
    }
}

