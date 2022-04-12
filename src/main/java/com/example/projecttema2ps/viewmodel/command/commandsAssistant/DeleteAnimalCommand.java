package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class DeleteAnimalCommand implements ICommand {

    ViewModelAssistant viewModelAssistant;

    public DeleteAnimalCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.deleteAnimal(Integer.parseInt(viewModelAssistant.getTfIdMedFile()));
        MedicalFileDAO medicalFileDAO = new MedicalFileDAO();
        medicalFileDAO.deleteMedicalFile(Integer.parseInt(viewModelAssistant.getTfIdMedFile()));
        viewModelAssistant.refreshStatistics();
    }
}
