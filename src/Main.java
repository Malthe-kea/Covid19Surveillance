import Comparators.*;
import datasource.Covid19Data;
import datasource.FileHandler;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //Vi laver en ny instans af FileHandler
        FileHandler fileHandler = new FileHandler();
        //Vi laver en ny arrayList fyldt med Covid19Data instanser, og henter dem fra vores fileHandler.readFile() metode.
        ArrayList<Covid19Data> dataList = fileHandler.readFile();

        dataList.sort(new RegionCompare());

        //Vi looper igennem hver af vores Covid19Data i listen og kalder .toString(), så vi kan få det vist en sout.
        for (Covid19Data dataAtt : dataList) {
            System.out.println(dataAtt.toString());
        }


    }
}