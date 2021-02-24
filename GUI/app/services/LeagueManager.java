package services;

import java.io.IOException;

public interface LeagueManager {
     void createNewClub();
    void deleteExistingClub();
    void displayVariousStats();
    void displayPremiereLeagueTable();
    void addPlayedMatchWithItsScore() throws InterruptedException;
    void saveDataIntoTheFile() throws IOException;
    void loadDataFromTheFile() throws IOException;
    boolean openGui();
}

