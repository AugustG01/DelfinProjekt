package database;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import core.*;

public class DataBase {
    public ArrayList<Medlem> medlemmer = new ArrayList<>();
    ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere = new ArrayList<>();
    ArrayList<KonkurrenceSvømmer> juniorSvømmere = new ArrayList<>();
    ArrayList<KonkurrenceSvømmer> seniorSvømmere = new ArrayList<>();
    ArrayList<Konkurrence> konkurrencer = new ArrayList<>();
    String medlemsFil = "medlemmer.csv";
    String konkurrenceSvømmerFil = "svømmere.csv";

    public ArrayList<KonkurrenceSvømmer> getJuniorSvømmere() {
        return juniorSvømmere;
    }

    public ArrayList<KonkurrenceSvømmer> getSeniorSvømmere() {
        return seniorSvømmere;
    }


    public void skrivMedlemmer() throws FileNotFoundException {

        CSVMedlemmer csvMedlemmer = new CSVMedlemmer(medlemsFil);
        csvMedlemmer.skrivMedlem(medlemmer);
    }
    public void opdelIJuniorOgSenior(){
        for(KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmere){
            if(konkurrenceSvømmer.getAlder() < 18){
                juniorSvømmere.add(konkurrenceSvømmer);
            }
            else {
                seniorSvømmere.add(konkurrenceSvømmer);
            }
        }
    }



    public void skrivKonkurrenceSvømmere() throws FileNotFoundException {
        CSVKonkurrenceSvømmere csvKonkurrenceSvømmere = new CSVKonkurrenceSvømmere(konkurrenceSvømmerFil);

        csvKonkurrenceSvømmere.skrivSvømmer(konkurrenceSvømmere);
    }

    public void tilføjMedlem(Medlem medlem) {
        medlemmer.add(medlem);
    }

    public void tilføjKonkurrenceSvømmer(KonkurrenceSvømmer konkurrenceSvømmer ) {
        konkurrenceSvømmere.add(konkurrenceSvømmer);
    }
    public void tilføjKonkurrence(String konkurrenceNavn, String dato, ArrayList<KonkurrenceSvømmer> deltagere, double[] tider, String disciplin){
        konkurrencer.add(new Konkurrence(konkurrenceNavn, dato, deltagere, tider, disciplin));
    }

    public void indlæs() throws FileNotFoundException {
        CSVMedlemmer csvMedlemmer = new CSVMedlemmer(medlemsFil);
        CSVKonkurrenceSvømmere csvKonkurrenceSvømmere = new CSVKonkurrenceSvømmere(konkurrenceSvømmerFil);
        medlemmer = csvMedlemmer.indlæsMedlemmer();
        konkurrenceSvømmere = csvKonkurrenceSvømmere.indlæsKonkurrenceSvømmere();
        opdelIJuniorOgSenior();
    }
    public void fjernKonkurrenceSvømmer(Medlem medlem){

        konkurrenceSvømmere.remove(medlem);
    }

    public ArrayList<Medlem> seListeAfMedlemmer() {
        return medlemmer;
    }


    public ArrayList<KonkurrenceSvømmer> seListeAfKonkurrenceSvømmere(){
            return konkurrenceSvømmere;
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

    public ArrayList<KonkurrenceSvømmer> findSvømmer(String søg){
        ArrayList<KonkurrenceSvømmer> fundneSvømmere = new ArrayList<>();
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmere){
            if(konkurrenceSvømmer.matcher(søg))
                fundneSvømmere.add(konkurrenceSvømmer);
        }
        return fundneSvømmere;
    }
}
