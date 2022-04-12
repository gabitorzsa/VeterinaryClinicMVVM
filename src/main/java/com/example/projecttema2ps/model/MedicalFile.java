package com.example.projecttema2ps.model;

import java.util.ArrayList;
import java.util.List;

public class MedicalFile {
    private int id;
    private List<Consult> consultList;
    private Animal animal;

    public MedicalFile(int id, List<Consult> consultList, Animal animal) {
        this.id = id;
        this.consultList = consultList;
        this.animal = animal;
    }
    public MedicalFile() {
        this.consultList = getConsultList();
    }

    public void addConsult(Consult consult) {
        consultList.add(consult);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Consult> getConsultList() {
        return consultList;
    }

    public void setConsultList(List<Consult> consultList) {
        this.consultList = consultList;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    @Override
    public String toString() {
        return "MedicalFile{" +
                "id=" + id +
                ", consultList=" + consultList +
                ", animal=" + animal +
                '}';
    }
}
