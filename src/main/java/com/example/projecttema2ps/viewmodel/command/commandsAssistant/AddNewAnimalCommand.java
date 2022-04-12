package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class AddNewAnimalCommand implements ICommand {

    ViewModelAssistant viewModelAssistant;

    public AddNewAnimalCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        AnimalDAO animalDAO = new AnimalDAO();
        Animal newAnimal = new Animal();
        newAnimal.setIdMedFile(Integer.parseInt(viewModelAssistant.getTfNewId()));
        newAnimal.setName(viewModelAssistant.getTfNewAnimalName());
        newAnimal.setSpecies(viewModelAssistant.getTfNewAnimalSpecies());
        newAnimal.setWeight(Double.parseDouble(viewModelAssistant.getTfNewAnimalWeight()));
        animalDAO.addAnimal(newAnimal);
        viewModelAssistant.refreshStatistics();
    }
}
