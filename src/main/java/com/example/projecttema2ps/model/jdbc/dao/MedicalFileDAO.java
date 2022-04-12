package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.util.DatabaseConnection;
import com.example.projecttema2ps.model.MedicalFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalFileDAO implements IMedicalFileDAO {

    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public int addMedicalFile() throws SQLException {
        String query = "insert into medicalFile() VALUES ()";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public void deleteMedicalFile(int id) throws SQLException {
        String query = "delete from medicalFile where medicalFile_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        AnimalDAO animalDAO = new AnimalDAO();
        animalDAO.deleteAnimal(id);
    }

    @Override
    public void updateMedicalFile(MedicalFile medicalFile) throws SQLException {

    }

    @Override
    public MedicalFile getMedicalFile(int id) throws SQLException {
        String query = "select * from medicalFile where medicalFile_id= ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        MedicalFile medicalFile = new MedicalFile();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean check = false;
        while (resultSet.next()) {
            check = true;
            medicalFile.setId(resultSet.getInt("medicalFile_id"));
        }
        if (check == true) {
            return medicalFile;
        } else return null;

    }

    @Override
    public List<MedicalFile> getMedicalFiles() throws SQLException {
        String query = "select * from medicalFile";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<MedicalFile> medicalFileList = new ArrayList<>();

        while (resultSet.next()) {
            MedicalFile medicalFile = new MedicalFile();
            medicalFile.setId(resultSet.getInt("medicalFile_id"));
            medicalFileList.add(medicalFile);
        }
        return medicalFileList;
    }
}
