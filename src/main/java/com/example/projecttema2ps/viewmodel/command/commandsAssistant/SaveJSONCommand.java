package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.util.DatabaseConnection;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import com.fasterxml.jackson.databind.util.JSONPObject;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SaveJSONCommand implements ICommand {

    ViewModelAssistant viewModelAssistant;
    static Connection connection = DatabaseConnection.getConnection();

    public SaveJSONCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        AnimalDAO animalDAO = new AnimalDAO();
        List<Animal> animalList = new ArrayList<>();
        for(int i = 0; i < viewModelAssistant.getFilterAnimalTableView().getItems().size(); i++) {
            animalList.add((Animal) viewModelAssistant.getFilterAnimalTableView().getItems().get(i));
        }

        for(Animal animal : animalList)
            animalDAO.addFilteredAnimal(animal);

        Statement statement = connection.createStatement();
        String query = "select * from animalFiltered";
        ResultSet resultSet = statement.executeQuery(query);

        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        while(resultSet.next()) {
            JSONObject record = new JSONObject();
            //Inserting key-value pairs into the json object
            record.put("Animal_id", resultSet.getInt("animalFiltered_id"));
            record.put("MedFile_id", resultSet.getInt("medicalFileFiltered_id"));
            record.put("Animal_Name", resultSet.getString("animalFiltered_name"));
            record.put("Animal_Species", resultSet.getString("animalFiltered_species"));
            record.put("Animal_weight", resultSet.getDouble("animalFiltered_weight"));
            jsonArray.add(record);
        }
        jsonObject.put("Animals-data", jsonArray);
        try {
            FileWriter file = new FileWriter("Animals.json");
            file.write(jsonObject.toJSONString());
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("JSON file created......");
    }
}
