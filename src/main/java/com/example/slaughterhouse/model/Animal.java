package com.example.slaughterhouse.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Animal {

    private int weight;
    private long registrationNr;

    private String origin;
    private Date date;

    public Animal(@JsonProperty("registrationNr") int registrationNr,
                  @JsonProperty("weight") int weight, @JsonProperty("date") Date date,
                  @JsonProperty("origin") String origin)
    {
        this.registrationNr = registrationNr;
        this.weight = weight;
        this.date = date;
        this.origin = origin;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public long getRegistrationNr() {
        return registrationNr;
    }

    public void setRegistrationNr(long registrationNr) {
        this.registrationNr = registrationNr;
    }

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public String getOrigin() {return origin;}

    public void setOrigin(String origin){ this.origin=origin;}
}
