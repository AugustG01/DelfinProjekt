package core;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import database.*;
import sorter.SortérBryst;
import sorter.SortérButterfly;
import sorter.SortérCrawl;
import sorter.SortérRygcrawl;


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

    public void tilføjMedlem(String navn, String fødselsdato, boolean aktivtMedlemskab, boolean konkurrenceSvømmer){
        int fastId = genererId();
        Medlem medlem = new Medlem(navn, fødselsdato, aktivtMedlemskab, konkurrenceSvømmer, fastId);
        db.tilføjMedlem(medlem);

        if (konkurrenceSvømmer) {
            KonkurrenceSvømmer nyKonkurrenceSvømmer = new KonkurrenceSvømmer(navn, fødselsdato, fastId, false, false, false, false, 1000, 1000, 1000, 1000);
            db.tilføjKonkurrenceSvømmer(nyKonkurrenceSvømmer);
        }
    }
    public void tilføjKonkurrence(String dato, ArrayList<KonkurrenceSvømmer> deltagere, double[] tider, String disciplin){
        db.tilføjKonkurrence(dato, deltagere, tider, disciplin);
    }
    public ArrayList<KonkurrenceSvømmer>  udregnBrystJunior(){
        ArrayList <KonkurrenceSvømmer> juniorSvømmere = seJuniorSvømmere();
        SortérBryst sorterBryst = new SortérBryst();
        Collections.sort(juniorSvømmere, sorterBryst);
        return juniorSvømmere;
    }
    public ArrayList<KonkurrenceSvømmer>  udregnBrystSenior(){
        ArrayList <KonkurrenceSvømmer> seniorSvømmere = seSeniorSvømmere();
        SortérBryst sorterBryst = new SortérBryst();
        Collections.sort(seniorSvømmere, sorterBryst);
        return seniorSvømmere;
    }

    public ArrayList<KonkurrenceSvømmer>  udregnCrawlJunior(){
        ArrayList <KonkurrenceSvømmer> juniorSvømmere = seJuniorSvømmere();
        SortérCrawl sorterCrawl = new SortérCrawl();
        Collections.sort(juniorSvømmere, sorterCrawl);
        return juniorSvømmere;
    }

    public ArrayList<KonkurrenceSvømmer>  udregnCrawlSenior(){
        ArrayList <KonkurrenceSvømmer> seniorSvømmere = seSeniorSvømmere();
        SortérCrawl sorterCrawl = new SortérCrawl();
        Collections.sort(seniorSvømmere, sorterCrawl);
        return seniorSvømmere;
    }

    public ArrayList<KonkurrenceSvømmer>  udregnRygcrawlSenior(){
        ArrayList <KonkurrenceSvømmer> seniorSvømmere = seSeniorSvømmere();
        SortérRygcrawl sorterRygcrawl = new SortérRygcrawl();
        Collections.sort(seniorSvømmere, sorterRygcrawl);
        return seniorSvømmere;
    }
    public ArrayList<KonkurrenceSvømmer>  udregnRygcrawlJunior(){
        ArrayList <KonkurrenceSvømmer> juniorSvømmere = seJuniorSvømmere();
        SortérRygcrawl sorterRygcrawl = new SortérRygcrawl();
        Collections.sort(juniorSvømmere, sorterRygcrawl);
        return juniorSvømmere;
    }

    public ArrayList<KonkurrenceSvømmer>  udregnButterflyJunior(){
        ArrayList <KonkurrenceSvømmer> juniorSvømmere = seJuniorSvømmere();
        SortérButterfly sorterButterfly = new SortérButterfly();
        Collections.sort(juniorSvømmere, sorterButterfly);
        return juniorSvømmere;
    }
    public ArrayList<KonkurrenceSvømmer>  udregnButterflySenior(){
        ArrayList <KonkurrenceSvømmer> seniorSvømmere = seSeniorSvømmere();
        SortérButterfly sortérButterfly = new SortérButterfly();
        Collections.sort(seniorSvømmere, sortérButterfly);
        return seniorSvømmere;
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
        return økonomi.udregnTotalKontingent();
    }

    public ArrayList<Medlem> seRestanceListe() {
        Økonomi økonomi = new Økonomi(db.medlemmer);
        return økonomi.getRestanceListe();
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
        fjernSvømmer(medlem);
        db.slet(medlem);
    }

    public void fjernSvømmer(Medlem medlem) {

        //KonkurrenceSvømmer konkurrenceSvømmer = db.findSvømmer(medlem.getNavn());
        db.fjernKonkurrenceSvømmer(medlem.getId());

    }

    public void tilføjSvømmer(Medlem medlem) {
        KonkurrenceSvømmer konkurrenceSvømmer = new KonkurrenceSvømmer(medlem.getNavn(), medlem.getFødselsdato(), medlem.getId(), false, false, false, false, 1000, 1000, 1000, 1000);
        db.tilføjKonkurrenceSvømmer(konkurrenceSvømmer);

    }

    public void opdaterSvømmere() throws FileNotFoundException {
        db.skrivKonkurrenceSvømmere();
        db.indlæs();
    }

    public int genererId() {return id = random.nextInt(999999) + 1;}
}
