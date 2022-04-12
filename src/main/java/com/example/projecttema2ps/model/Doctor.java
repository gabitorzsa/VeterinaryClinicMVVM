package com.example.projecttema2ps.model;

import java.time.LocalTime;

public class Doctor extends Person {
    private int id;
    private String role;
    private String startProgram;
    private String endProgram;
    private String username;
    private String password;

    public Doctor() {}

    public Doctor(String name, int id, String role, String startProgram, String endProgram, String username, String password) {
        super(name);
        this.id = id;
        this.role = role;
        this.startProgram = startProgram;
        this.endProgram = endProgram;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStartProgram() {
        return startProgram;
    }

    public void setStartProgram(String startProgram) {
        this.startProgram = startProgram;
    }

    public String getEndProgram() {
        return endProgram;
    }

    public void setEndProgram(String endProgram) {
        this.endProgram = endProgram;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", startProgram=" + startProgram +
                ", endProgram=" + endProgram +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
