package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.util.DatabaseConnection;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;

import org.apache.poi.xssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class SaveCSVCommand implements ICommand {

    ViewModelAssistant viewModelAssistant;
    static Connection connection = DatabaseConnection.getConnection();

    public SaveCSVCommand(ViewModelAssistant viewModelAssistant) {
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

        String sql = "SELECT * FROM animalFiltered";

        Statement statement = connection.createStatement();

        ResultSet result = statement.executeQuery(sql);

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Animals");

        writeHeaderLine(sheet);

        writeDataLines(result, workbook, sheet);

        FileOutputStream outputStream = new FileOutputStream("Animals.xlsx");
        workbook.write(outputStream);
        workbook.close();

        statement.close();

        System.out.println("CSV file created......");
    }

    private void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Animal id");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Animal name");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Animal species");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Animal weight");

    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook, XSSFSheet sheet) throws SQLException {
        int rowCount = 1;

        while (result.next()) {
            int animalID = result.getInt("animalFiltered_id");
            String animalName = result.getString("animalFiltered_name");
            String animalSpecies = result.getString("animalFiltered_species");
            String animalWeight = result.getString("animalFiltered_weight");

            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(animalID);

            cell = row.createCell(columnCount++);
            cell.setCellValue(animalName);

            cell = row.createCell(columnCount++);
            cell.setCellValue(animalSpecies);

            cell = row.createCell(columnCount++);
            cell.setCellValue(animalWeight);
        }
    }
}
