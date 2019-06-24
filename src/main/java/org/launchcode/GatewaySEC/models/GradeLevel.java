package org.launchcode.GatewaySEC.models;

public enum GradeLevel {

    FRESHMAN ("Freshman"),
    SOPHMORE ("Sophmore"),
    JUNIOR ("Junior"),
    SENIOR ("Senior"),
    GRADUATED ("Graduated");

    private final String name;

    GradeLevel(String name){ this.name = name;}

    public String getName(){ return name;}
}
