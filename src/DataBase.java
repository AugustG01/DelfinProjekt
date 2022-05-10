import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DataBase {
    ArrayList<Medlem> medlemmer = new ArrayList<>();
    String filnavn = "medlemmer.csv";

    // TODO: 10-05-2022 håndter throw
    public void skriv() throws FileNotFoundException {
        filnavn = "medlemmer.csv";

        CSVhåndtering csv = new CSVhåndtering(filnavn);
        csv.skrivMedlem(medlemmer);
    }
    public void tilføjMedlem(Medlem medlem) throws FileNotFoundException {
        medlemmer.add(medlem);
        skriv();
    }

    public void indlæs() throws FileNotFoundException {
        CSVhåndtering csv = new CSVhåndtering(filnavn);
        csv.indlæsMedlemmer();
    }
}
