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
    private Who who;

    private Long number;

    private String email;

    @NotNull
    private String industry;

    @NotNull
    @Size(min=1, max= 100)
    private String description;

    private Boolean isFunder;

    private Boolean approved;


    public Partner(String name, Who who, Long number, String email, String industry, String description) {
        this.name = name;
        this.who = who;
        this.number = number;
        this.email = email;
        this.industry = industry;
        this.description = description;

    }

    public Partner() {
        this.isFunder= false;
        this.approved= false;

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

    public Who getWho() {
        return who;
    }

    public void setWho(Who who) {
        this.who = who;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
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

    public Boolean getApproved() { return approved; }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
