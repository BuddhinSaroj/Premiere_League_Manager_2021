package services;

import entities.FootballClub;

import java.util.Comparator;

public class GoalsComparator implements Comparator<FootballClub> {
    @Override
    public int compare(FootballClub o1, FootballClub o2) {
        if(o1.getNumberOfScored() == o2.getNumberOfScored())
            return 0;
        else if(o1.getNumberOfScored() < o2.getNumberOfScored())
            return 1;
        else
            return -1;

    }
}