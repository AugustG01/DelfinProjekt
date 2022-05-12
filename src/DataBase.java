import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DataBase {
    ArrayList<Medlem> medlemmer = new ArrayList<>();
    String filnavn = "medlemmer.csv";




    // TODO: 10-05-2022 håndter throw
    public void skriv() throws FileNotFoundException {
        filnavn = "medlemmer.csv";

        CSVMedlemmer csv = new CSVMedlemmer(filnavn);
        csv.skrivMedlem(medlemmer);
    }
    public void tilføjMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }

    public void indlæs() throws FileNotFoundException {
        CSVMedlemmer csv = new CSVMedlemmer(filnavn);
        medlemmer = csv.indlæsMedlemmer();
    }
    public void seListe() {
        for(Medlem medlem : medlemmer){
            // TODO: 11/05/2022 flyt sout 
            System.out.println(medlem);
        }
    }
    public void slet(Medlem medlem){
        medlemmer.remove(medlem);
    }
    public ArrayList<Medlem> findMedlem(String søg){
        ArrayList<Medlem> fundneMedlemmer = new ArrayList<>();
        for (Medlem medlem : medlemmer){
            if(medlem.matcher(søg))
                fundneMedlemmer.add(medlem);
        }
        return fundneMedlemmer;
    }
}
