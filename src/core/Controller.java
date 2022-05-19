package core;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import database.*;


public class Controller {
    DataBase db = new DataBase();

    public ArrayList<KonkurrenceSvømmer> seSvømmerListe(){
        return db.seListeAfKonkurrenceSvømmere();
    }

    public ArrayList<Medlem> seMedlemsListe() {
        return db.seListeAfMedlemmer();
    }

    public ArrayList<KonkurrenceSvømmer> seJuniorSvømmere(){
        return db.getJuniorSvømmere();
    }
    public ArrayList<KonkurrenceSvømmer> seSeniorSvømmere(){
        return db.getSeniorSvømmere();
    }

    public void tilføjMedlem(String navn, LocalDate fødselsdato, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance){
        if (!konkurrenceSvømmer) {
            Medlem medlem = new Medlem(navn, fødselsdato, aktivtMedlemskab, restance);
            db.tilføjMedlem(medlem);
        } else {
            KonkurrenceSvømmer konkurrenceSvømmer1 = new KonkurrenceSvømmer(navn, fødselsdato, aktivtMedlemskab, restance);
            db.tilføjKonkurrenceSvømmer(konkurrenceSvømmer1);
        }
    }
    public void tilføjKonkurrence(String konkurrenceNavn, String dato, ArrayList<KonkurrenceSvømmer> deltagere, double[] tider, String disciplin){
        db.tilføjKonkurrence(konkurrenceNavn, dato, deltagere, tider, disciplin);
    }

    public void indlæsMedlemmer() throws FileNotFoundException {
        db.indlæs();
    }
    public void seKonkurrenceListe(){
        db.seListeAfKonkurrenceSvømmere();
    }

    public void opretKonkurrenceSvømmer(String navn, LocalDate fødselsdato){

    }

    public double seKontingent(){
        Økonomi økonomi = new Økonomi(db.medlemmer);
        return økonomi.totalKontingent();
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

    public void opdaterSvømmere() throws FileNotFoundException {
        db.skrivKonkurrenceSvømmere();
        db.indlæs();
    }
}
