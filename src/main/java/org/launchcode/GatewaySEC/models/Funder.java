package org.launchcode.GatewaySEC.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Funder {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String name;

    @NotNull
    private Who who;

    private Long number;


    private String email;


    private Boolean isPartner;

    public Funder() {
        this.isPartner = false;

    }

    public Funder(String name, Who who, Long number, String email) {
        this.name = name;
        this.who = who;
        this.number = number;
        this.email = email;

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

    public Boolean getPartner() {
        return isPartner;
    }

    public void setPartner(Boolean partner) {
        isPartner = partner;
    }
}
