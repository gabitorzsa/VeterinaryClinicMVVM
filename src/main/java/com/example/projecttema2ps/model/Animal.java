package com.example.projecttema2ps.model;

public class Animal {
    private int id;
    private String name;
    private String species;
    private double weight;
    private int idMedFile;

    public Animal(int id, String name, String species, double weight) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.weight = weight;
    }

    public Animal() {
    }

    public Animal(String name, String species, double weight, MedicalFile mf) {
        this.name = name;
        this.species = species;
        this.weight = weight;
        this.idMedFile = mf.getId();
    }

    public int getIdMedFile() {
        return idMedFile;
    }

    public void setIdMedFile(int idMedFile) {
        this.idMedFile = idMedFile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", idMedFile=" + idMedFile +
                '}';
    }
}

