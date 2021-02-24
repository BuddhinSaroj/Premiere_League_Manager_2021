package entities;

import java.io.Serializable;
import java.time.LocalDate;

public class Match implements Serializable {

    private String homeTeam;
    private String awayTeam;
    private int homeTeamGoals;
    private int awayTeamGoals;
    private LocalDate dateOfMatchPlayed;

    @Override
    public String toString() {
        return "Match{" +
                "teamNumberOne=" + homeTeam +
                ", teamNumberTwo=" + awayTeam +
                ", teamNumberOneScore=" + homeTeamGoals +
                ", teamNumberTwoScore=" + awayTeamGoals +
                ", dateOfMatchPlayed=" + dateOfMatchPlayed +
                '}';
    }

    public Match() {
    }

    public Match(String homeTeam, String awayTeam, int homeTeamGoals, int awayTeamGoals, LocalDate dateOfMatchPlayed) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamGoals = homeTeamGoals;
        this.awayTeamGoals = awayTeamGoals;
        this.dateOfMatchPlayed = dateOfMatchPlayed;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeTeamGoals() {
        return homeTeamGoals;
    }

    public void setHomeTeamGoals(int homeTeamGoals) {
        this.homeTeamGoals = homeTeamGoals;
    }

    public int getAwayTeamGoals() {
        return awayTeamGoals;
    }

    public void setAwayTeamGoals(int awayTeamGoals) {
        this.awayTeamGoals = awayTeamGoals;
    }

    public LocalDate getDateOfMatchPlayed() {
        return dateOfMatchPlayed;
    }

    public void setDateOfMatchPlayed(LocalDate dateOfMatchPlayed) {
        this.dateOfMatchPlayed = dateOfMatchPlayed;
    }

    @Override
    public boolean equals(Object obj) { //to check the same matches already including in tha array
        Match matchObj = (Match)obj;
        if(this.homeTeam.equals(matchObj.homeTeam) && this.awayTeam.equals(matchObj.awayTeam)){
            return true;
        }
        return false;
    }

}

