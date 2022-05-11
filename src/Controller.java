import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    DataBase db = new DataBase();

    public void seListe() {
        db.seListe();
    }

    public void tilføjMedlem(String navn, int alder, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance){
        db.tilføjMedlem(new Medlem(navn, alder, aktivtMedlemskab, konkurrenceSvømmer, restance));
    }

    public void indlæsMedlemmer() throws FileNotFoundException {
        db.indlæs();
    }

    public void ændrMedlem() {

    }

    public void konkurrenceMenu() {

    }

    public void økonomiMenu() {

    }
    public void gem() throws FileNotFoundException {
        db.skriv();
    }
    public ArrayList<Medlem> findMedlem(String søg){
        return db.findMedlem(søg);
    }
    public void sletMedlem(Medlem medlem){
        db.slet(medlem);
    }
}
