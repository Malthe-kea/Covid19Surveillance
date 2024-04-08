package Comparators;

import datasource.*;

import java.util.Comparator;

public class RegionCompare implements Comparator<Covid19Data> {


    public RegionCompare() {
    }


    @Override
    public int compare(Covid19Data o1, Covid19Data o2) {

        //Sådan returneres det, hvis det er en int.
        return Integer.compare(o1.getDeaths(), o2.getDeaths());

        //Sådan returneres det, hvis det er string. (skal udkommenteres igen)
        //return o1.getRegion().compareToIgnoreCase(o2.getRegion());
    }
}
