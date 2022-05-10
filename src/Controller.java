import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    DataBase db = new DataBase();
    Scanner in = new Scanner(System.in);

    public void seListe() {

    }

    public void tilføjMedlem(int alder, String navn, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance) throws FileNotFoundException {
        db.tilføjMedlem(new Medlem(alder, navn, aktivtMedlemskab, konkurrenceSvømmer, restance));
    }



    public void indlæsMedlemmer() throws FileNotFoundException {
        db.indlæs();
    }

    public void ændrMedlem() {

    }

    public void sletMedlem() {

    }

    public void konkurrenceMenu() {

    }

    public void økonomiMenu() {

    }
}
