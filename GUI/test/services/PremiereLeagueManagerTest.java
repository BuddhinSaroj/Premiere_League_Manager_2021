package services;

import entities.FootballClub;
import entities.Match;
import org.junit.Test;

import static org.junit.Assert.*;

public class PremiereLeagueManagerTest {

    @Test
    public void createNewClub() {
        FootballClub footballClub = new FootballClub();
        footballClub.setNameOfTheClub("manchester");
        footballClub.setLocationOfTheClub("Lk");
        footballClub.setFoundedYear(1900);
        footballClub.setVariousStatsOfTheClub("Andrew");
        assertEquals("manchester",footballClub.getNameOfTheClub());
        assertEquals("Lk",footballClub.getLocationOfTheClub());
        assertEquals(1900,footballClub.getFoundedYear());
        assertEquals("Andrew",footballClub.getVariousStatsOfTheClub());
    }

    @Test
    public void deleteExistingClub() {
    }

    @Test
    public void displayVariousStats() {
        FootballClub footballClub = new FootballClub();
        footballClub.setNameOfTheClub("manchester");
        footballClub.setNumberOfWins(1);
        footballClub.setNumberOfScored(3);
        footballClub.setNumberOfPoints(6);
        assertEquals("manchester",footballClub.getNameOfTheClub());
        assertEquals(1,footballClub.getNumberOfWins());
        assertEquals(3,footballClub.getNumberOfScored());
        assertEquals(6,footballClub.getNumberOfPoints());
    }

    @Test
    public void displayPremiereLeagueTable() {
        FootballClub footballClub = new FootballClub();
        footballClub.setNameOfTheClub("manchester");
        footballClub.setNumberOfWins(1);
        footballClub.setNumberOfScored(3);
        footballClub.setNumberOfPoints(6);
        assertEquals("manchester",footballClub.getNameOfTheClub());
        assertEquals(1,footballClub.getNumberOfWins());
        assertEquals(3,footballClub.getNumberOfScored());
        assertEquals(6,footballClub.getNumberOfPoints());
    }

    @Test
    public void addPlayedMatchWithItsScore() {
        Match match = new Match();
        match.setHomeTeam("Barcelona");
        match.setAwayTeam("Manchester");
        match.setHomeTeamGoals(3);
        match.setAwayTeamGoals(2);
        assertEquals("Barcelona",match.getHomeTeam());
        assertEquals("Manchester",match.getAwayTeam());
        assertEquals(3,match.getHomeTeamGoals());
        assertEquals(2,match.getAwayTeamGoals());
    }
}