package org.launchcode.GatewaySEC.models;

public enum Who {

    BUSINESS ("Business"),
    INDIVIDUAL ("Individual");

    private final String name;

    Who(String name){ this.name = name;}

    public String getName(){ return name;}
}
