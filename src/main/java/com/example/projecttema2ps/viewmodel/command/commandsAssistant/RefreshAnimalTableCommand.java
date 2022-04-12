package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RefreshAnimalTableCommand implements ICommand {
    ViewModelAssistant viewModelAssistant;

    public RefreshAnimalTableCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        AnimalDAO animalDAO = new AnimalDAO();
        List<Animal> animalList = animalDAO.getAnimals();
        viewModelAssistant.getAnimalTableView().getItems().clear();
        for (Animal animal : animalList) {
            viewModelAssistant.getIdColumn().setCellValueFactory(new PropertyValueFactory<>("id"));
            viewModelAssistant.getIdMedFileColumn().setCellValueFactory(new PropertyValueFactory<>("idMedFile"));
            viewModelAssistant.getAnimalColumn().setCellValueFactory(new PropertyValueFactory<>("name"));
            viewModelAssistant.getSpeciesColumn().setCellValueFactory(new PropertyValueFactory<>("species"));
            viewModelAssistant.getWeightColumn().setCellValueFactory(new PropertyValueFactory<>("weight"));
            viewModelAssistant.getAnimalTableView().getItems().add(animal);
        }
        viewModelAssistant.setTfNewId("");
        viewModelAssistant.setTfNewAnimalName("");
        viewModelAssistant.setTfNewAnimalSpecies("");
        viewModelAssistant.setTfNewAnimalWeight("");

        viewModelAssistant.setTfChooseAnimalId("");
        viewModelAssistant.setTfIdMedFile("");
        viewModelAssistant.setTfUpdateName("");
        viewModelAssistant.setTfUpdateSpecies("");
        viewModelAssistant.setTfUpdateWeight("");
    }
}
