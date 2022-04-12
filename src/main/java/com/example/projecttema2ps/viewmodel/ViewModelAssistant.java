package com.example.projecttema2ps.viewmodel;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.viewmodel.command.commandsAssistant.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;

public class ViewModelAssistant {
    // first tab
    @FXML
    private TableView animalTableView;
    @FXML
    private TableColumn idColumn;
    @FXML
    private TableColumn animalColumn;
    @FXML
    private TableColumn speciesColumn;
    @FXML
    private TableColumn weightColumn;
    @FXML
    private TextField tfNewAnimalName;
    @FXML
    private TextField tfNewAnimalSpecies;
    @FXML
    private TextField tfNewAnimalWeight;
    @FXML
    private TextField tfUpdateName;
    @FXML
    private TextField tfUpdateSpecies;
    @FXML
    private TextField tfUpdateWeight;
    @FXML
    private TextField tfChooseAnimalId;
    @FXML
    private TextField tfNewId;
    @FXML
    private TableColumn idMedFileColumn;
    @FXML
    private TextField tfIdMedFile;

    // second tab
    @FXML
    private TableView filterAnimalTableView;
    @FXML
    private TableColumn idFilterColumn;
    @FXML
    private TableColumn animalFilterColumn;
    @FXML
    private TableColumn speciesFilterColumn;
    @FXML
    private TableColumn weightFilterColumn;
    @FXML
    private ComboBox comboBoxFilterDoctor;
    @FXML
    private ComboBox comboboxFilterDiagnose;
    @FXML
    private ComboBox comboboxFilterSpecies;

    // tab 3
    @FXML
    private ComboBox medFileAppointmentComboBox;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TableColumn idAppointmentColumn;
    @FXML
    private TableColumn animalAppointmentColumn;
    @FXML
    private TableColumn speciesAppointmentColumn;
    @FXML
    private TableColumn weightAppointmentColumn;
    @FXML
    private TableView animalAppointmentTableView;

    // tab 4
    @FXML
    private PieChart speciesChart;
    @FXML
    private PieChart diagnoseChart;
    @FXML
    private ComboBox doctorAppointmentComboBox;
    @FXML
    private TextField tfConsultHour;

    private ConsultDAO consultDAO = new ConsultDAO();
    private AnimalDAO animalDAO = new AnimalDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();
    private MedicalFileDAO medicalFileDAO = new MedicalFileDAO();

    public void initialize() throws SQLException, IOException {
        new InitializeAssistantCommand(this).execute();

    }

    public void refreshStatistics() throws SQLException, IOException {
        new RefreshStatisticsCommand(this).execute();
    }

    @FXML
    public void createNewMedFileClick(ActionEvent actionEvent) throws SQLException, IOException {
        new CreateNewMedicalFileCommand(this).execute();
    }

    @FXML
    public void addNewAnimalClick(ActionEvent actionEvent) throws SQLException, IOException {
        new AddNewAnimalCommand(this).execute();
    }

    @FXML
    public void refreshAnimalTableClick(ActionEvent actionEvent) throws SQLException, IOException {
        new RefreshAnimalTableCommand(this).execute();
    }

    @FXML
    public void updateAnimalClick(ActionEvent actionEvent) throws SQLException, IOException {
        new UpdateAnimalCommand(this).execute();
    }

    @FXML
    public void deleteAnimalClick(ActionEvent actionEvent) throws SQLException, IOException {
        new DeleteAnimalCommand(this).execute();
    }

    @FXML
    public void logoutClick(ActionEvent actionEvent) throws SQLException, IOException {
        new LogoutCommand(this).execute();
    }

    @FXML
    public void searchClick(ActionEvent actionEvent) throws SQLException, IOException {
        new ShowFilterAnimalClickCommand(this).execute();
    }

    @FXML
    public void saveCSV(ActionEvent actionEvent) throws SQLException, IOException {
        new SaveCSVCommand(this).execute();
    }

    @FXML
    public void saveJSON(ActionEvent actionEvent) throws SQLException, IOException {
        new SaveJSONCommand(this).execute();
    }

    @FXML
    public void saveXML(ActionEvent actionEvent) throws SQLException, IOException {
        new SaveXMLCommand(this).execute();
    }

    @FXML
    public void createNewConsultClick(ActionEvent actionEvent) throws SQLException, IOException {
        new CreateNewConsult(this).execute();
    }

    @FXML
    public void showAnimalClick(ActionEvent actionEvent) throws SQLException, IOException {
        new ShowAnimalCommand(this).execute();
    }

    public ConsultDAO getConsultDAO() {
        return consultDAO;
    }

    public AnimalDAO getAnimalDAO() {
        return animalDAO;
    }

    public DoctorDAO getDoctorDAO() {
        return doctorDAO;
    }

    public MedicalFileDAO getMedicalFileDAO() {
        return medicalFileDAO;
    }

    public String getTfEditAnimalName() {
        return tfUpdateName.getText();
    }

    public String getTfChooseHour() {
        return tfConsultHour.getText();
    }

    public String getTfNewId() {
        return tfNewId.getText();
    }

    public String getTfIdMedFile() {
        return tfIdMedFile.getText();
    }

    public String getTfEditSpecies() {
        return tfUpdateSpecies.getText();
    }

    public String getTfEditWeight() {
        return tfUpdateWeight.getText();
    }

    public String getTfChooseIdAnimal() {
        return tfChooseAnimalId.getText();
    }

    public String getTfNewAnimalName() {
        return tfNewAnimalName.getText();
    }

    public String getTfNewAnimalSpecies() {
        return tfNewAnimalSpecies.getText();
    }

    public String getTfNewAnimalWeight() {
        return tfNewAnimalWeight.getText();
    }

    public TableView getFilterAnimalTableView() {
        return filterAnimalTableView;
    }

    public void setTfNewAnimalName(String tfNewAnimalName) {
        this.tfNewAnimalName.setText(tfNewAnimalName);
    }

    public void setTfNewAnimalSpecies(String tfNewAnimalSpecies) {
        this.tfNewAnimalSpecies.setText(tfNewAnimalSpecies);
    }

    public void setTfNewAnimalWeight(String tfNewAnimalWeight) {
        this.tfNewAnimalWeight.setText(tfNewAnimalWeight);
    }

    public void setTfUpdateName(String tfUpdateName) {
        this.tfUpdateName.setText(tfUpdateName);
    }

    public void setTfUpdateSpecies(String tfUpdateSpecies) {
        this.tfUpdateSpecies.setText(tfUpdateSpecies);
    }

    public void setTfUpdateWeight(String tfUpdateWeight) {
        this.tfUpdateWeight.setText(tfUpdateWeight);
    }

    public void setTfChooseAnimalId(String tfChooseAnimalId) {
        this.tfChooseAnimalId.setText(tfChooseAnimalId);
    }

    public void setTfNewId(String tfNewId) {
        this.tfNewId.setText(tfNewId);
    }

    public void setTfIdMedFile(String tfIdMedFile) {
        this.tfIdMedFile.setText(tfIdMedFile);
    }

    public TableView getAnimalTableView() {
        return animalTableView;
    }

    public TableColumn getIdColumn() {
        return idColumn;
    }

    public TableColumn getAnimalColumn() {
        return animalColumn;
    }

    public TableColumn getSpeciesColumn() {
        return speciesColumn;
    }

    public TableColumn getWeightColumn() {
        return weightColumn;
    }

    public TableColumn getIdMedFileColumn() {
        return idMedFileColumn;
    }

    public TableColumn getIdFilterColumn() {
        return idFilterColumn;
    }

    public TableColumn getAnimalFilterColumn() {
        return animalFilterColumn;
    }

    public TableColumn getSpeciesFilterColumn() {
        return speciesFilterColumn;
    }

    public TableColumn getWeightFilterColumn() {
        return weightFilterColumn;
    }

    public ComboBox getComboBoxFilterDoctor() {
        return comboBoxFilterDoctor;
    }

    public ComboBox getComboboxFilterDiagnose() {
        return comboboxFilterDiagnose;
    }

    public ComboBox getComboboxFilterSpecies() {
        return comboboxFilterSpecies;
    }

    public ComboBox getMedFileAppointmentComboBox() {
        return medFileAppointmentComboBox;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public PieChart getSpeciesChart() {
        return speciesChart;
    }

    public PieChart getDiagnoseChart() {
        return diagnoseChart;
    }

    public ComboBox getDoctorAppointmentComboBox() {
        return doctorAppointmentComboBox;
    }

    public TableColumn getIdAppointmentColumn() {
        return idAppointmentColumn;
    }

    public TableColumn getAnimalAppointmentColumn() {
        return animalAppointmentColumn;
    }

    public TableColumn getSpeciesAppointmentColumn() {
        return speciesAppointmentColumn;
    }

    public TableColumn getWeightAppointmentColumn() {
        return weightAppointmentColumn;
    }

    public TableView getAnimalAppointmentTableView() {
        return animalAppointmentTableView;
    }

}
