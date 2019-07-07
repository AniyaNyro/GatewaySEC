package org.launchcode.GatewaySEC.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String fName;

    @NotNull
    private String lName;

    private GradeLevel grade;

    @ManyToOne
    private SEO seo;

    public Student() { }

    public Student(String fName, String lName, GradeLevel grade, SEO seo) {
        this.fName = fName;
        this.lName = lName;
        this.grade = grade;
        this.seo = seo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public GradeLevel getGrade() {
        return grade;
    }

    public void setGrade(GradeLevel grade) {
        this.grade = grade;
    }

    public SEO getSeo() {
        return seo;
    }

    public void setSeo(SEO seo) {
        this.seo = seo;
    }
}
