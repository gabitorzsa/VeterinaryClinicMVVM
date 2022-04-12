package com.example.projecttema2ps.viewmodel.command.commandsDoctor;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.viewmodel.ViewModelDoctor;
import com.example.projecttema2ps.viewmodel.command.ICommand;
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
        viewModelDoctor.animalTable.getItems().clear();
        viewModelDoctor.consultsTable.getItems().clear();
        viewModelDoctor.tfIdConsultToUpdate.setText("");
        viewModelDoctor.tfEditDiagnose.setText("");
        viewModelDoctor.tfEditTreatment.setText("");
        viewModelDoctor.tfEditSymptoms.setText("");

        AnimalDAO animalDAO = new AnimalDAO();
        ConsultDAO consultDAO = new ConsultDAO();
        try {
            List<Animal> animalList = animalDAO.getAnimals();
            List<Consult> consultList = consultDAO.getConsults();

            int selectedItem = (Integer) viewModelDoctor.comboBoxMedicalFiles.getSelectionModel().getSelectedItem();
            for (Animal animal : animalList) {
                if (animal.getIdMedFile() == selectedItem) {
                    viewModelDoctor.animalIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    viewModelDoctor.animalNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
                    viewModelDoctor.animalSpeciesColumn.setCellValueFactory(new PropertyValueFactory<>("species"));
                    viewModelDoctor.animalWeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
                    viewModelDoctor.animalTable.getItems().add(animal);
                }
            }
            for (Consult consult : consultList) {
                if (consult.getIdMedFile() == selectedItem) {
                    viewModelDoctor.consultsIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
                    viewModelDoctor.consultIdDocColumn.setCellValueFactory(new PropertyValueFactory<>("idDoctor"));
                    viewModelDoctor.consultTreatmentColumn.setCellValueFactory(new PropertyValueFactory<>("treatment"));
                    viewModelDoctor.consultDiagnoseColumn.setCellValueFactory(new PropertyValueFactory<>("diagnose"));
                    viewModelDoctor.consultSymptomsColumn.setCellValueFactory(new PropertyValueFactory<>("symptoms"));
                    viewModelDoctor.consultsTable.getItems().add(consult);
                }
            }
            } catch(SQLException e){
                e.printStackTrace();
            }

            viewModelDoctor.consultsTable.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
                viewModelDoctor.tfIdConsultToUpdate.setText(Integer.toString(((Consult) newVal).getId()));
                viewModelDoctor.tfEditDiagnose.setText(((Consult) newVal).getDiagnose());
                viewModelDoctor.tfEditTreatment.setText(((Consult) newVal).getTreatment());
                viewModelDoctor.tfEditSymptoms.setText(((Consult) newVal).getSymptoms());
            });

        }
    }
