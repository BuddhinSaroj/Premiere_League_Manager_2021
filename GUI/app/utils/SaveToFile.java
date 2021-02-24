package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import static services.PremiereLeagueManager.clubLeague;
import static services.PremiereLeagueManager.matches;

public class SaveToFile {
    public static void saveDataIntoTheFile(){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("file");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(clubLeague);
            objectOutputStream.writeObject(matches);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (IOException i){
            i.printStackTrace();
        }
    }
}
