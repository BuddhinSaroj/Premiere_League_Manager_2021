package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class UniversityFootballClubTest {

    @Test
    public void testToString() {
    }

    @Test
    public void getNumberOfWins() {
        FootballClub footballClub = new FootballClub();
        int wins = 2 ;
        footballClub.setNumberOfWins(wins);
        assertEquals(wins,footballClub.getNumberOfWins());
    }

    @Test
    public void setNumberOfWins() {
        FootballClub footballClub = new FootballClub();
        int wins = 2 ;
        footballClub.setNumberOfWins(wins);
        assertEquals(wins,footballClub.getNumberOfWins());
    }

    @Test
    public void getNumberOfDraws() {
        FootballClub footballClub = new FootballClub();
        int draws = 1 ;
        footballClub.setNumberOfDraws(draws);
        assertEquals(draws,footballClub.getNumberOfDraws());
    }

    @Test
    public void setNumberOfDraws() {
        FootballClub footballClub = new FootballClub();
        int draws = 1 ;
        footballClub.setNumberOfDraws(draws);
        assertEquals(draws,footballClub.getNumberOfDraws());
    }

    @Test
    public void getNumberOfDefeats() {
        FootballClub footballClub = new FootballClub();
        int defeats = 0 ;
        footballClub.setNumberOfDraws(defeats);
        assertEquals(defeats,footballClub.getNumberOfDefeats());
    }

    @Test
    public void setNumberOfDefeats() {
        FootballClub footballClub = new FootballClub();
        int defeats = 0 ;
        footballClub.setNumberOfDraws(defeats);
        assertEquals(defeats,footballClub.getNumberOfDefeats());
    }

    @Test
    public void getNumberOfGoalsReceived() {
        FootballClub footballClub = new FootballClub();
        int gr = 4 ;
        footballClub.setNumberOfGoalsReceived(gr);
        assertEquals(gr,footballClub.getNumberOfGoalsReceived());
    }

    @Test
    public void setNumberOfGoalsReceived() {
        FootballClub footballClub = new FootballClub();
        int gr = 0 ;
        footballClub.setNumberOfGoalsReceived(gr);
        assertEquals(gr,footballClub.getNumberOfGoalsReceived());
    }

    @Test
    public void getNumberOfScored() {
        FootballClub footballClub = new FootballClub();
        int gs = 2 ;
        footballClub.setNumberOfScored(gs);
        assertEquals(gs,footballClub.getNumberOfScored());
    }

    @Test
    public void setNumberOfScored() {
        FootballClub footballClub = new FootballClub();
        int gs = 2 ;
        footballClub.setNumberOfScored(gs);
        assertEquals(gs,footballClub.getNumberOfScored());
    }

    @Test
    public void getNumberOfPoints() {
        FootballClub footballClub = new FootballClub();
        int points = 6 ;
        footballClub.setNumberOfPoints(points);
        assertEquals(points,footballClub.getNumberOfPoints());
    }

    @Test
    public void setNumberOfPoints() {
        FootballClub footballClub = new FootballClub();
        int points = 6 ;
        footballClub.setNumberOfPoints(points);
        assertEquals(points,footballClub.getNumberOfPoints());
    }

    @Test
    public void getNumberOfMatchesPlayed() {
        FootballClub footballClub = new FootballClub();
        int mp = 2 ;
        footballClub.setNumberOfMatchesPlayed(mp);
        assertEquals(mp,footballClub.getNumberOfMatchesPlayed());
    }

    @Test
    public void setNumberOfMatchesPlayed() {
        FootballClub footballClub = new FootballClub();
        int mp = 2 ;
        footballClub.setNumberOfMatchesPlayed(mp);
        assertEquals(mp,footballClub.getNumberOfMatchesPlayed());
    }

    @Test
    public void getGoalDif() {
        FootballClub footballClub = new FootballClub();
        int gd = 2;
        footballClub.setGoalDif(gd);
        assertEquals(gd,footballClub.getGoalDif());
    }

    @Test
    public void setGoalDif() {
        FootballClub footballClub = new FootballClub();
        int gd = 2;
        footballClub.setGoalDif(gd);
        assertEquals(gd,footballClub.getGoalDif());
    }

    @Test
    public void getNameOfTheClub() {
        FootballClub footballClub = new FootballClub();
        String name = "Barcelona";
        footballClub.setNameOfTheClub(name);
        assertEquals(name,footballClub.getNameOfTheClub());
    }

    @Test
    public void setNameOfTheClub() {
        FootballClub footballClub = new FootballClub();
        String name = "Barcelona";
        footballClub.setNameOfTheClub(name);
        assertEquals(name,footballClub.getNameOfTheClub());
    }

    @Test
    public void getLocationOfTheClub() {
        FootballClub footballClub = new FootballClub();
        String location = "England";
        footballClub.setLocationOfTheClub(location);
        assertEquals(location,footballClub.getLocationOfTheClub());
    }

    @Test
    public void setLocationOfTheClub() {
        FootballClub footballClub = new FootballClub();
        String location = "England";
        footballClub.setLocationOfTheClub(location);
        assertEquals(location,footballClub.getLocationOfTheClub());
    }

    @Test
    public void getVariousStatsOfTheClub() {
        FootballClub footballClub = new FootballClub();
        String manager = "andrew";
        footballClub.setVariousStatsOfTheClub(manager);
        assertEquals(manager,footballClub.getVariousStatsOfTheClub());
    }

    @Test
    public void setVariousStatsOfTheClub() {
        FootballClub footballClub = new FootballClub();
        String manager = "andrew";
        footballClub.setVariousStatsOfTheClub(manager);
        assertEquals(manager,footballClub.getVariousStatsOfTheClub());
    }

    @Test
    public void getFoundedYear() {
        FootballClub footballClub = new FootballClub();
        int year = 1900;
        footballClub.setFoundedYear(year);
        assertEquals(year,footballClub.getFoundedYear());
    }

    @Test
    public void setFoundedYear() {
        FootballClub footballClub = new FootballClub();
        int year = 1900;
        footballClub.setFoundedYear(year);
        assertEquals(year,footballClub.getFoundedYear());
    }

    @Test
    public void getUniversityName() {
        UniversityFootballClub universityFootballClub = new UniversityFootballClub();
        String name = "IIT";
        universityFootballClub.setUniversityName(name);
        assertEquals(name,universityFootballClub.getUniversityName());
    }

    @Test
    public void setUniversityName() {
        UniversityFootballClub universityFootballClub = new UniversityFootballClub();
        String name = "IIT";
        universityFootballClub.setUniversityName(name);
        assertEquals(name,universityFootballClub.getUniversityName());
    }
}