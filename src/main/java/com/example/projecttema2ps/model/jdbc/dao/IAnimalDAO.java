package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.MedicalFile;

import java.sql.SQLException;
import java.util.List;

public interface IAnimalDAO {
    public void createTable(List<Animal> animalList) throws SQLException;
    public int addAnimal(Animal animal) throws SQLException;
    public int addFilteredAnimal(Animal animal) throws SQLException;
    public void deleteAnimal(int id) throws SQLException;
    public void updateAnimal(Animal animal) throws SQLException;
    public Animal getAnimal(int id) throws SQLException;
    public List<Animal> getAnimals() throws SQLException;
    public void deleteAllFilteredAnimals() throws SQLException;
}
