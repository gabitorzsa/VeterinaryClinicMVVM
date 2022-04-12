package com.example.projecttema2ps.viewmodel.command.commandsDoctor;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.viewmodel.ViewModelDoctor;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.scene.control.Alert;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ShowClickCommand implements ICommand {

    private ViewModelDoctor viewModelDoctor;

    public ShowClickCommand(ViewModelDoctor viewModelDoctor) {
        this.viewModelDoctor = viewModelDoctor;
    }

    @Override
    public void execute() throws SQLException, IOException {
        viewModelDoctor.getAnimalTable().getItems().clear();
        viewModelDoctor.getConsultsTable().getItems().clear();
        viewModelDoctor.setTfIdConsultToUpdate("");
        viewModelDoctor.setTfEditDiagnose("");
        viewModelDoctor.setTfEditSymptoms("");
        viewModelDoctor.setTfEditTreatment("");

        AnimalDAO animalDAO = new AnimalDAO();
        ConsultDAO consultDAO = new ConsultDAO();
        try {
            List<Animal> animalList = animalDAO.getAnimals();
            List<Consult> consultList = consultDAO.getConsults();
            int selectedItem = (Integer) viewModelDoctor.getComboBoxMedicalFiles().getSelectionModel().getSelectedItem();
            for (Animal animal : animalList) {
                if (animal.getIdMedFile() == selectedItem) {
                    viewModelDoctor.getAnimalIDColumn().setCellValueFactory(new PropertyValueFactory<>("id"));
                    viewModelDoctor.getAnimalNameColumn().setCellValueFactory(new PropertyValueFactory<>("name"));
                    viewModelDoctor.getAnimalSpeciesColumn().setCellValueFactory(new PropertyValueFactory<>("species"));
                    viewModelDoctor.getAnimalWeightColumn().setCellValueFactory(new PropertyValueFactory<>("weight"));
                    viewModelDoctor.getAnimalTable().getItems().add(animal);
                }
            }
            for (Consult consult : consultList) {
                if (consult.getIdMedFile() == selectedItem) {
                    viewModelDoctor.getConsultsIdColumn().setCellValueFactory(new PropertyValueFactory<>("id"));
                    viewModelDoctor.getConsultIdDocColumn().setCellValueFactory(new PropertyValueFactory<>("idDoctor"));
                    viewModelDoctor.getConsultTreatmentColumn().setCellValueFactory(new PropertyValueFactory<>("treatment"));
                    viewModelDoctor.getConsultDiagnoseColumn().setCellValueFactory(new PropertyValueFactory<>("diagnose"));
                    viewModelDoctor.getConsultSymptomsColumn().setCellValueFactory(new PropertyValueFactory<>("symptoms"));
                    viewModelDoctor.getConsultsTable().getItems().add(consult);
                }
            }
            } catch(SQLException e){
                e.printStackTrace();
            }

            viewModelDoctor.getConsultsTable().getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                viewModelDoctor.setTfIdConsultToUpdate(Integer.toString(((Consult) newVal).getId()));
                viewModelDoctor.setTfEditDiagnose(((Consult) newVal).getDiagnose());
                viewModelDoctor.setTfEditTreatment(((Consult) newVal).getTreatment());
                viewModelDoctor.setTfEditSymptoms(((Consult) newVal).getSymptoms());
            });

        }
    }
