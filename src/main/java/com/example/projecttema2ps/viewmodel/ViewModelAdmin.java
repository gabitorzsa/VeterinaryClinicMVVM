package com.example.projecttema2ps.viewmodel;

import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import com.example.projecttema2ps.viewmodel.command.commandsAdmin.*;
import com.example.projecttema2ps.viewmodel.command.commandsDoctor.InitializeDoctorCommand;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class ViewModelAdmin {
    // tab 1
    @FXML
    private TableView usersTableView;
    @FXML
    private TableColumn idUserColumn;
    @FXML
    private TableColumn typeUserColumn;
    @FXML
    private TableColumn nameUserColumn;
    @FXML
    private TableColumn usernameUserColumn;
    @FXML
    private TableColumn passwordUserColumn;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfType;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfUsername;
    @FXML
    private TextField tfPassword;

    // tab 2
    @FXML
    private TableColumn idDoctorColumn;
    @FXML
    private TableColumn typeDoctorColumn;
    @FXML
    private TableColumn nameDoctorColumn;
    @FXML
    private TableColumn startProgramColumn;
    @FXML
    private TableColumn endProgramColumn;
    @FXML
    private TableColumn usernameDoctorColumn;
    @FXML
    private TableColumn passwordDoctorColumn;
    @FXML
    private TextField tfIdDoctor;
    @FXML
    private TextField tfNameDoctor;
    @FXML
    private TextField tfUsernameDoctor;
    @FXML
    private TextField tfPasswordDoctor;
    @FXML
    private TextField tfTypeDoctor;
    @FXML
    private TextField tfStartProgram;
    @FXML
    private TextField tfEndProgram;
    @FXML
    private TableView doctorTableView;

    private UserDAO userDAO = new UserDAO();
    private DoctorDAO doctorDAO = new DoctorDAO();


    public void initialize() throws SQLException, IOException {
        new InitializeAdminCommand(this).execute();
    }

    @FXML
    public void saveUserClick(ActionEvent actionEvent) throws SQLException, IOException {
        if (tfId.getText().isEmpty()) {
            new AddUserCommand(this).execute();
        } else {
            new UpdateUserCommand(this).execute();
        }
    }

    @FXML
    public void deleteUserClick(ActionEvent actionEvent) throws SQLException, IOException {
        new DeleteUserCommand(this).execute();
    }

    @FXML
    public void saveDoctorClick(ActionEvent actionEvent) throws SQLException, IOException {
        if (tfIdDoctor.getText().isEmpty()) {
            new AddDoctorCommand(this).execute();
        } else {
            new UpdateDoctorCommand(this).execute();
        }
    }

    @FXML
    public void deleteDoctorClick(ActionEvent actionEvent) throws SQLException, IOException {
        new DeleteDoctorCommand(this).execute();
    }

    @FXML
    public void logoutClick(ActionEvent actionEvent) throws SQLException, IOException {
        new LogoutCommand(this).execute();
    }

    @FXML
    public void refreshDoctorsTableClick(ActionEvent actionEvent) throws SQLException, IOException {
        new RefreshDoctorTableAdminCommand(this).execute();
    }

    @FXML
    public void refreshUsersTableClick(ActionEvent actionEvent) throws SQLException, IOException {
        new RefreshUserTableAdminCommand(this).execute();
    }

    public TextField getTfIdDoctor() {
        return tfIdDoctor;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public DoctorDAO getDoctorDAO() {
        return doctorDAO;
    }

    public String getTfId() {
        return tfId.getText();
    }

    public String getTfType() {
        return tfType.getText();
    }

    public String getTfName() {
        return tfName.getText();
    }

    public String getTfUsername() {
        return tfUsername.getText();
    }

    public String getTfPassword() {
        return tfPassword.getText();
    }

    public String getTfDoctorId() {
        return tfIdDoctor.getText();
    }

    public String getTfTypeDoctor() {
        return tfTypeDoctor.getText();
    }

    public String getTfDoctorName() {
        return tfNameDoctor.getText();
    }

    public String getTfDoctorUsername() {
        return tfUsernameDoctor.getText();
    }

    public String getTfDoctorPassword() {
        return tfPasswordDoctor.getText();
    }

    public String getTfStartProgram() {
        return tfStartProgram.getText();
    }

    public String getTfEndProgram() {
        return tfEndProgram.getText();
    }

    public void setTfId(String tfId) {
        this.tfId.setText(tfId);
    }

    public void setTfType(String tfType) {
        this.tfType.setText(tfType);
    }

    public void setTfName(String tfName) {
        this.tfName.setText(tfName);
        ;
    }

    public void setTfUsername(String tfUsername) {
        this.tfUsername.setText(tfUsername);
    }

    public void setTfPassword(String tfPassword) {
        this.tfPassword.setText(tfPassword);
    }

    public void setTfIdDoctor(String tfIdDoctor) {
        this.tfIdDoctor.setText(tfIdDoctor);
    }

    public void setTfTypeDoctor(String tfTypeDoctor) {

        this.tfIdDoctor.setText(tfTypeDoctor);
    }

    public void setTfNameDoctor(String tfNameDoctor) {
        this.tfNameDoctor.setText(tfNameDoctor);
    }

    public void setTfUsernameDoctor(String tfUsernameDoctor) {
        this.tfUsernameDoctor.setText(tfUsernameDoctor);
    }

    public void setTfPasswordDoctor(String tfPasswordDoctor) {
        this.tfPasswordDoctor.setText(tfPasswordDoctor);
    }

    public void setTfStartProgram(String tfStartProgram) {
        this.tfStartProgram.setText(tfStartProgram);
    }

    public void setTfEndProgram(String tfEndProgram) {
        this.tfEndProgram.setText(tfEndProgram);
    }

    public TableView getUsersTableView() {
        return usersTableView;
    }

    public TableColumn getIdUserColumn() {
        return idUserColumn;
    }

    public TableColumn getTypeUserColumn() {
        return typeUserColumn;
    }

    public TableColumn getNameUserColumn() {
        return nameUserColumn;
    }

    public TableColumn getUsernameUserColumn() {
        return usernameUserColumn;
    }

    public TableColumn getPasswordUserColumn() {
        return passwordUserColumn;
    }

    public TableColumn getIdDoctorColumn() {
        return idDoctorColumn;
    }

    public TableColumn getTypeDoctorColumn() {
        return typeDoctorColumn;
    }

    public TableColumn getNameDoctorColumn() {
        return nameDoctorColumn;
    }

    public TableColumn getStartProgramColumn() {
        return startProgramColumn;
    }

    public TableColumn getEndProgramColumn() {
        return endProgramColumn;
    }

    public TableColumn getUsernameDoctorColumn() {
        return usernameDoctorColumn;
    }

    public TableColumn getPasswordDoctorColumn() {
        return passwordDoctorColumn;
    }

    public TableView getDoctorTableView() {
        return doctorTableView;
    }
}
