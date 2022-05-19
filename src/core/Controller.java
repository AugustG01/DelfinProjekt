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
        Medlem medlem = new Medlem(navn, fødselsdato, aktivtMedlemskab, konkurrenceSvømmer, restance);
        db.tilføjMedlem(medlem);
        opretKonkurrenceSvømmer(medlem);
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

    public void opretKonkurrenceSvømmer(Medlem medlem){
        if(medlem.getKonkurrenceSvømmer())
            db.tilføjKonkurrenceSvømmer(medlem);

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

    public void fjernSvømmer(Medlem medlem) {

        //KonkurrenceSvømmer konkurrenceSvømmer = db.findSvømmer(medlem.getNavn());
        db.fjernKonkurrenceSvømmer(medlem);
    }
}
