package com.example.projecttema2ps.viewmodel;

import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.viewmodel.command.commandsDoctor.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

public class ViewModelDoctor {
    // first tab
    @FXML
    private TextField tfEditSymptoms;
    @FXML
    private TextField tfEditDiagnose;
    @FXML
    private TextField tfEditTreatment;
    @FXML
    private ComboBox comboBoxMedicalFiles;
    @FXML
    private TableView animalTable;
    @FXML
    private TableColumn animalIDColumn;
    @FXML
    private TableColumn animalNameColumn;
    @FXML
    private TableColumn animalSpeciesColumn;
    @FXML
    private TableColumn animalWeightColumn;
    @FXML
    private TableView consultsTable;
    @FXML
    private TableColumn consultsIdColumn;
    @FXML
    private TableColumn consultIdDocColumn;
    @FXML
    private TableColumn consultSymptomsColumn;
    @FXML
    private TableColumn consultDiagnoseColumn;
    @FXML
    private TableColumn consultTreatmentColumn;
    @FXML
    private TextField tfIdConsultToUpdate;

    // second tab
    @FXML
    private ComboBox comboBoxFilterDiagnose;
    @FXML
    private ComboBox comboBoxFilterTreatment;
    @FXML
    private TableView filterAnimalsTable;
    @FXML
    private TableColumn filterIdColumn;
    @FXML
    private TableColumn filterNameColumn;
    @FXML
    private TableColumn filterSpeciesColumn;
    @FXML
    private TableColumn filterWeightColumn;

    // third tab
    @FXML
    private TableView workProgramTableView;
    @FXML
    private TableColumn idWpColumn;
    @FXML
    private TableColumn nameWpColumn;
    @FXML
    private TableColumn startProgramWpColumn;
    @FXML
    private TableColumn endProgramWpColumn;
    @FXML
    private TextField tfEditStartProgram;
    @FXML
    private TextField tfIdToUpdate;
    @FXML
    private TextField tfEditEndProgram;
    @FXML
    private TableView consultsTableView;
    @FXML
    private TableColumn dateColumn;
    @FXML
    private TableColumn hourColumn;

    private MedicalFileDAO medicalFileDAO = new MedicalFileDAO();
    private ConsultDAO consultDAO = new ConsultDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();

    public void initialize() throws SQLException, IOException {
        new InitializeDoctorCommand(this).execute();
    }

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

    @FXML
    public void viewConsultsClick(ActionEvent actionEvent) throws SQLException, IOException {
        new ViewConsultsCommand(this).execute();
    }

    public MedicalFileDAO getMedicalFileDAO() {
        return medicalFileDAO;
    }

    public ConsultDAO getConsultDAO() {
        return consultDAO;
    }

    public DoctorDAO getDoctorDAO() {
        return doctorDAO;
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

    public TableView getFilterAnimalsTable() {
        return filterAnimalsTable;
    }

    public ComboBox getComboBoxFilterDiagnose() {
        return comboBoxFilterDiagnose;
    }

    public ComboBox getComboBoxFilterTreatment() {
        return comboBoxFilterTreatment;
    }

    public TableView getConsultsTable() {
        return consultsTable;
    }

    public TableColumn getDateColumn() {
        return dateColumn;
    }

    public TableColumn getHourColumn() {
        return hourColumn;
    }

    public void setTfEditSymptoms(String tfEditSymptoms) {
        this.tfEditSymptoms.setText(tfEditSymptoms);
    }

    public void setTfEditDiagnose(String tfEditDiagnose) {
        this.tfEditDiagnose.setText(tfEditDiagnose);
    }

    public void setTfEditTreatment(String tfEditTreatment) {
        this.tfEditTreatment.setText(tfEditTreatment);
    }

    public void setTfIdConsultToUpdate(String tfIdConsultToUpdate) {
        this.tfIdConsultToUpdate.setText(tfIdConsultToUpdate);
    }

    public void setTfEditStartProgram(String tfEditStartProgram) {
        this.tfEditStartProgram.setText(tfEditStartProgram);
    }

    public void setTfIdToUpdate(String tfIdToUpdate) {
        this.tfIdToUpdate.setText(tfIdToUpdate);
    }

    public void setTfEditEndProgram(String tfEditEndProgram) {
        this.tfEditEndProgram.setText(tfEditEndProgram);
    }

    public ComboBox getComboBoxMedicalFiles() {
        return comboBoxMedicalFiles;
    }


    public TableView getAnimalTable() {
        return animalTable;
    }

    public TableColumn getAnimalIDColumn() {
        return animalIDColumn;
    }

    public TableColumn getAnimalNameColumn() {
        return animalNameColumn;
    }

    public TableColumn getAnimalSpeciesColumn() {
        return animalSpeciesColumn;
    }

    public TableColumn getAnimalWeightColumn() {
        return animalWeightColumn;
    }

    public TableColumn getConsultsIdColumn() {
        return consultsIdColumn;
    }

    public TableColumn getConsultIdDocColumn() {
        return consultIdDocColumn;
    }

    public TableColumn getConsultSymptomsColumn() {
        return consultSymptomsColumn;
    }

    public TableColumn getConsultDiagnoseColumn() {
        return consultDiagnoseColumn;
    }

    public TableColumn getConsultTreatmentColumn() {
        return consultTreatmentColumn;
    }

    public TableColumn getFilterIdColumn() {
        return filterIdColumn;
    }

    public TableColumn getFilterNameColumn() {
        return filterNameColumn;
    }

    public TableColumn getFilterSpeciesColumn() {
        return filterSpeciesColumn;
    }

    public TableColumn getFilterWeightColumn() {
        return filterWeightColumn;
    }

    public TableView getWorkProgramTableView() {
        return workProgramTableView;
    }

    public TableColumn getIdWpColumn() {
        return idWpColumn;
    }

    public TableColumn getNameWpColumn() {
        return nameWpColumn;
    }

    public TableColumn getStartProgramWpColumn() {
        return startProgramWpColumn;
    }

    public TableColumn getEndProgramWpColumn() {
        return endProgramWpColumn;
    }

    public TableView getConsultsTableView() {
        return consultsTableView;
    }
}

