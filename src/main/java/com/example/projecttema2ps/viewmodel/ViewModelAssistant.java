package com.example.projecttema2ps.viewmodel;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.viewmodel.command.commandsAssistant.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ViewModelAssistant {
    // first tab
    @FXML
    public TableView animalTableView;
    @FXML
    public TableColumn idColumn;
    @FXML
    public TableColumn animalColumn;
    @FXML
    public TableColumn speciesColumn;
    @FXML
    public TableColumn weightColumn;
    @FXML
    public TextField tfNewAnimalName;
    @FXML
    public TextField tfNewAnimalSpecies;
    @FXML
    public TextField tfNewAnimalWeight;
    @FXML
    public TextField tfUpdateName;
    @FXML
    public TextField tfUpdateSpecies;
    @FXML
    public TextField tfUpdateWeight;
    @FXML
    public TextField tfChooseAnimalId;
    @FXML
    public TextField tfNewId;
    @FXML
    public TableColumn idMedFileColumn;
    @FXML
    public TextField tfIdMedFile;

    // second tab
    @FXML
    public TableView filterAnimalTableView;
    @FXML
    public TableColumn idFilterColumn;
    @FXML
    public TableColumn animalFilterColumn;
    @FXML
    public TableColumn speciesFilterColumn;
    @FXML
    public TableColumn weightFilterColumn;
    @FXML
    public ComboBox comboBoxFilterDoctor;
    @FXML
    public ComboBox comboboxFilterDiagnose;
    @FXML
    public ComboBox comboboxFilterSpecies;

    // tab 4
    @FXML
    public PieChart speciesChart;
    @FXML
    public PieChart diagnoseChart;

    public ConsultDAO consultDAO = new ConsultDAO();
    public AnimalDAO animalDAO = new AnimalDAO();
    public DoctorDAO doctorDAO = new DoctorDAO();

    public void initialize() throws SQLException, IOException {
        animalTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            tfChooseAnimalId.setText(Integer.toString(((Animal) newVal).getId()));
            tfIdMedFile.setText(Integer.toString(((Animal) newVal).getIdMedFile()));
            tfUpdateName.setText(((Animal) newVal).getName());
            tfUpdateSpecies.setText(((Animal) newVal).getSpecies());
            tfUpdateWeight.setText(Double.toString(((Animal) newVal).getWeight()));
        });

        try {
            List<Consult> consultList = consultDAO.getConsults();
            List<Doctor> doctorList = doctorDAO.getDoctors();

            for (Doctor doctor : doctorList) {
                if (!comboBoxFilterDoctor.getItems().contains(doctor.getName())) {
                    comboBoxFilterDoctor.getItems().add(doctor.getName());
                }
            }
            for (Consult consult : consultList) {
                if (!comboboxFilterDiagnose.getItems().contains(consult.getDiagnose())) {
                    comboboxFilterDiagnose.getItems().add(consult.getDiagnose());
                }
            }
            comboBoxFilterDoctor.getItems().add(comboBoxFilterDoctor.getPromptText());
            comboboxFilterDiagnose.getItems().add(comboboxFilterDiagnose.getPromptText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            List<Animal> animalList = animalDAO.getAnimals();
            for (Animal animal : animalList) {
                if (!comboboxFilterSpecies.getItems().contains(animal.getSpecies()))
                    comboboxFilterSpecies.getItems().add(animal.getSpecies());
            }
            comboboxFilterSpecies.getItems().add(comboboxFilterSpecies.getPromptText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        refreshStatistics();

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

    ///////// getters ///////
    public String getTfEditAnimalName() {
        return tfUpdateName.getText();
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

}
