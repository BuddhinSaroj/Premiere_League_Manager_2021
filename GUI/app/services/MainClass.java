package services;

import java.io.IOException;
import java.util.Scanner;

public class MainClass {

    private static PremiereLeagueManager premiereLeagueManagerClass = new PremiereLeagueManager(20);

    public static void main(String[] args) throws IOException, InterruptedException {

        //change font color in console
        String cyan = "\033[0;96m";
        String def = "\u001B[0m";  //default color
        String green = "\033[1;92m";

        System.out.println(green + "\n*****************************************************************************" + green);
        System.out.println(green + "******************Welcome to football premiere league************************" + green);
        System.out.println(green + "*****************************************************************************\n" + def);
        premiereLeagueManagerClass.loadDataFromTheFile();

        MenuLoop:
        while (true) {
            System.out.println("\n|***************************************************************************|");
            System.out.println(cyan + "|Press '1' to create a new foot ball club and add it in the premiere league |" + cyan);
            System.out.println(cyan + "|Press '2' to delete existing club from the premiere league                 |" + cyan);
            System.out.println(cyan + "|Press '3' to display the various statistics for a selected club            |" + cyan);
            System.out.println(cyan + "|Press '4' to display the premiere league table                             |" + cyan);
            System.out.println(cyan + "|Press '5' to Add a played match with its score and its date                |" + cyan);
            System.out.println(cyan + "|Press '6' to Open GUI from chrome                                          |" + cyan);
            System.out.println(cyan + "|Press '7' to quit the programme                                            |" + def);
            System.out.println("|***************************************************************************|");
            System.out.print(cyan + "*Please Enter your option here >> " + def);


            try{
                Scanner sc = new Scanner(System.in);
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        createNewClub();
                        break;
                    case 2:
                        deleteExistingClub();
                        break;
                    case 3:
                        displayVariousStats();
                        break;
                    case 4:
                        displayPremiereLeagueTable();
                        break;
                    case 5:
                        addPlayedMatchWithItsScore();
                        break;
                    case 6:
                        openGui();
                        break;
                    case 7:
                        quit();
                        break;
                    default:
                        System.out.println("Your option is out of range(1-7)...Please try again...");
                }}catch (Exception exception){
                System.out.println("Please enter numerical value...");
            }
        }


    }

    private static void createNewClub() {
        premiereLeagueManagerClass.createNewClub();
    }

    private static void deleteExistingClub() {
        premiereLeagueManagerClass.deleteExistingClub();
    }

    private static void displayVariousStats() {
        premiereLeagueManagerClass.displayVariousStats();
    }

    private static void displayPremiereLeagueTable() {
        premiereLeagueManagerClass.displayPremiereLeagueTable();
    }

    private static void addPlayedMatchWithItsScore() throws InterruptedException {
        premiereLeagueManagerClass.addPlayedMatchWithItsScore();
    }

    private static void openGui() {
        premiereLeagueManagerClass.openGui();
    }

    private static void quit() {
        premiereLeagueManagerClass.saveDataIntoTheFile();
        System.out.println("\n|*****Thank you for using premiere league manager application 2021*****|");
        System.out.println("|****************|Stay safe and stay connected with us|****************|");

        System.exit(0);
    }
}

