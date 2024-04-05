package datasource;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {

    //Scanner attribut for at kunne læse fra CSV filen.
    private Scanner fileReader;
    //Arraylist med Covid19Data. Hver instans af Covid19Data er 1 række i vores CSV fil.
    private ArrayList<Covid19Data> dataList;

    public FileHandler() {
        //Vi instansiere datalist og FileReader. FileReader sættes lig med null da Java kræver den instansieres
        //et scope som altid kan blive kørt, som vores fil ikke nødvendigvis altid vil gøre grundet vores try catch.
        dataList = new ArrayList<>();
        fileReader = null;
        try {
            //Vi indsætter vores fil i vores scanner. Filen ligger i resources/coviddata.csv. File.seperator'
            //Er blot / der viser filstien. Denne bruges fordi File.separator ændre sig ud fra computerens OS.
            //Dette er nødvendigt fordi Windows bruger '/' og MacOS bruger '\'.
            //StandardCharset sættes, da det CharSet Java benytter pr. default er UTF-8, som ikke understøtter æ,ø,å.
            //Dog understøtter ISO_8859_1 æ,ø,å, og derfor sættes denne i scanneren.
            fileReader = new Scanner(new File("resources"+File.separator+"coviddata.csv"), StandardCharsets.ISO_8859_1);
        } catch(IOException ioE) {
            //Throw RuntimeException så vi stadig får vores Exception vist ved fejl, men den fortsat gider at compile.
            //Vi konvertere blot en checked exception til en uncheckedexception.
            throw new RuntimeException(ioE);
        }
    }

    public ArrayList<Covid19Data> readFile() {
        //Whileloop. Kører så længe der er en linje i vores CSV der kan læses.
        //Dette betyder whileloop stopper, når der ikke er flere linjer at læse i CSV filen.
        while(fileReader.hasNextLine()) {
            //Vi henter vores linje.
            String line = fileReader.nextLine();
            //Vi separere hver værdi i linjen ved hvert ';'.
            String[] attributes = line.split(";");
            //Vi tilføjer attributterne fra CSV filen til hver attribut i vores Covid19Data klasse.
            //Derefter tilføjes instans til en liste, så vi har alle data i en liste, med hver linje
            //som dens egen instans af Covid19Data.
            //Integer.parseInt bruges, fordi data fra CSV fil kommer ind som String, ligegyldigt om det er et tal eller ej.
            //Vi konvertere derfor fra String til int, som vores Covid19Data instans benytter.
            dataList.add(new Covid19Data(attributes[0],attributes[1],
                    Integer.parseInt(attributes[2]),Integer.parseInt(attributes[3]),
                    Integer.parseInt(attributes[4]), Integer.parseInt(attributes[5]),attributes[6]));
        }

        //Vi returnere listen.
        return dataList;
    }


}
