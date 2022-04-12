package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.MedicalFile;
import com.example.projecttema2ps.model.jdbc.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultDAO implements IConsultDAO {

    static Connection connection = DatabaseConnection.getConnection();
    public static int index = 1;

    @Override
    public int addConsult(Consult consult, MedicalFile medicalFile, Doctor doctor) throws SQLException {
        String query = "insert into consult(consult_id, " + "consult_idDoctor, " + "consult_treatment, " + "consult_diagnose, " + "consult_symptoms, " + "medicalFile_id) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(index));
        preparedStatement.setString(2, String.valueOf(doctor.getId()));
        preparedStatement.setString(3, consult.getTreatment());
        preparedStatement.setString(4, consult.getDiagnose());
        preparedStatement.setString(5, consult.getSymptoms());
        preparedStatement.setString(6, String.valueOf(medicalFile.getId()));
        int n = preparedStatement.executeUpdate();
        index++;
        return n;
    }

    @Override
    public void deleteConsult(int id) throws SQLException {
        String query = "delete from consult where consult_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateConsult(Consult consult) throws SQLException {
        String query = "update consult set consult_treatment =?, " + "consult_symptoms =?, " +
                "consult_diagnose =? where consult_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, consult.getTreatment());
        preparedStatement.setString(2, consult.getSymptoms());
        preparedStatement.setString(3, consult.getDiagnose());
        preparedStatement.setString(4, String.valueOf(consult.getId()));
        preparedStatement.executeUpdate();
    }

    @Override
    public Consult getConsult(int id) throws SQLException {
        String query = "select * from consult where consult_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        Consult consult = new Consult();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            consult.setId(resultSet.getInt("consult_id"));
            consult.setIdDoctor(resultSet.getInt("consult_idDoctor"));
            consult.setDiagnose(resultSet.getString("consult_diagnose"));
            consult.setTreatment(resultSet.getString("consult_treatment"));
            consult.setSymptoms(resultSet.getString("consult_symptoms"));
            consult.setIdMedFile(resultSet.getInt("medicalFile_id"));
        }
        if (check == true) {
            return consult;
        } else return null;
    }

    @Override
    public List<Consult> getConsults() throws SQLException {
        String query = "select * from consult";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Consult> consultList = new ArrayList<>();

        while (resultSet.next()) {
            Consult consult = new Consult();
            consult.setId(resultSet.getInt("consult_id"));
            consult.setIdDoctor(resultSet.getInt("consult_idDoctor"));
            consult.setDiagnose(resultSet.getString("consult_diagnose"));
            consult.setTreatment(resultSet.getString("consult_treatment"));
            consult.setSymptoms(resultSet.getString("consult_symptoms"));
            consult.setIdMedFile(resultSet.getInt("medicalFile_id"));
            consultList.add(consult);
        }
        return consultList;
    }
}
