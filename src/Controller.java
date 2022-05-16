import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Controller {
    DataBase db = new DataBase();

    public void seMedlemsListe() {
        db.seListeAfMedlemmer();
    }

    public void tilføjMedlem(String navn, int alder, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance){
        Medlem medlem = new Medlem(navn, alder, aktivtMedlemskab, konkurrenceSvømmer, restance);
        db.tilføjMedlem(medlem);
        if(medlem.getKonkurrenceSvømmer())
            opretKonkurrenceSvømmer(medlem);
    }
    public void tilføjKonkurrence(String konkurrenceNavn, String dato, ArrayList<KonkurrenceSvømmer> deltagere, double[] tider){
        db.tilføjKonkurrence(konkurrenceNavn, dato,  deltagere,tider);
    }

    public void indlæsMedlemmer() throws FileNotFoundException {
        db.indlæs();
    }
    public void seKonkurrenceListe(){
        db.seListeAfKonkurrenceSvømmere();
    }

    public void opretKonkurrenceSvømmer(Medlem medlem){
        db.tilføjKonkurrenceSvømmer(medlem);
    }

    public void seKontingent(){
        Økonomi økonomi = new Økonomi(db.medlemmer);
        økonomi.totalKontingent();
    }

    public void seRestanceListe() {
        Økonomi økonomi = new Økonomi(db.medlemmer);
        økonomi.udskrivRestanceListe();
    }

    public void gem() throws FileNotFoundException {
        db.skrivMedlemmer();
        db.skrivKonkurrenceSvømmere();
    }
    public ArrayList<Medlem> findMedlem(String søg){
        return db.findMedlem(søg);
    }

    public ArrayList<KonkurrenceSvømmer> findSvømmer(String søg){return db.findSvømmer(søg);}

    public void sletMedlem(Medlem medlem){
        db.slet(medlem);
    }
}
