package com.example.projecttema2ps.viewmodel.command.commandsDoctor;

import com.example.projecttema2ps.Main;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.viewmodel.ViewModelAdmin;
import com.example.projecttema2ps.viewmodel.ViewModelDoctor;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import java.io.IOException;
import java.sql.SQLException;

public class SaveEditsMedicalFileCommand implements ICommand {

    private ViewModelDoctor viewModelDoctor;

    public SaveEditsMedicalFileCommand(ViewModelDoctor viewModelDoctor) {
        this.viewModelDoctor = viewModelDoctor;
    }

    @Override
    public void execute() throws SQLException, IOException {
        ConsultDAO consultDAO = new ConsultDAO();
        Consult consult = new Consult();
        consult.setId(Integer.parseInt(viewModelDoctor.getTfIdConsultToUpdate()));
        if(!viewModelDoctor.getTfEditTreatment().isEmpty())
            consult.setTreatment(viewModelDoctor.getTfEditTreatment());
        else consult.setTreatment(consultDAO.getConsult(consult.getId()).getTreatment());
        if(!viewModelDoctor.getTfEditSymptoms().isEmpty())
            consult.setSymptoms(viewModelDoctor.getTfEditSymptoms());
        else consult.setSymptoms(consultDAO.getConsult(consult.getId()).getSymptoms());
        if(!viewModelDoctor.getTfEditDiagnose().isEmpty())
            consult.setDiagnose(viewModelDoctor.getTfEditDiagnose());
        else consult.setDiagnose(consultDAO.getConsult(consult.getId()).getDiagnose());
        consultDAO.updateConsult(consult);
    }
}
