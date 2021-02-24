package entities;

import java.io.Serializable;

public class SportsClub implements Serializable {

    private String nameOfTheClub;
    private String locationOfTheClub;
    private String variousStatsOfTheClub;
    private int foundedYear;

    public SportsClub() {  //no arg constructor
        this.nameOfTheClub = null;
        this.locationOfTheClub = null;
        this.variousStatsOfTheClub = null;
    }

    public SportsClub(String nameOfTheClub, String locationOfTheClub, String variousStatsOfTheClub) { //arg constructor(but never used)
        this.nameOfTheClub = nameOfTheClub;
        this.locationOfTheClub = locationOfTheClub;
        this.variousStatsOfTheClub = variousStatsOfTheClub;
    }

    public String getNameOfTheClub() {
        return nameOfTheClub;
    }

    public void setNameOfTheClub(String nameOfTheClub) {
        this.nameOfTheClub = nameOfTheClub;
    }

    public String getLocationOfTheClub() {
        return locationOfTheClub;
    }

    public void setLocationOfTheClub(String locationOfTheClub) {
        this.locationOfTheClub = locationOfTheClub;
    }

    public String getVariousStatsOfTheClub() {
        return variousStatsOfTheClub;
    }

    public void setVariousStatsOfTheClub(String managerName) {
        this.variousStatsOfTheClub = managerName;
    }

    public int getFoundedYear() {
        return foundedYear;
    }

    public void setFoundedYear(int foundedYear) {
        this.foundedYear = foundedYear;
    }
}

