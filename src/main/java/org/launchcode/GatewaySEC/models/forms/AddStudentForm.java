package org.launchcode.GatewaySEC.models.forms;

import org.launchcode.GatewaySEC.models.GradeLevel;
import org.launchcode.GatewaySEC.models.SEO;
import org.launchcode.GatewaySEC.models.Student;
import org.launchcode.GatewaySEC.models.data.SEODao;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddStudentForm {

    @NotNull
    private int seoId;

    @NotNull
    @Size(min = 1, max = 15, message = "Invalid first name.")
    private String fName;

    @NotNull
    @Size(min = 1, max = 15, message = "Invalid last name.")
    private String lName;

    @NotNull
    private GradeLevel grade;


    private Iterable<Student> students;

    private SEO seo;

    public AddStudentForm(){}

    public  AddStudentForm(Iterable<Student> students, SEO seo){

       this.students = students;
       this.seo = seo;
    }

    public int getSeoId(){ return  seoId; }

    public void setSeoId (int seoId){ this.seoId = seoId;}

    public String getfName() { return fName; }

    public void setfName(String fName) { this.fName = fName; }

    public String getlName() { return lName; }

    public void setlName(String lName) { this.lName = lName; }

    public GradeLevel getGrade() { return grade; }

    public void setGrade(GradeLevel grade) { this.grade = grade; }

    public Iterable<Student> getStudents(){ return students; }

    public SEO getSeo() { return seo; }


}
