package com.example.projecttema2ps.model;

import java.util.Date;

public class Consult {
    private int id;
    private int idDoctor;
    private Date date;
    private String treatment;
    private String symptoms;
    private String diagnose;
    private int idMedFile;

    public Consult(int idDoctor, Date date, String treatment, String symptoms, String diagnose, MedicalFile mf) {
        this.idDoctor = idDoctor;
        this.date = date;
        this.treatment = treatment;
        this.symptoms = symptoms;
        this.diagnose = diagnose;
        this.idMedFile = mf.getId();
    }

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

    public Date getDate() {
        return date;
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

    @Override
    public String toString() {
        return "Consult{" +
                "idDoctor=" + idDoctor +
                ", date=" + date +
                ", treatment='" + treatment + '\'' +
                ", symptoms=" + symptoms +
                ", diagnose='" + diagnose + '\'' +
                '}';
    }
}
