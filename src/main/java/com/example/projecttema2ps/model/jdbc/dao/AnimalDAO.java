package com.example.projecttema2ps.model.jdbc.dao;

import com.example.projecttema2ps.model.jdbc.util.DatabaseConnection;
import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.MedicalFile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnimalDAO implements IAnimalDAO {

    static Connection connection = DatabaseConnection.getConnection();

    @Override
    public void createTable(List<Animal> animalList) throws SQLException {
        String query = "create table animalFiltered ("
        + "animalFiltered_id int not null,"
        + "medicalFileFiltered_id int default null,"
        + "animalFiltered_name varchar(30) not null,"
        + "animalFiltered_species varchar(30) not null,"
        + "animalFiltered_weight decimal(4,2) not null,"
        + "primary key (animalFiltered_id))";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

    @Override
    public int addAnimal(Animal animal) throws SQLException {
        String query = "insert into animal(animal_name, " + "animal_species, " + "animal_weight, " + "medicalFile_id) values (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, animal.getName());
        preparedStatement.setString(2, animal.getSpecies());
        preparedStatement.setString(3, String.valueOf(animal.getWeight()));
        preparedStatement.setString(4, String.valueOf(animal.getIdMedFile()));
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public int addFilteredAnimal(Animal animal) throws SQLException {
        String query = "insert into animalFiltered(animalFiltered_id," + "animalFiltered_name, " + "animalFiltered_species, " + "animalFiltered_weight, " + "medicalFileFiltered_id) values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, String.valueOf(animal.getId()));
        preparedStatement.setString(2, animal.getName());
        preparedStatement.setString(3, animal.getSpecies());
        preparedStatement.setString(4, String.valueOf(animal.getWeight()));
        preparedStatement.setString(5, String.valueOf(animal.getIdMedFile()));
        int n = preparedStatement.executeUpdate();
        return n;
    }

    @Override
    public void deleteAnimal(int id) throws SQLException {
        String query = "delete from animal where medicalFile_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    @Override
    public void updateAnimal(Animal animal) throws SQLException {
        String query = "update animal set animal_name =?, " + "animal_species =?, " +
                "animal_weight =? where animal_id =?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, animal.getName());
        preparedStatement.setString(2, animal.getSpecies());
        preparedStatement.setString(3, String.valueOf(animal.getWeight()));
        preparedStatement.setString(4, String.valueOf(animal.getId()));
        preparedStatement.executeUpdate();
    }

    @Override
    public Animal getAnimal(int id) throws SQLException {
        String query = "select * from animal where animal_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        Animal animal = new Animal();
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean check = false;

        while (resultSet.next()) {
            check = true;
            animal.setId(resultSet.getInt("animal_id"));
            animal.setName(resultSet.getString("animal_name"));
            animal.setSpecies(resultSet.getString("animal_species"));
            animal.setWeight(resultSet.getDouble("animal_weight"));
            animal.setIdMedFile(resultSet.getInt("medicalFile_id"));

        }
        if (check == true) {
            return animal;
        } else return null;
    }

    @Override
    public List<Animal> getAnimals() throws SQLException {
        String query = "select * from animal";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Animal> animalList = new ArrayList<>();

        while (resultSet.next()) {
            Animal animal = new Animal();
            animal.setId(resultSet.getInt("animal_id"));
            animal.setName(resultSet.getString("animal_name"));
            animal.setSpecies(resultSet.getString("animal_species"));
            animal.setWeight(resultSet.getDouble("animal_weight"));
            animal.setIdMedFile(resultSet.getInt("medicalFile_id"));
            animalList.add(animal);
        }
        return animalList;
    }

    @Override
    public void deleteAllFilteredAnimals() throws SQLException {
        String query = "delete from animalFiltered";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.executeUpdate();
    }

}
