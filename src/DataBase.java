import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DataBase {
    ArrayList<Medlem> medlemmer = new ArrayList<>();
    ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere = new ArrayList<>();
    String medlemsFil = "medlemmer.csv";
    String konkurrenceSvømmerFil = "svømmere.csv";


    // TODO: 10-05-2022 håndter throw
    public void skrivMedlemmer() throws FileNotFoundException {

        CSVMedlemmer csvMedlemmer = new CSVMedlemmer(medlemsFil);
        csvMedlemmer.skrivMedlem(medlemmer);
    }

    public void skrivKonkurrenceSvømmere() throws FileNotFoundException {
        CSVKonkurrenceSvømmere csvKonkurrenceSvømmere = new CSVKonkurrenceSvømmere(konkurrenceSvømmerFil);
        csvKonkurrenceSvømmere.skrivSvømmer(konkurrenceSvømmere);
    }

    public void tilføjMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }

    public void tilføjKonkurrenceSvømmer() {
        for (Medlem medlem : medlemmer) {
            if (medlem.getKonkurrenceSvømmer()) {
                KonkurrenceSvømmer svømmer = new KonkurrenceSvømmer(medlem);
                    konkurrenceSvømmere.add(svømmer);
            }
        }
    }

    public void indlæs() throws FileNotFoundException {
        CSVMedlemmer csv = new CSVMedlemmer(medlemsFil);
        medlemmer = csv.indlæsMedlemmer();
    }

    public void seListe() {
        for (Medlem medlem : medlemmer) {
            // TODO: 11/05/2022 flyt sout 
            System.out.println(medlem);
        }
    }

    public void slet(Medlem medlem) {
        medlemmer.remove(medlem);
    }

    public ArrayList<Medlem> findMedlem(String søg) {
        ArrayList<Medlem> fundneMedlemmer = new ArrayList<>();
        for (Medlem medlem : medlemmer) {
            if (medlem.matcher(søg))
                fundneMedlemmer.add(medlem);
        }
        return fundneMedlemmer;
    }
}
