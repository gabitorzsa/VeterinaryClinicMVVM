package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface IDoctorDAO {
    public int addDoctor(Doctor doctor) throws SQLException;
    public void deleteDoctor(int id) throws SQLException;
    public void updateDoctor(Doctor doctor) throws SQLException;
    public Doctor getDoctor(int id) throws SQLException;
    public List<Doctor> getDoctors() throws SQLException;
}
