package org.launchcode.GatewaySEC.models;

import javafx.beans.DefaultProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
@Entity
public class SEO {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String highName;


    @ManyToMany(mappedBy = "seos")
    private List<TeamM> teamMs;

    @OneToMany
    private List<Student> students;

    private Boolean approved;

    private String passKey;

    public SEO(){
        approved = false;
        passKey = "gatewayseo";

    }

    public SEO(String name, String highName) {
        this();
        this.name = name;
        this.highName = highName;
    }

    //Make getters and setter for your columns


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

    public String getHighName(){ return highName; }

    public void  setHighName(String highName){ this.highName = highName; }

    public int getNumStu() {
        return this.students.size();
    }

    public void addStudent(Student aStudent){ this.students.add(aStudent); }

    public List<TeamM> getTeamMs() { return teamMs; }

    public void setTeamMs(List<TeamM> teamMs) { this.teamMs = teamMs; }

    public List<Student> getStudents() { return students; }

    public void setStudents(List<Student> students) { this.students = students; }

    public Boolean getApproved() { return approved; }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }

    public void setPassKey(String passKey) { this.passKey = passKey; }
}


