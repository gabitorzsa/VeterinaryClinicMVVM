package com.example.projecttema2ps.viewmodel;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.viewmodel.command.commandsAssistant.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

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

    public void setTfConsultHour(String tfConsultHour) {
        this.tfConsultHour.setText(tfConsultHour);
    }

    public TableView getAnimalTableView() {
        return animalTableView;
    }

    public void setAnimalTableView(TableView animalTableView) {
        this.animalTableView = animalTableView;
    }

    public TableColumn getIdColumn() {
        return idColumn;
    }

    public void setIdColumn(TableColumn idColumn) {
        this.idColumn = idColumn;
    }

    public TableColumn getAnimalColumn() {
        return animalColumn;
    }

    public void setAnimalColumn(TableColumn animalColumn) {
        this.animalColumn = animalColumn;
    }

    public TableColumn getSpeciesColumn() {
        return speciesColumn;
    }

    public void setSpeciesColumn(TableColumn speciesColumn) {
        this.speciesColumn = speciesColumn;
    }

    public TableColumn getWeightColumn() {
        return weightColumn;
    }

    public void setWeightColumn(TableColumn weightColumn) {
        this.weightColumn = weightColumn;
    }

    public TableColumn getIdMedFileColumn() {
        return idMedFileColumn;
    }

    public void setIdMedFileColumn(TableColumn idMedFileColumn) {
        this.idMedFileColumn = idMedFileColumn;
    }

    public void setFilterAnimalTableView(TableView filterAnimalTableView) {
        this.filterAnimalTableView = filterAnimalTableView;
    }

    public TableColumn getIdFilterColumn() {
        return idFilterColumn;
    }

    public void setIdFilterColumn(TableColumn idFilterColumn) {
        this.idFilterColumn = idFilterColumn;
    }

    public TableColumn getAnimalFilterColumn() {
        return animalFilterColumn;
    }

    public void setAnimalFilterColumn(TableColumn animalFilterColumn) {
        this.animalFilterColumn = animalFilterColumn;
    }

    public TableColumn getSpeciesFilterColumn() {
        return speciesFilterColumn;
    }

    public void setSpeciesFilterColumn(TableColumn speciesFilterColumn) {
        this.speciesFilterColumn = speciesFilterColumn;
    }

    public TableColumn getWeightFilterColumn() {
        return weightFilterColumn;
    }

    public void setWeightFilterColumn(TableColumn weightFilterColumn) {
        this.weightFilterColumn = weightFilterColumn;
    }

    public ComboBox getComboBoxFilterDoctor() {
        return comboBoxFilterDoctor;
    }

    public void setComboBoxFilterDoctor(ComboBox comboBoxFilterDoctor) {
        this.comboBoxFilterDoctor = comboBoxFilterDoctor;
    }

    public ComboBox getComboboxFilterDiagnose() {
        return comboboxFilterDiagnose;
    }

    public void setComboboxFilterDiagnose(ComboBox comboboxFilterDiagnose) {
        this.comboboxFilterDiagnose = comboboxFilterDiagnose;
    }

    public ComboBox getComboboxFilterSpecies() {
        return comboboxFilterSpecies;
    }

    public void setComboboxFilterSpecies(ComboBox comboboxFilterSpecies) {
        this.comboboxFilterSpecies = comboboxFilterSpecies;
    }

    public ComboBox getMedFileAppointmentComboBox() {
        return medFileAppointmentComboBox;
    }

    public void setMedFileAppointmentComboBox(ComboBox medFileAppointmentComboBox) {
        this.medFileAppointmentComboBox = medFileAppointmentComboBox;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }

    public PieChart getSpeciesChart() {
        return speciesChart;
    }

    public void setSpeciesChart(PieChart speciesChart) {
        this.speciesChart = speciesChart;
    }

    public PieChart getDiagnoseChart() {
        return diagnoseChart;
    }

    public void setDiagnoseChart(PieChart diagnoseChart) {
        this.diagnoseChart = diagnoseChart;
    }

    public ComboBox getDoctorAppointmentComboBox() {
        return doctorAppointmentComboBox;
    }

    public void setDoctorAppointmentComboBox(ComboBox doctorAppointmentComboBox) {
        this.doctorAppointmentComboBox = doctorAppointmentComboBox;
    }
}
