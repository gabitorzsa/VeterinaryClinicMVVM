package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class UpdateAnimalCommand implements ICommand {
    ViewModelAssistant viewModelAssistant;

    public UpdateAnimalCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        AnimalDAO animalDAO = new AnimalDAO();
        Animal animal = new Animal();
        animal.setId(Integer.parseInt(viewModelAssistant.getTfChooseIdAnimal()));
        if(!viewModelAssistant.getTfEditAnimalName().isEmpty())
            animal.setName(viewModelAssistant.getTfEditAnimalName());
        else animal.setName(animalDAO.getAnimal(animal.getId()).getName());

        if(!viewModelAssistant.getTfEditSpecies().isEmpty())
            animal.setSpecies(viewModelAssistant.getTfEditSpecies());
        else animal.setSpecies(animalDAO.getAnimal(animal.getId()).getSpecies());

        if(!viewModelAssistant.getTfEditWeight().isEmpty())
            animal.setWeight(Double.parseDouble(viewModelAssistant.getTfEditWeight()));
        else animal.setWeight(animalDAO.getAnimal(animal.getId()).getWeight());
        animalDAO.updateAnimal(animal);
        viewModelAssistant.refreshStatistics();
    }
}
