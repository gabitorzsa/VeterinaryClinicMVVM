package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.util.DatabaseConnection;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SaveXMLCommand implements ICommand {
    ViewModelAssistant viewModelAssistant;
    static Connection connection = DatabaseConnection.getConnection();

    public SaveXMLCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        AnimalDAO animalDAO = new AnimalDAO();
        List<Animal> animalList = new ArrayList<>();
        for (int i = 0; i < viewModelAssistant.getFilterAnimalTableView().getItems().size(); i++) {
            animalList.add((Animal) viewModelAssistant.getFilterAnimalTableView().getItems().get(i));
        }

//        for(Animal animal : animalList)
//            animalDAO.addFilteredAnimal(animal);
//
//        String query = "select * from animalFiltered";
//        PreparedStatement ps=connection.prepareStatement(query);
//        ResultSet rs=ps.executeQuery();
        try {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileOutputStream("Animals.xml"));
            xmlStreamWriter.writeStartDocument("1.0");
            xmlStreamWriter.writeStartElement("animals");
            for (Animal animal : animalList) {
                xmlStreamWriter.writeStartElement("animal");
                xmlStreamWriter.writeAttribute("id", Integer.toString(animal.getId()));
                xmlStreamWriter.writeAttribute("idMedFile", Integer.toString(animal.getIdMedFile()));

                xmlStreamWriter.writeStartElement("name");
                xmlStreamWriter.writeCharacters(animal.getName());
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement("species");
                xmlStreamWriter.writeCharacters(animal.getSpecies());
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeStartElement("weights");
                xmlStreamWriter.writeCharacters(String.valueOf(animal.getWeight()));
                xmlStreamWriter.writeEndElement();

                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.flush();
            xmlStreamWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("XML file created......");
    }
}
