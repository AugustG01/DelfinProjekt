package core;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

import database.*;


public class Controller {
    DataBase db = new DataBase();
    Random random = new Random();
    private int id;

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

    public void tilføjMedlem(String navn, String fødselsdato, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance){
        int fastId = genererId();
        Medlem medlem = new Medlem(navn, fødselsdato, aktivtMedlemskab, konkurrenceSvømmer, restance, fastId);
        db.tilføjMedlem(medlem);

        if (konkurrenceSvømmer) {
            KonkurrenceSvømmer nyKonkurrenceSvømmer = new KonkurrenceSvømmer(navn, fødselsdato, aktivtMedlemskab, restance, fastId, false, false, false, false, 1000, 1000, 1000, 1000);
            db.tilføjKonkurrenceSvømmer(nyKonkurrenceSvømmer);
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
/*
    public void opretKonkurrenceSvømmer(KonkurrenceSvømmer konkurrenceSvømmer){
        db.tilføjKonkurrenceSvømmer(konkurrenceSvømmer);

    }

 */

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

    public void tilføjSvømmer(Medlem medlem) {
        KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer(medlem.getNavn(), medlem.getFødselsdato(), medlem.getAktivtMedlemskab(), medlem.getRestance(), medlem.getId(), false, false, false, false, 1000, 1000, 1000, 1000);
        db.tilføjKonkurrenceSvømmer(konkurrenceSvømmer);

    }

    public void opdaterSvømmere() throws FileNotFoundException {
        db.skrivKonkurrenceSvømmere();
        db.indlæs();
    }

    public int genererId() {return id = random.nextInt(999999) + 1;}
}
