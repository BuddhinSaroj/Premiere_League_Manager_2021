package entities;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class MatchTest {

    @Test
    public void testToString() {
    }

    @Test
    public void getHomeTeam() {
        Match match = new Match();
        match.setHomeTeam("Barcelona");
        assertEquals("Barcelona",match.getHomeTeam());
    }

    @Test
    public void setHomeTeam() {
        Match match = new Match();
        match.setHomeTeam("Barcelona");
        assertEquals("Barcelona",match.getHomeTeam());
    }

    @Test
    public void getAwayTeam() {
        Match match = new Match();
        match.setAwayTeam("Manchester");
        assertEquals("Manchester",match.getAwayTeam());
    }

    @Test
    public void setAwayTeam() {
        Match match = new Match();
        match.setAwayTeam("Manchester");
        assertEquals("Manchester",match.getAwayTeam());
    }

    @Test
    public void getHomeTeamGoals() {
        Match match = new Match();
        match.setHomeTeamGoals(2);
        assertEquals(2,match.getHomeTeamGoals());
    }

    @Test
    public void setHomeTeamGoals() {
        Match match = new Match();
        match.setHomeTeamGoals(2);
        assertEquals(2,match.getHomeTeamGoals());
    }

    @Test
    public void getAwayTeamGoals() {
        Match match = new Match();
        match.setAwayTeamGoals(3);
        assertEquals(3,match.getAwayTeamGoals());
    }

    @Test
    public void setAwayTeamGoals() {
        Match match = new Match();
        match.setAwayTeamGoals(3);
        assertEquals(3,match.getAwayTeamGoals());
    }

    @Test
    public void getDateOfMatchPlayed() {
        Match match = new Match();
        String date = "2020-01-01";
        LocalDate Date = LocalDate.parse(date);
        match.setDateOfMatchPlayed(Date);
        assertEquals(Date,match.getDateOfMatchPlayed());
    }

    @Test
    public void setDateOfMatchPlayed() {
        Match match = new Match();
        String date = "2020-01-01";
        LocalDate Date = LocalDate.parse(date);
        match.setDateOfMatchPlayed(Date);
        assertEquals(Date,match.getDateOfMatchPlayed());
    }

    @Test
    public void testEquals() {
    }
}