package services;

import entities.Match;

import java.util.Comparator;

public class DateComparator implements Comparator<Match> {
    @Override
    public int compare(Match o1, Match o2) {
        return o1.getDateOfMatchPlayed().compareTo(o2.getDateOfMatchPlayed());
    }
}
