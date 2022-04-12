package com.example.projecttema2ps.model.jdbc.main;

import com.example.projecttema2ps.model.Consult;
import com.example.projecttema2ps.model.Doctor;
import com.example.projecttema2ps.model.jdbc.dao.AnimalDAO;
import com.example.projecttema2ps.model.jdbc.dao.ConsultDAO;
import com.example.projecttema2ps.model.jdbc.dao.DoctorDAO;
import com.example.projecttema2ps.model.jdbc.dao.MedicalFileDAO;
import com.example.projecttema2ps.model.Animal;
import com.example.projecttema2ps.model.MedicalFile;

import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        // users
//        User user = new User();
//        user.setName("Calin");
//        user.setRole("admin");
//        user.setUsername("calin");
//        user.setPassword("pass");
//        UserDAO userDAO = new UserDAO();
//
//        // add
//        userDAO.addUser(user);
//
//        // read user
//        User u = userDAO.getUser(1);
//        System.out.println(u.getId() + " " + u.getName() + " " + u.getRole() + " " + u.getUsername() + " " + u.getPassword());
//
//        // read all
//        List<User> list = userDAO.getUsers();
//        Stream stream = Stream.of(list);
//        stream.forEach(s -> System.out.println(s));
//
//        // update
//        User tempUser = userDAO.getUser(1);
//        tempUser.setUsername("gabit");
//        userDAO.updateUser(tempUser);
//
////         delete
//        userDAO.deleteUser(2);
        /// doctors
//        LocalTime start = LocalTime.of(12, 00, 00);
//        LocalTime end = LocalTime.of(15, 00, 00);
//        Doctor doctor = new Doctor();
//        doctor.setName("Cristi");
//        doctor.setRole("admin");
//        doctor.setStartProgram("08:00");
//        doctor.setEndProgram("15:00");
//        doctor.setUsername("cristi");
//        doctor.setPassword("pass");
//        DoctorDAO doctorDAO = new DoctorDAO();
//
//        // add
////        doctorDAO.addDoctor(doctor);
//
//        // read user
////        Doctor d = doctorDAO.getDoctor(2);
////        System.out.println(d.getId() + " " + d.getName() + " " + d.getRole() + " " + d.getStartProgram() + " " + d.getEndProgram() + " " + d.getUsername() + " " + d.getPassword() + "\n");
//
//        // read all
//        List<Doctor> list = doctorDAO.getDoctors();
//        Stream stream = Stream.of(list);
//        stream.forEach(s -> System.out.println(s));
//
//        // update
////        Doctor tempDoctor = doctorDAO.getDoctor(1);
////        tempDoctor.setUsername("calinh");
////        doctorDAO.updateDoctor(tempDoctor);
//
////         delete
//        doctorDAO.deleteDoctor(2);
//    }

        MedicalFile medicalFile = new MedicalFile();
        MedicalFileDAO medicalFileDAO = new MedicalFileDAO();
        AnimalDAO animalDAO = new AnimalDAO();

        // add
//        medicalFileDAO.addMedicalFile();
        MedicalFile mf = new MedicalFile();
//        mf = medicalFileDAO.getMedicalFile(2);
//        System.out.println(mf.getId());
        Animal animal = new Animal( "Bla", "hcusj", 10.0, mf);

//        animalDAO.addAnimal(animal, mf);

        Doctor doctor = new Doctor();
        doctor.setName("Cristi");
        doctor.setRole("admin");
        doctor.setStartProgram("08:00");
        doctor.setEndProgram("15:00");
        doctor.setUsername("cristi");
        doctor.setPassword("pass");
        DoctorDAO doctorDAO = new DoctorDAO();
//        doctorDAO.addDoctor(doctor);
        Consult consult = new Consult(1, doctorDAO.getDoctor(3).getId(), "bla", "bla", "bla", mf);
//        Consult consult2 = new Consult(id, 1, "blaa", "blaa", "blaa", mf);
        mf = medicalFileDAO.getMedicalFile(1);
        ConsultDAO consultDAO = new ConsultDAO();
//        consultDAO.addConsult(consult, mf, doctorDAO.getDoctor(3));
//        consultDAO.addConsult(consult2, mf);
//        consultDAO.deleteConsult(1);
//        consultDAO.updateConsult(consult);
//        System.out.println(consultDAO.getConsult(1));
        System.out.println(consultDAO.getConsults());




        // read medicalFile
//        MedicalFile m = medicalFileDAO.getMedicalFile(1);
//        System.out.println(m.getId());
//
//        // read all
//        List<User> list = userDAO.getUsers();
//        Stream stream = Stream.of(list);
//        stream.forEach(s -> System.out.println(s));
//
//        // update
//        User tempUser = userDAO.getUser(1);
//        tempUser.setUsername("gabit");
//        userDAO.updateUser(tempUser);
//
//         delete
//        medicalFileDAO.deleteMedicalFile(2);
        Animal tempAnimal = animalDAO.getAnimal(1);
        tempAnimal.setName("Rex");
        tempAnimal.setSpecies("Canin");
//        animalDAO.updateAnimal(tempAnimal);

//        System.out.println(animalDAO.getAnimals());
    }
}
