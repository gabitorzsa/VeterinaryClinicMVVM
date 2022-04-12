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
        viewModelAssistant.animalTableView.getItems().clear();
        for (Animal animal : animalList) {
            viewModelAssistant.idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            viewModelAssistant.idMedFileColumn.setCellValueFactory(new PropertyValueFactory<>("idMedFile"));
            viewModelAssistant.animalColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            viewModelAssistant.speciesColumn.setCellValueFactory(new PropertyValueFactory<>("species"));
            viewModelAssistant.weightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
            viewModelAssistant.animalTableView.getItems().add(animal);
        }
        viewModelAssistant.tfNewId.setText("New id");
        viewModelAssistant.tfNewAnimalName.setText("New animal name");
        viewModelAssistant.tfNewAnimalSpecies.setText("New animal species");
        viewModelAssistant.tfNewAnimalWeight.setText("New animal weight");

        viewModelAssistant.tfChooseAnimalId.setText("Id");
        viewModelAssistant.tfIdMedFile.setText("Id medical file");
        viewModelAssistant.tfUpdateName.setText("Edit name");
        viewModelAssistant.tfUpdateSpecies.setText("Edit species");
        viewModelAssistant.tfUpdateWeight.setText("Edit weight");
    }
}
