package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.User;
import com.example.projecttema2ps.model.jdbc.util.DatabaseConnection;
import com.example.projecttema2ps.model.Doctor;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class DoctorDAO implements IDoctorDAO {

    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public int addDoctor(Doctor doctor) throws SQLException {
        String query = "insert into doctor(doctor_name, " + "doctor_role, " + "doctor_startProgram, " + "doctor_endProgram, " + "doctor_username, " + "doctor_password) VALUES (?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, doctor.getName());
        preparedStatement.setString(2, doctor.getRole());
        preparedStatement.setString(3, doctor.getStartProgram());
        preparedStatement.setString(4, doctor.getEndProgram());
        preparedStatement.setString(5, doctor.getUsername());
        preparedStatement.setString(6, doctor.getPassword());
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public void deleteDoctor(int id) throws SQLException {
        String query = "delete from doctor where doctor_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateDoctor(Doctor doctor) throws SQLException {
        String query = "update doctor set doctor_name =?, " + "doctor_role =?, " +
                "doctor_startProgram =?, " + "doctor_endProgram =?, " +
                "doctor_username =?, " + "doctor_password =? where doctor_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, doctor.getName());
        preparedStatement.setString(2, doctor.getRole());
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
//        preparedStatement.setTime(3, Time.valueOf(doctor.getStartProgram()));
//        preparedStatement.setTime(4, Time.valueOf(doctor.getEndProgram()));
        preparedStatement.setString(3, doctor.getStartProgram());
        preparedStatement.setString(4, doctor.getEndProgram());
        preparedStatement.setString(5, doctor.getUsername());
        preparedStatement.setString(6, doctor.getPassword());
        preparedStatement.setString(7, String.valueOf(doctor.getId()));
        preparedStatement.executeUpdate();
    }

    @Override
    public Doctor getDoctor(int id) throws SQLException {
        String query = "select * from doctor where doctor_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        Doctor doctor = new Doctor();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean check = false;

        while(resultSet.next()) {
            check = true;
            doctor.setId(resultSet.getInt("doctor_id"));
            doctor.setName(resultSet.getString("doctor_name"));
            doctor.setRole(resultSet.getString("doctor_role"));
            doctor.setStartProgram(resultSet.getString("doctor_startProgram"));
            doctor.setEndProgram(resultSet.getString("doctor_endProgram"));
            doctor.setUsername(resultSet.getString("doctor_username"));
            doctor.setPassword(resultSet.getString("doctor_password"));
        }
        if(check == true) {
            return doctor;
        } else return null;
    }

    @Override
    public List<Doctor> getDoctors() throws SQLException {
        String query = "select * from doctor";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Doctor> doctorList = new ArrayList<>();

        while(resultSet.next()) {
            Doctor doctor = new Doctor();
            doctor.setId(resultSet.getInt("doctor_id"));
            doctor.setName(resultSet.getString("doctor_name"));
            doctor.setRole(resultSet.getString("doctor_role"));
            doctor.setStartProgram(resultSet.getString("doctor_startProgram"));
            doctor.setEndProgram(resultSet.getString("doctor_endProgram"));
            doctor.setUsername(resultSet.getString("doctor_username"));
            doctor.setPassword(resultSet.getString("doctor_password"));
            doctorList.add(doctor);
        }
        return doctorList;
    }

    public Doctor getDoctorByUsername(String username) throws SQLException {
        List<Doctor> doctorList = this.getDoctors();
        for(Doctor doctor : doctorList)
            if(doctor.getUsername().equals(username))
                return doctor;
        return null;
    }
}
