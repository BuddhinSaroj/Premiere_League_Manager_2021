package services;

import entities.FootballClub;
import entities.Match;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ForBackend {
    public static ArrayList<FootballClub> clubLeagueList = new ArrayList<>();
    public static ArrayList<Match> matchesList = new ArrayList<>();
    public static ArrayList<Match> searchedMatches = new ArrayList<>();
    public static String randomMatchData;
    public static String message = null;

    public static void data() {
        try{
            FileInputStream fileInputStream = new FileInputStream("file");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            clubLeagueList = (ArrayList) objectInputStream.readObject();
            matchesList = (ArrayList) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        }catch (Exception e){
            System.out.println("Data not found");
            return;
        }
    }

    public static void sortingByPoints(){
        data();
        clubLeagueList.sort(Collections.reverseOrder());
    }

    public static void winsComparing(){
        data();
        Collections.sort(clubLeagueList,new WinsComparator ());
    }

    public static void goalsComparing(){
        data();
        Collections.sort(clubLeagueList,new GoalsComparator ());
    }

    public static void dateComparingForMatches(){
        data();
        Collections.sort(matchesList,new DateComparator());
    }

    public static String addRandomMatches(){
        data();

        Match match = new Match();
        FootballClub homeTeam;
        FootballClub awayTeam ;
        String home;
        String away;

        LocalDate startDate = LocalDate.of(2000,1,1);
        long start = startDate.toEpochDay();

        LocalDate endDate = LocalDate.of(2020,12,30);
        long end = endDate.toEpochDay();

        long random = ThreadLocalRandom.current().longs(start,end).findAny().getAsLong();
        LocalDate dateFor = LocalDate.ofEpochDay(random);

        if(clubLeagueList.size() < 2){
            //System.out.println("Can't find two teams.Add another teams for premiere league");
            randomMatchData = "Can't find two teams.Add another teams for premiere league";
            return randomMatchData;
        }

        if(matchesList.size() == clubLeagueList.size()*(clubLeagueList.size()-1)){
            //System.out.println("All matches are played");
            randomMatchData = "All matches are played";
            return randomMatchData;
        }

        do{
            //System.out.println(dateFor);
            match.setDateOfMatchPlayed(dateFor);

            //generate home team
            homeTeam = clubLeagueList.get(new Random().nextInt(clubLeagueList.size()));
            home = homeTeam.getNameOfTheClub().toUpperCase();
            match.setHomeTeam(home);
            //generate away team

            while (true){
                awayTeam = clubLeagueList.get(new Random().nextInt(clubLeagueList.size()));
                if(awayTeam != homeTeam){
                    away = awayTeam.getNameOfTheClub().toUpperCase();
                    match.setAwayTeam(away);;
                    break;
                }else if(awayTeam == homeTeam){
                    continue;
                }
            }
        }while (matchesList.contains(match));

        Random randOne = new Random();
        int homeTeamGoals = randOne.nextInt(10);
        homeTeam.setNumberOfScored(homeTeam.getNumberOfScored() + homeTeamGoals);
        match.setHomeTeamGoals(homeTeamGoals);
        awayTeam.setNumberOfGoalsReceived(awayTeam.getNumberOfGoalsReceived()+homeTeamGoals);

        Random randTwo = new Random();
        int awayTeamGoals = randTwo.nextInt(10);
        awayTeam.setNumberOfScored(awayTeam.getNumberOfScored() + awayTeamGoals);
        match.setAwayTeamGoals(awayTeamGoals);
        homeTeam.setNumberOfGoalsReceived(homeTeam.getNumberOfGoalsReceived()+awayTeamGoals);

        matchesList.add(match);
        PremiereLeagueManager.matches.add(match);

        if (homeTeamGoals > awayTeamGoals) {
            int homeGoalDifference = homeTeamGoals - awayTeamGoals;
            int awayGoalDifference = awayTeamGoals - homeTeamGoals;
            homeTeam.setNumberOfPoints(homeTeam.getNumberOfPoints() + 3);
            homeTeam.setNumberOfWins(homeTeam.getNumberOfWins() + 1);
            homeTeam.setNumberOfMatchesPlayed(homeTeam.getNumberOfMatchesPlayed() + 1);
            awayTeam.setNumberOfMatchesPlayed(awayTeam.getNumberOfMatchesPlayed() + 1);
            awayTeam.setNumberOfDefeats(awayTeam.getNumberOfDefeats() + 1);
            homeTeam.setGoalDif(homeTeam.getGoalDif() + homeGoalDifference);
            awayTeam.setGoalDif(awayTeam.getGoalDif() + awayGoalDifference);

        } else if (homeTeamGoals < awayTeamGoals) {
            int awayGoalDifference = awayTeamGoals - homeTeamGoals;
            int homeGoalDifference = homeTeamGoals - awayTeamGoals;
            awayTeam.setNumberOfPoints(awayTeam.getNumberOfPoints() + 3);
            awayTeam.setNumberOfWins(awayTeam.getNumberOfWins() + 1);
            homeTeam.setNumberOfDefeats(homeTeam.getNumberOfDefeats() + 1);
            homeTeam.setNumberOfMatchesPlayed(homeTeam.getNumberOfMatchesPlayed() + 1);
            awayTeam.setNumberOfMatchesPlayed(awayTeam.getNumberOfMatchesPlayed() + 1);
            awayTeam.setGoalDif(awayTeam.getGoalDif() + awayGoalDifference);
            homeTeam.setGoalDif(homeTeam.getGoalDif() + homeGoalDifference);
        }
        else {
            homeTeam.setNumberOfPoints(homeTeam.getNumberOfPoints() + 1);
            awayTeam.setNumberOfPoints(awayTeam.getNumberOfPoints() + 1);
            homeTeam.setNumberOfDraws(homeTeam.getNumberOfDraws() + 1);
            awayTeam.setNumberOfDraws(awayTeam.getNumberOfDraws() + 1);
            homeTeam.setNumberOfMatchesPlayed(homeTeam.getNumberOfMatchesPlayed() + 1);
            awayTeam.setNumberOfMatchesPlayed(awayTeam.getNumberOfMatchesPlayed() + 1);
        }
        save();

        return "Home team : "+home +" Home team goals : " + homeTeamGoals+" Away team : "+away +" Away team goals : " + awayTeamGoals;
    }

    public static void searchMatch(String date){
        data();
        searchedMatches.clear();

         LocalDate dateForSearch = LocalDate.parse(date);

        for(Match match : matchesList){
            if(match.getDateOfMatchPlayed().isEqual(dateForSearch)){
                searchedMatches.add(match);
            }
        }

    }

    public static void save(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("file");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clubLeagueList);
            objectOutputStream.writeObject(matchesList);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (Exception i){
            i.printStackTrace();
        }
    }


}
