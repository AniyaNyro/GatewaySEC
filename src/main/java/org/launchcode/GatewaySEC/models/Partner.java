package org.launchcode.GatewaySEC.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Partner {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private Boolean who;

    private int number;

    @NotNull
    private String email;

    @NotNull
    private String industry;

    @NotNull
    @Size(min=1, max= 100)
    private String description;

    @NotNull
    private Boolean isFunder;

    public Partner(String name, Boolean who, int number, String email, String industry, String description) {
        this.name = name;
        this.who = who;
        this.number = number;
        this.email = email;
        this.industry = industry;
        this.description = description;
        this.isFunder= false;
    }

    public Partner() {}

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

    public Boolean getWho() {
        return who;
    }

    public void setWho(Boolean who) {
        this.who = who;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFunder() {
        return isFunder;
    }

    public void setFunder(Boolean funder) {
        isFunder = funder;
    }
}
