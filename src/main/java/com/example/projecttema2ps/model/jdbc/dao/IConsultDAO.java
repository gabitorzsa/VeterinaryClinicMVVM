package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.MedicalFile;

import java.sql.SQLException;
import java.util.List;

public interface IConsultDAO {
    public int addConsult(Consult consult, MedicalFile medicalFile, Doctor doctor) throws SQLException;
    public void deleteConsult(int id) throws SQLException;
    public void updateConsult(Consult consult) throws SQLException;
    public Consult getConsult(int id) throws SQLException;
    public List<Consult> getConsults() throws SQLException;
}
