package services;

import entities.FootballClub;
import entities.Match;
import utils.LoadFromFile;
import utils.SaveToFile;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PremiereLeagueManager implements LeagueManager {

    public static   ArrayList<FootballClub> clubLeague = new ArrayList<>();
    public static   ArrayList<Match> matches = new ArrayList<>();
    private final int numberOfClubs;

    public PremiereLeagueManager(int numberOfClubs) {
        this.numberOfClubs = numberOfClubs;
    } //constructor

    @Override
    public void createNewClub() {
        String clubName ;
        if(clubLeague.size() < numberOfClubs){
            Scanner sc = new Scanner(System.in);
            FootballClub newClub = new FootballClub();
            System.out.println("Please Enter club name : ");
            System.out.print(">>");
            clubName = sc.nextLine().toUpperCase();
            newClub.setNameOfTheClub(clubName);

            for(FootballClub clb : clubLeague){
                if(clb.getNameOfTheClub().equalsIgnoreCase(clubName)){
                    System.out.println("This club already included in the league.");
                    return;
                }
            }
            System.out.println("Please Enter your club location : ");
            System.out.print(">>");
            String location = sc.nextLine();
            newClub.setLocationOfTheClub(location);

            System.out.println("Please enter club founded year : ");
            System.out.print(">>");
            int year = sc.nextInt();
            newClub.setFoundedYear(year);

            System.out.println("Please enter club manager name : ");
            System.out.print(">>");
            String manager = sc.next();
            newClub.setVariousStatsOfTheClub(manager);

            clubLeague.add(newClub);
        }
        else{
            System.out.println("Premiere league club limit is reached...Can't add more clubs...");
            return;
        }
        System.out.println("Club " +clubName +" is successfully added to premiere league...");
        saveDataIntoTheFile();
    }

    @Override
    public void deleteExistingClub() {
        Scanner sc  = new Scanner(System.in);
        System.out.println(">>press 1 for : -----Relegate : Transfer (a sports team) to a lower division of a league.-----");
        System.out.println(">>press 2 for : -----Delete : Remove any team from current league.----------------------------");
        System.out.print("Enter here >>");
        int input = sc.nextInt();
        if(input == 1){
            if(clubLeague.size() == 20){
                clubLeague.sort(Collections.reverseOrder());
                FootballClub clb = clubLeague.get(clubLeague.size()-1);
                clubLeague.remove(clubLeague.size()-1);
                System.out.println("Club : "+clb.getNameOfTheClub()+" Removed from a league...");
                System.out.println("Club location : "+clb.getLocationOfTheClub());
                System.out.println("Club founded year : "+clb.getFoundedYear());
                System.out.println("Club manager : Mr."+clb.getVariousStatsOfTheClub());
                saveDataIntoTheFile();
                return;
            }
            else{
                System.out.println("........ 20 teams required to relegate from league ........");
            }
        }
        else if(input == 2){
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Please Enter your club name : ");
            String clubName = sc2.nextLine();
            for (FootballClub deleteClub : clubLeague){
                if(deleteClub.getNameOfTheClub().equalsIgnoreCase(clubName)){
                    clubLeague.remove(deleteClub);
                    System.out.println("Club : "+deleteClub.getNameOfTheClub()+" Deleted from a league...");
                    System.out.println("Club location : "+deleteClub.getLocationOfTheClub());
                    System.out.println("Club founded year : "+deleteClub.getFoundedYear());
                    System.out.println("Club manager : Mr."+deleteClub.getVariousStatsOfTheClub());
                    saveDataIntoTheFile();
                    return;
                }
            }
            System.out.println("Club " + clubName + " Cant find from the premiere league...Please Retry...");
            return;
        }else{
            System.out.println("Invalid input");
        }
        saveDataIntoTheFile();
    }

    @Override
    public void displayVariousStats() {
        loadDataFromTheFile();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter club name : ");
        System.out.print(">>");
        String clubName = sc.nextLine();
        for(FootballClub stats : clubLeague){
            if(stats.getNameOfTheClub().equalsIgnoreCase(clubName)){
                System.out.println("Club " + stats.getNameOfTheClub()+ " location : " +stats.getLocationOfTheClub());
                System.out.println("Club " + stats.getNameOfTheClub()+ " Founded year : "+stats.getFoundedYear());
                System.out.println("Club " + stats.getNameOfTheClub()+ " Manager : Mr."+stats.getVariousStatsOfTheClub());
                System.out.println("Club " + stats.getNameOfTheClub()+ " matches won: " +stats.getNumberOfWins());
                System.out.println("Club " + stats.getNameOfTheClub()+ " matches defeats: " +stats.getNumberOfDefeats());
                System.out.println("Club " + stats.getNameOfTheClub()+ " matches draws: " +stats.getNumberOfDraws());
                System.out.println("Club " + stats.getNameOfTheClub()+ " number of matches played : " +stats.getNumberOfMatchesPlayed());
                System.out.println("Club " + stats.getNameOfTheClub()+ " number of scored : " +stats.getNumberOfScored());
                System.out.println("Club " + stats.getNameOfTheClub()+ " number of goals received : " +stats.getNumberOfGoalsReceived());
                System.out.println("Club " + stats.getNameOfTheClub()+ " number of points : " +stats.getNumberOfPoints());
                return;
            }
        }
        System.out.println("Club " + clubName + " Cant find from the premiere league...Please Retry...");
        return;
    }

    @Override
    public void displayPremiereLeagueTable() {
        loadDataFromTheFile();
        if(clubLeague.isEmpty()){
            System.out.println("Premiere league table is empty...");
            return;
        }
        //Collections.sort(clubLeague);
        clubLeague.sort(Collections.reverseOrder());
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-18s %12s %10s %10s %10s %15s %17s %20s %12s", "TEAMS","Matches" , "WINS", "DEFEATS", "DRAWS","GOAL SCORED","GOAL RECEIVED", "GOAL DIFFERENCE" , "POINTS");
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
        for(FootballClub clb : clubLeague){
            System.out.format("\n%-19s %8s %11s %9s %12s %10s %18s %16s %18s",clb.getNameOfTheClub(),clb.getNumberOfMatchesPlayed(),clb.getNumberOfWins(),clb.getNumberOfDefeats(),clb.getNumberOfDraws(),clb.getNumberOfScored(),clb.getNumberOfGoalsReceived(),clb.getGoalDif(),clb.getNumberOfPoints());
        }
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");

    }

    @Override
    public void addPlayedMatchWithItsScore() throws InterruptedException {
        loadDataFromTheFile();
        if(clubLeague.size() < 2){
            System.out.println("Can't find two teams.Add another teams for premiere league");
            return;
        }

        if(matches.size() == clubLeague.size()*(clubLeague.size()-1)){
            System.out.println("\n|************************All matches are played*****************************|");

            return;
        }
        Match match = new Match();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter match played date : (format yyyy-MM-dd)");
        System.out.print(">>");
        String date = sc.nextLine();
        String regex = "^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$";
        //Creating a pattern object
        Pattern pattern = Pattern.compile(regex);
        //Matching the compiled pattern in the String
        Matcher matcher = pattern.matcher(date);
        boolean isMatched = matcher.matches();
        if(isMatched) {
            LocalDate date1 = LocalDate.parse(date);
            match.setDateOfMatchPlayed(date1);
        } else {
            System.out.println("Date is not valid");
            return;
        }
        System.out.println("Enter home team name : ");
        System.out.print(">>");
        String homeTeamName = sc.nextLine().toUpperCase();
        FootballClub home = null;
        for(FootballClub homeTeam : clubLeague){
            if(homeTeam.getNameOfTheClub().equalsIgnoreCase(homeTeamName)){
                home = homeTeam;
                match.setHomeTeam(homeTeamName);
            }
        }
        if(home == null){
            System.out.println("Can't find the club from premiere league...");
            return;
        }

        System.out.println("Enter away team name : ");
        System.out.print(">>");
        String awayTeamName = sc.nextLine().toUpperCase();
        if(homeTeamName.equalsIgnoreCase(awayTeamName)){
            System.out.println("already included..");
            return;
        }else{
            FootballClub away = null;
            for (FootballClub awayTeam : clubLeague) {
                if (awayTeam.getNameOfTheClub().equalsIgnoreCase(awayTeamName)) {
                    away = awayTeam;
                    match.setAwayTeam(awayTeamName);
                }
            }
            if (away == null) {
                System.out.println("Can't find the club from premiere league...");
                return;
            }

            if(matches.contains(match)){
                System.out.println("Match was already played.......");
                return;
            }

            System.out.println("Enter home team goals");
            System.out.print(">>");
            int homeTeamGoals = 0;
            try{
                homeTeamGoals = sc.nextInt();
                match.setHomeTeamGoals(homeTeamGoals);
                home.setNumberOfScored(home.getNumberOfScored()+homeTeamGoals);
                away.setNumberOfGoalsReceived(away.getNumberOfGoalsReceived()+homeTeamGoals);
            }catch (Exception e){
                System.out.println("Please enter numerical value : ");
            }
            if(homeTeamGoals < 0){
                System.out.println("Score cannot be minus value...Please recheck and enter : ");
                return;
            }

            System.out.println("Enter away team goals");
            System.out.print(">>");
            int awayTeamGoals = 0;
            try {
                awayTeamGoals = sc.nextInt();
                match.setAwayTeamGoals(awayTeamGoals);
                away.setNumberOfScored(away.getNumberOfScored() + awayTeamGoals);
                home.setNumberOfGoalsReceived(home.getNumberOfGoalsReceived()+awayTeamGoals);
            } catch (Exception e) {
                System.out.println("Please enter numerical value : ");
            }
            if (awayTeamGoals < 0) {
                System.out.println("Score cannot be minus value...Please recheck and enter : ");
                return;
            }

            matches.add(match);

            if (homeTeamGoals > awayTeamGoals) {
                int goalDifference = homeTeamGoals - awayTeamGoals ;
                int awayGoalDifference = awayTeamGoals - homeTeamGoals;
                home.setNumberOfPoints(home.getNumberOfPoints() + 3);
                home.setNumberOfWins(home.getNumberOfWins() + 1);
                home.setNumberOfMatchesPlayed(home.getNumberOfMatchesPlayed()+1);
                away.setNumberOfMatchesPlayed(away.getNumberOfMatchesPlayed()+1);
                away.setNumberOfDefeats(away.getNumberOfDefeats() + 1);
                home.setGoalDif(home.getGoalDif()+goalDifference);
                away.setGoalDif(away.getGoalDif() + awayGoalDifference);
            } else if (homeTeamGoals < awayTeamGoals) {
                int goalDifference = awayTeamGoals - homeTeamGoals ;
                int homeGoalDifference = homeTeamGoals - awayTeamGoals;
                away.setNumberOfPoints(away.getNumberOfPoints() + 3);
                away.setNumberOfWins(away.getNumberOfWins() + 1);
                home.setNumberOfDefeats(home.getNumberOfDefeats() + 1);
                home.setNumberOfMatchesPlayed(home.getNumberOfMatchesPlayed()+1);
                away.setNumberOfMatchesPlayed(away.getNumberOfMatchesPlayed()+1);
                away.setGoalDif(away.getGoalDif()+goalDifference);
                home.setGoalDif(home.getGoalDif() + homeGoalDifference);
            } else {
                home.setNumberOfPoints(home.getNumberOfPoints() + 1);
                away.setNumberOfPoints(away.getNumberOfPoints() + 1);
                home.setNumberOfDraws(home.getNumberOfDraws() + 1);
                away.setNumberOfDraws(away.getNumberOfDraws() + 1);
                home.setNumberOfMatchesPlayed(home.getNumberOfMatchesPlayed()+1);
                away.setNumberOfMatchesPlayed(away.getNumberOfMatchesPlayed()+1);
            }
            System.out.println("--------------------------------------------");
            System.out.println("|    Wait!!!Your program is processing.    |");
            System.out.println("--------------------------------------------");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("********Match was successfully added********");
        }
        saveDataIntoTheFile();
    }

    @Override
    public boolean openGui(){

        try {
            ProcessBuilder processBuilderForGui = new ProcessBuilder(
                    "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe","http://localhost:4200/");
            processBuilderForGui.start();
            System.out.println("Browser opened from chrome");
            return true;
        }catch (IOException ioException){
            ioException.printStackTrace();
            return false;
        }

    }

    @Override
    public void saveDataIntoTheFile(){
        SaveToFile.saveDataIntoTheFile();
    }

    @Override
    public void loadDataFromTheFile(){
        LoadFromFile.loadDataFromTheFile();
    }
}


