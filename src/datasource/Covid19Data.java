package datasource;

public class Covid19Data {


    //Disse attributes er 1-1 med de navne på datatyper fra Statens Serum Institut data. Attributterne hedder således i CSV filen:
    //Region;Aldersgruppe;Bekræftede tilfælde i alt;Døde;Indlagte på intensiv afdeling;Indlagte;Dato
    private String region;
    private String ageGroup;
    private int confirmedInfectedInTotal;
    private int deaths;
    private int icuTotals;
    private int admissionTotals;
    private String date;


    //En constructor der kan tage imod parametre for hver attribut.
    public Covid19Data(String region, String ageGroup, int confirmedInfectedInTotal, int deaths,
                       int icuTotals, int admissionTotals, String date) {
        this.region = region;
        this.ageGroup = ageGroup;
        this.confirmedInfectedInTotal = confirmedInfectedInTotal;
        this.deaths = deaths;
        this.icuTotals = icuTotals;
        this.admissionTotals = admissionTotals;
        this.date = date;
    }

    //En toString funktion, så vi nemt kan teste om vi har hentet alt data fra vores CSV fil.
    @Override
    public String toString() {
        return "region = " + region + '\n' +
                "ageGroup = " + ageGroup + '\n' +
                "confirmedInfectedInTotal = " + confirmedInfectedInTotal + '\n' +
                "deaths = " + deaths + '\n' +
                "icuTotals = " + icuTotals + '\n' +
                "admissionTotals = " + admissionTotals + '\n' +
                "date = " + date + '\n';
    }
}
