package com.example.projecttema2ps.viewmodel.command.commandsAssistant;

import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.viewmodel.ViewModelAssistant;
import com.example.projecttema2ps.viewmodel.command.ICommand;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RefreshStatisticsCommand implements ICommand {
    ViewModelAssistant viewModelAssistant;

    public RefreshStatisticsCommand(ViewModelAssistant viewModelAssistant) {
        this.viewModelAssistant = viewModelAssistant;
    }

    @Override
    public void execute() throws SQLException, IOException {
        int canineCount = 0;
        int catlikeCount = 0;
        int rodentCount = 0;
        List<Animal> animalList = viewModelAssistant.getAnimalDAO().getAnimals();
        for (Animal animal : animalList) {
            if (animal.getSpecies().equals("Canine")) canineCount++;
            if (animal.getSpecies().equals("Catlike")) catlikeCount++;
            if(animal.getSpecies().equals("Rodent")) rodentCount++;
        }
        ObservableList<PieChart.Data> pieChartSpecies = FXCollections.observableArrayList(
                new PieChart.Data("Canine", canineCount),
                new PieChart.Data("Catlike", catlikeCount),
                new PieChart.Data("Rodent", rodentCount));
        viewModelAssistant.getSpeciesChart().setData(pieChartSpecies);
        viewModelAssistant.getSpeciesChart().setTitle("Species statistics");
        viewModelAssistant.getSpeciesChart().setClockwise(true);
        viewModelAssistant.getSpeciesChart().setLabelLineLength(10);
        viewModelAssistant.getSpeciesChart().setLabelsVisible(true);
        viewModelAssistant.getSpeciesChart().setStartAngle(360);

        int cancerCount = 0;
        int intoxicationCount = 0;
        int allergyCount = 0;
        int injuryCount = 0;
        List<Consult> consultList = viewModelAssistant.getConsultDAO().getConsults();
        for(Consult consult : consultList) {
            if(consult.getDiagnose().equals("intoxication")) intoxicationCount++;
            if(consult.getDiagnose().equals("cancer")) cancerCount++;
            if(consult.getDiagnose().equals("allergy")) allergyCount++;
            if(consult.getDiagnose().equals("injury")) injuryCount++;
        }

        ObservableList<PieChart.Data> pieChartDiagnose = FXCollections.observableArrayList(
                new PieChart.Data("Intoxication", intoxicationCount),
                new PieChart.Data("Cancer", cancerCount),
                new PieChart.Data("Allergy", allergyCount),
                new PieChart.Data("Injury", injuryCount));

        viewModelAssistant.getDiagnoseChart().setData(pieChartDiagnose);
        viewModelAssistant.getDiagnoseChart().setTitle("Diagnose statistics");
        viewModelAssistant.getDiagnoseChart().setClockwise(true);
        viewModelAssistant.getDiagnoseChart().setLabelLineLength(10);
        viewModelAssistant.getDiagnoseChart().setLabelsVisible(true);
        viewModelAssistant.getDiagnoseChart().setStartAngle(360);
    }
}
