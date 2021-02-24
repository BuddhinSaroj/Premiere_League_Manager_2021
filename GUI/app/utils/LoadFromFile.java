package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static services.PremiereLeagueManager.clubLeague;
import static services.PremiereLeagueManager.matches;

public class LoadFromFile {
    public static void loadDataFromTheFile(){
        try{
            FileInputStream fileInputStream = new FileInputStream("file");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            clubLeague = (ArrayList) objectInputStream.readObject();
            matches = (ArrayList) objectInputStream.readObject();

            fileInputStream.close();
            objectInputStream.close();
        }catch (ClassNotFoundException e){
            System.out.println("Not found");
            e.printStackTrace();
            return;
        } catch (IOException i){
            i.printStackTrace();
            return;
        }
    }
}
