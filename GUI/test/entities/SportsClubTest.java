package entities;

import org.junit.Test;

import static org.junit.Assert.*;

public class SportsClubTest {

    @Test
    public void getNameOfTheClub() {
        SportsClub sportsClub = new SportsClub();
        String clubName = "Manchester";
        sportsClub.setNameOfTheClub(clubName);
        assertEquals("Manchester",clubName);
    }

    @Test
    public void setNameOfTheClub() {
        SportsClub sportsClub = new SportsClub();
        String clubName = "Manchester";
        sportsClub.setNameOfTheClub(clubName);
        assertEquals("Manchester",clubName);
    }

    @Test
    public void getLocationOfTheClub() {
        SportsClub sportsClub = new SportsClub();
        String location = "England";
        sportsClub.setLocationOfTheClub(location);
        assertEquals("England",location);
    }

    @Test
    public void setLocationOfTheClub() {
        SportsClub sportsClub = new SportsClub();
        String location = "England";
        sportsClub.setLocationOfTheClub(location);
        assertEquals("England",location);
    }

    @Test
    public void getVariousStatsOfTheClub() {
        SportsClub sportsClub = new SportsClub();
        String manager = "Andrew";
        sportsClub.setVariousStatsOfTheClub(manager);
        assertEquals("Andrew",manager);
    }

    @Test
    public void setVariousStatsOfTheClub() {
        SportsClub sportsClub = new SportsClub();
        String manager = "Andrew";
        sportsClub.setVariousStatsOfTheClub(manager);
        assertEquals("Andrew",manager);
    }

    @Test
    public void getFoundedYear() {
        SportsClub sportsClub = new SportsClub();
        int foundedYear = 1900;
        sportsClub.setFoundedYear(foundedYear);
        assertEquals(1900,foundedYear);
    }

    @Test
    public void setFoundedYear() {
        SportsClub sportsClub = new SportsClub();
        int foundedYear = 1900;
        sportsClub.setFoundedYear(foundedYear);
        assertEquals(1900,foundedYear);
    }
}