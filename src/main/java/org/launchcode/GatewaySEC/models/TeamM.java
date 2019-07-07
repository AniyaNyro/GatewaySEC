package org.launchcode.GatewaySEC.models;

import org.hibernate.validator.constraints.Email;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class TeamM {
    @Id
    @GeneratedValue
    private int id;

    @NotNull(message = "Name can not be empty")
    private String name;

    @NotNull
    @Email(message = "Invalid Email")
    private String email;


    private Long number;

    @ManyToMany
    private List<SEO> seos;

    private Boolean admin;

    public TeamM(){}

    public TeamM(String name, String email, Long number) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.admin = false;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public List<SEO> getSeos() {
        return seos;
    }

    public void setSeos(List<SEO> seos) {
        this.seos = seos;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
