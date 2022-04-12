package com.example.projecttema2ps.viewmodel;

import com.example.projecttema2ps.model.*;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.viewmodel.command.commandsAdmin.LogoutCommand;
import com.example.projecttema2ps.viewmodel.command.commandsDoctor.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ViewModelDoctor {
    // first tab
    @FXML
    public TextField tfEditSymptoms;
    @FXML
    public TextField tfEditDiagnose;
    @FXML
    public TextField tfEditTreatment;
    @FXML
    public ComboBox comboBoxMedicalFiles;
    @FXML
    public TableView animalTable;
    @FXML
    public TableColumn animalIDColumn;
    @FXML
    public TableColumn animalNameColumn;
    @FXML
    public TableColumn animalSpeciesColumn;
    @FXML
    public TableColumn animalWeightColumn;
    @FXML
    public TableView consultsTable;
    @FXML
    public TableColumn consultsIdColumn;
    @FXML
    public TableColumn consultIdDocColumn;
    @FXML
    public TableColumn consultSymptomsColumn;
    @FXML
    public TableColumn consultDiagnoseColumn;
    @FXML
    public TableColumn consultTreatmentColumn;
    @FXML
    public TextField tfIdConsultToUpdate;

    // second tab
    @FXML
    public ComboBox comboBoxFilterDiagnose;
    @FXML
    public ComboBox comboBoxFilterTreatment;
    @FXML
    public TableView filterAnimalsTable;
    @FXML
    public TableColumn filterIdColumn;
    @FXML
    public TableColumn filterNameColumn;
    @FXML
    public TableColumn filterSpeciesColumn;
    @FXML
    public TableColumn filterWeightColumn;

    // third tab
    @FXML
    public TableView workProgramTableView;
    @FXML
    public TableColumn idWpColumn;
    @FXML
    public TableColumn nameWpColumn;
    @FXML
    public TableColumn startProgramWpColumn;
    @FXML
    public TableColumn endProgramWpColumn;
    @FXML
    public TableColumn consultsColumn;
    @FXML
    public TextField tfEditStartProgram;
    @FXML
    public TextField tfIdToUpdate;
    @FXML
    public TextField tfEditEndProgram;

    MedicalFileDAO medicalFileDAO = new MedicalFileDAO();
    AnimalDAO animalDAO = new AnimalDAO();
    ConsultDAO consultDAO = new ConsultDAO();
    DoctorDAO doctorDAO = new DoctorDAO();

    List<Animal> animalList = animalDAO.getAnimals();
    List<Consult> consultList = consultDAO.getConsults();

    public ViewModelDoctor() throws SQLException {
        // functii pt populare combobox + setOnAction Command
    }

    public void initialize() {
        try {
            List<MedicalFile> medicalFileList = medicalFileDAO.getMedicalFiles();
            for (MedicalFile medicalFile : medicalFileList) {
                comboBoxMedicalFiles.getItems().add(medicalFile.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            List<Consult> consultList = consultDAO.getConsults();
            for (Consult consult : consultList) {
                comboBoxFilterDiagnose.getItems().add(consult.getDiagnose());
                comboBoxFilterTreatment.getItems().add(consult.getTreatment());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


//        // third tab
//        try {
//            List<Doctor> doctorList = doctorDAO.getDoctors();
//            idWpColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
//            nameWpColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
//            startProgramWpColumn.setCellValueFactory(new PropertyValueFactory<>("startProgram"));
//            endProgramWpColumn.setCellValueFactory(new PropertyValueFactory<>("endProgram"));
////            consultsColumn.setCellValueFactory(new PropertyValueFactory<>("consults"));
//            for (Doctor doctor : doctorList) {
//                workProgramTableView.getItems().add(doctor);
//            }
//            workProgramTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
//                tfIdToUpdate.setText(Integer.toString(((Doctor)newVal).getId()));
//                tfEditStartProgram.setText(((Doctor)newVal).getStartProgram());
//                tfEditEndProgram.setText(((Doctor)newVal).getEndProgram());
//            });
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    @FXML
    public void showClick(ActionEvent actionEvent) throws SQLException, IOException {
        new ShowClickCommand(this).execute();
    }

    @FXML
    public void saveClick(ActionEvent actionEvent) throws SQLException, IOException {
        new SaveEditsMedicalFileCommand(this).execute();
    }

    @FXML
    public void logoutClick(ActionEvent actionEvent) throws SQLException, IOException {
        new LogoutCommandDoctor(this).execute();
    }

    @FXML
    public void refreshTableClick(ActionEvent actionEvent) throws SQLException, IOException {
        new RefreshConsultsTableCommand(this).execute();
    }

    @FXML
    public void ShowFilterClick(ActionEvent actionEvent) throws SQLException, IOException {
        new ShowFilterClickCommand(this).execute();
        comboBoxFilterTreatment.setPromptText("Filter by treatment");
        comboBoxFilterDiagnose.setPromptText("Filter by diagnose");
    }

    @FXML
    public void editProgramClick(ActionEvent actionEvent) throws SQLException, IOException {
        new EditProgramCommand(this).execute();
    }

    @FXML
    public void refreshWorkProgramTableClick(ActionEvent actionEvent) throws SQLException, IOException {
        new RefreshDoctorTableCommand(this).execute();
    }

    public String getTfEditSymptoms() {
        return tfEditSymptoms.getText();
    }

    public String getTfEditDiagnose() {
        return tfEditDiagnose.getText();
    }

    public String getTfEditTreatment() {
        return tfEditTreatment.getText();
    }

    public String getTfIdConsultToUpdate() {
        return tfIdConsultToUpdate.getText();
    }

    public String getTfIdToUpdate() {
        return tfIdToUpdate.getText();
    }

    public String getTfEditStartProgram() {
        return tfEditStartProgram.getText();
    }

    public String getTfEditEndProgram() {
        return tfEditEndProgram.getText();
    }
}

