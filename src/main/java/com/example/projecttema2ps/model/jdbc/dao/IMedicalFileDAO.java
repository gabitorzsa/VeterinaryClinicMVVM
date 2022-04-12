package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.MedicalFile;

import java.sql.SQLException;
import java.util.List;

public interface IMedicalFileDAO {
    public int addMedicalFile() throws SQLException;
    public void deleteMedicalFile(int id) throws SQLException;
    public void updateMedicalFile(MedicalFile medicalFile) throws SQLException;
    public MedicalFile getMedicalFile(int id) throws SQLException;
    public List<MedicalFile> getMedicalFiles() throws SQLException;
}
