package com.example.projecttema2ps.viewmodel;

import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.UserDAO;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import com.example.projecttema2ps.viewmodel.command.commandsAdmin.*;
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

public class ViewModelAdmin implements Initializable {
    // tab 1
    @FXML
    public TableView usersTableView;
    @FXML
    public TableColumn idUserColumn;
    @FXML
    public TableColumn typeUserColumn;
    @FXML
    public TableColumn nameUserColumn;
    @FXML
    public TableColumn usernameUserColumn;
    @FXML
    public TableColumn passwordUserColumn;
    @FXML
    public TextField tfId;
    @FXML
    public TextField tfType;
    @FXML
    public TextField tfName;
    @FXML
    public TextField tfUsername;
    @FXML
    public TextField tfPassword;

//    public ICommand deleteUserCommand;
//    public ICommand addUserCommand;
//    public ICommand updateUserCommand;
//    public ICommand logoutCommand;

    // tab 2
    @FXML public TableColumn idDoctorColumn;
    @FXML public TableColumn typeDoctorColumn;
    @FXML public TableColumn nameDoctorColumn;
    @FXML public TableColumn startProgramColumn;
    @FXML public TableColumn endProgramColumn;
    @FXML public TableColumn usernameDoctorColumn;
    @FXML public TableColumn passwordDoctorColumn;
    @FXML public TextField tfIdDoctor;
    @FXML public TextField tfNameDoctor;
    @FXML public TextField tfUsernameDoctor;
    @FXML public TextField tfPasswordDoctor;
    @FXML public TextField tfTypeDoctor;
    @FXML public TextField tfStartProgram;
    @FXML public TextField tfEndProgram;
    @FXML public TableView doctorTableView;


    @FXML
    public void saveUserClick(ActionEvent actionEvent) throws SQLException, IOException {
        if(tfId.getText().isEmpty()) {
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
        if(tfIdDoctor.getText().isEmpty()) {
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // first tab
        UserDAO userDAO = new UserDAO();
        try {
            List<User> userList = userDAO.getUsers();
            idUserColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            typeUserColumn.setCellValueFactory(new PropertyValueFactory<>("Role"));
            nameUserColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            usernameUserColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            passwordUserColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

            for (User user : userList) {
                usersTableView.getItems().add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        usersTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            tfId.setText(Integer.toString(((User)newVal).getId()));
            tfType.setText(((User)newVal).getRole());
            tfName.setText(((User)newVal).getName());
            tfUsername.setText(((User)newVal).getUsername());
            tfPassword.setText(((User)newVal).getPassword());

        });

        // second tab
        DoctorDAO doctorDAO = new DoctorDAO();
        try {
            List<Doctor> doctorList = doctorDAO.getDoctors();
            idDoctorColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            typeDoctorColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
            nameDoctorColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            startProgramColumn.setCellValueFactory(new PropertyValueFactory<>("startProgram"));
            endProgramColumn.setCellValueFactory(new PropertyValueFactory<>("endProgram"));
            usernameDoctorColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
            passwordDoctorColumn.setCellValueFactory(new PropertyValueFactory<>("password"));

            for (Doctor doctor : doctorList) {
                doctorTableView.getItems().add(doctor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        doctorTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            tfIdDoctor.setText(Integer.toString(((Doctor)newVal).getId()));
            tfTypeDoctor.setText(((Doctor)newVal).getRole());
            tfNameDoctor.setText(((Doctor)newVal).getName());
            tfStartProgram.setText(((Doctor)newVal).getStartProgram());
            tfEndProgram.setText(((Doctor)newVal).getEndProgram());
            tfUsernameDoctor.setText(((Doctor)newVal).getUsername());
            tfPasswordDoctor.setText(((Doctor)newVal).getPassword());

        });
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
        this.tfName.setText(tfName);;
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
}
