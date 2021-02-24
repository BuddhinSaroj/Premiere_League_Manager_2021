package services;

import entities.FootballClub;

import java.util.Comparator;

public class WinsComparator implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub o1, FootballClub o2) {
        if(o1.getNumberOfWins() == o2.getNumberOfWins())
            return 0;
        else if(o1.getNumberOfWins() < o2.getNumberOfWins())
            return 1;
        else
            return -1;

    }
}

