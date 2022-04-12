package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.MedicalFile;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CreateNewMedicalFileCommand implements ICommand {

    ViewModelAssistant viewModelAssistant;

    public CreateNewMedicalFileCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        MedicalFileDAO medicalFileDAO = new MedicalFileDAO();
        medicalFileDAO.addMedicalFile();
        int id;
        List<MedicalFile> medicalFileList = medicalFileDAO.getMedicalFiles();
        id = medicalFileList.get(medicalFileList.size()-1).getId();
        viewModelAssistant.tfNewId.setText(String.valueOf(id));
    }
}
