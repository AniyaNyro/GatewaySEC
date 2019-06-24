package org.launchcode.GatewaySEC.models;

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

    @NotNull
    private String name;

    @ManyToMany
    private List<SEO> seos;

    private Boolean admin;

    public TeamM(){}

    public TeamM(String name) {
        this.name = name;
    }

    //TODOS Make getters and setters for your columns
}
