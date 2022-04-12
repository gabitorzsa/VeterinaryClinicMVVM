package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
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
        DoctorDAO doctorDAO = new DoctorDAO();
        viewModelAssistant.getFilterAnimalTableView().getItems().clear();

        try {
            List<Consult> consultList = consultDAO.getConsults();
            List<Animal> animalList = animalDAO.getAnimals();
            List<Doctor> doctorList = doctorDAO.getDoctors();
            String selectedDoctorItem = (String) viewModelAssistant.getComboBoxFilterDoctor().getSelectionModel().getSelectedItem();
            String selectedDiagnoseItem = (String) viewModelAssistant.getComboboxFilterDiagnose().getSelectionModel().getSelectedItem();
            String selectedSpeciesItem = (String) viewModelAssistant.getComboboxFilterSpecies().getSelectionModel().getSelectedItem();

            if (!viewModelAssistant.getComboboxFilterDiagnose().valueProperty().equals("Filter by diagnose")) {
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

            if (!viewModelAssistant.getComboboxFilterSpecies().valueProperty().equals("Filter by species")) {
                for (Animal animal : animalList) {
                    if (animal.getSpecies().equals(selectedSpeciesItem)) {
                        populateTable(animal);
                    }
                }
            }

            if (!viewModelAssistant.getComboBoxFilterDoctor().getSelectionModel().getSelectedItem().equals("Filter by doctor")) {
                for (Animal animal : animalList) {
                    for (Consult consult : consultList) {
                        for(Doctor doctor : doctorList) {
                            if (consult.getIdDoctor() == doctor.getId() && doctor.getName().equals(selectedDoctorItem)) {
                                if (consult.getIdMedFile() == animal.getIdMedFile()) {
                                    populateTable(animal);
                                }
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
        viewModelAssistant.getIdFilterColumn().setCellValueFactory(new PropertyValueFactory<>("id"));
        viewModelAssistant.getAnimalFilterColumn().setCellValueFactory(new PropertyValueFactory<>("name"));
        viewModelAssistant.getSpeciesFilterColumn().setCellValueFactory(new PropertyValueFactory<>("species"));
        viewModelAssistant.getWeightFilterColumn().setCellValueFactory(new PropertyValueFactory<>("weight"));
        if (!viewModelAssistant.getFilterAnimalTableView().getItems().contains(animal))
            viewModelAssistant.getFilterAnimalTableView().getItems().add(animal);
    }
}

