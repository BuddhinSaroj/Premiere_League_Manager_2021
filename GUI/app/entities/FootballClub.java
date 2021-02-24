package entities;

import java.io.Serializable;

public class FootballClub extends SportsClub implements Comparable<FootballClub>, Serializable {

    private int numberOfWins;
    private int numberOfDraws;
    private int numberOfDefeats;
    private int numberOfGoalsReceived;
    private int numberOfScored;
    private int numberOfPoints;
    private int numberOfMatchesPlayed;
    private int goalDif;

    @Override
    public String toString() {
        return "FootballClub{" +
                " Name = "+getNameOfTheClub()+
                ", numberOfWins = " + numberOfWins +
                ", numberOfDraws=" + numberOfDraws +
                ", numberOfDefeats=" + numberOfDefeats +
                ", numberOfGoalsReceived=" + numberOfGoalsReceived +
                ", numberOfScored=" + numberOfScored +
                ", numberOfPoints=" + numberOfPoints +
                ", numberOfMatchesPlayed=" + numberOfMatchesPlayed +
                ", goalDif=" + goalDif +
                '}';
    }

    public FootballClub() {    //no arg constructor
        super();
        this.numberOfWins = 0 ;
        this.numberOfDraws = 0 ;
        this.numberOfDefeats = 0 ;
        this.numberOfGoalsReceived = 0 ;
        this.numberOfScored = 0 ;
        this.numberOfPoints = 0 ;
        this.numberOfMatchesPlayed = 0 ;
        this.goalDif = 0;
    }

    public FootballClub(int numberOfWins, int numberOfDraws, int numberOfDefeats, int numberOfGoalsReceived, int numberOfScored, int numberOfPoints, int numberOfMatchesPlayed , int goalDif) {
        super();
        this.numberOfWins = numberOfWins;
        this.numberOfDraws = numberOfDraws;
        this.numberOfDefeats = numberOfDefeats;
        this.numberOfGoalsReceived = numberOfGoalsReceived;
        this.numberOfScored = numberOfScored;
        this.numberOfPoints = numberOfPoints;
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
        this.goalDif = goalDif;
    }

    public int getNumberOfWins() {
        return numberOfWins;
    }

    public void setNumberOfWins(int numberOfWins) {
        this.numberOfWins = numberOfWins;
    }

    public int getNumberOfDraws() {
        return numberOfDraws;
    }

    public void setNumberOfDraws(int numberOfDraws) {
        this.numberOfDraws = numberOfDraws;
    }

    public int getNumberOfDefeats() {
        return numberOfDefeats;
    }

    public void setNumberOfDefeats(int numberOfDefeats) {
        this.numberOfDefeats = numberOfDefeats;
    }

    public int getNumberOfGoalsReceived() {
        return numberOfGoalsReceived;
    }

    public void setNumberOfGoalsReceived(int numberOfGoalsReceived) {
        this.numberOfGoalsReceived = numberOfGoalsReceived;
    }

    public int getNumberOfScored() {
        return numberOfScored;
    }

    public void setNumberOfScored(int numberOfScored) {
        this.numberOfScored = numberOfScored;
    }

    public int getNumberOfPoints() {
        return numberOfPoints;
    }

    public void setNumberOfPoints(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    public int getNumberOfMatchesPlayed() {
        return numberOfMatchesPlayed;
    }

    public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
        this.numberOfMatchesPlayed = numberOfMatchesPlayed;
    }
    public int getGoalDif() {
        return goalDif;
    }

    public void setGoalDif(int goalDif) {
        this.goalDif = goalDif;
    }

    @Override
    public int compareTo(FootballClub obj) {  //compareTo method and declare comparable interface for FootballClub class
        if(numberOfPoints > obj.numberOfPoints)
            return 1;

        else if(numberOfPoints < obj.numberOfPoints){
            return -1;
        }
        else
        if(goalDif > obj.goalDif){
            return 1;
        }
        else {
            return -1;
        }


    }
}

