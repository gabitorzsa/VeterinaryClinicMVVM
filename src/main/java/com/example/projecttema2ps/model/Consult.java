package com.example.projecttema2ps.model;

import java.sql.Date;

public class Consult {
    private int id;
    private int idDoctor;
    private Date date;
    private String treatment;
    private String symptoms;
    private String diagnose;
    private String hour;
    private int idMedFile;


    public Consult(int id, int idDoctor, String treatment, String symptoms, String diagnose, MedicalFile mf) {
        this.id = id;
        this.idDoctor = idDoctor;
        this.treatment = treatment;
        this.symptoms = symptoms;
        this.diagnose = diagnose;
        this.idMedFile = mf.getId();
    }

    public Consult() {}

    public Consult(int id, Doctor doctor,String treatment, String symptoms, String diagnose, MedicalFile mf) {
        this.id = id;
        this.idDoctor = doctor.getId();
        this.treatment = treatment;
        this.symptoms = symptoms;
        this.diagnose = diagnose;
        this.idMedFile = mf.getId();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMedFile() {
        return idMedFile;
    }

    public void setIdMedFile(int idMedFile) {
        this.idMedFile = idMedFile;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getDate() {
        String formatDateTime = date.toString();
        return formatDateTime;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnose() {
        return diagnose;
    }

    public void setDiagnose(String diagnose) {
        this.diagnose = diagnose;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Consult{" +
                "idDoctor=" + idDoctor +
                ", date=" + getDate() +
                ", hour=" + getHour() +
                ", treatment='" + treatment + '\'' +
                ", symptoms=" + symptoms +
                ", diagnose='" + diagnose + '\'' +
                '}';
    }
}
