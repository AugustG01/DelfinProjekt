package database;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class Medlem {
    private int alder;
    private String navn;
    private boolean aktivtMedlemskab;
    private boolean konkurrenceSvømmer;
    private boolean restance = false;
    private int id;
    private String fødselsdato;

/*
    public Medlem(String navn, int alder, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance) {
        setNavn(navn);
        setAlder(alder);
        setAktivtMedlemskab(aktivtMedlemskab);
        setKonkurrenceSvømmer(konkurrenceSvømmer);
        setRestance(restance);
    }
 */


    //Medlems konstruktør til konkurrencesvømmere
    public Medlem(String navn, String fødselsDato, int fastId) {
        setNavn(navn);
        setFødselsdato(fødselsDato);
        setId(fastId);
        setAlder(fødselsDato);
    }

    //Medlems konstruktør til ikke konkurrencesvømmere
    public Medlem(String navn, String fødselsDato, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, int fastId) {
        setNavn(navn);
        setFødselsdato(fødselsDato);
        setAktivtMedlemskab(aktivtMedlemskab);
        setKonkurrenceSvømmer(konkurrenceSvømmer);
        setId(fastId);
        setAlder(fødselsDato);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlder(){
        return alder;
    }

    public void setAlder(String fødselsdato){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localdate = LocalDate.parse(fødselsdato, dateTimeFormatter);
        this.alder = (int) ChronoUnit.YEARS.between(localdate, LocalDate.now());
    }

    public void setFødselsdato(String fødselsdato) {
        this.fødselsdato = fødselsdato;
    }

    public String getFødselsdato() {
        return fødselsdato;
    }

    public String getNavn(){
        return navn;
    }
    public void setNavn(String navn){
        this.navn = navn;
    }
    public boolean getAktivtMedlemskab(){
        return aktivtMedlemskab;
    }
    public void setAktivtMedlemskab(boolean aktivtMedlemskab){
        this.aktivtMedlemskab = aktivtMedlemskab;
    }
    public boolean getKonkurrenceSvømmer(){
        return konkurrenceSvømmer;
    }
    public void setKonkurrenceSvømmer(boolean konkurrenceSvømmer){
        this.konkurrenceSvømmer = konkurrenceSvømmer;
    }
    public boolean getRestance(){
        return restance;
    }
    public void setRestance(boolean restance){
        this.restance = restance;
    }

    public boolean matcher(String søg){
        return navn.toLowerCase().contains(søg);
    }

    @Override
    public String toString() {
        String tmp =  "Navn: " + navn + " | " +
                "Alder: " + alder + " | " +
                "Aktivt medlemskab: " + aktivtMedlemskab + " | " +
                "Konkurrence svømmer: " + konkurrenceSvømmer + " | " +
                "Restance: " + restance + " | " + "\n";
        return tmp.replaceAll("true", "ja").replaceAll("false", "nej");
    }
}
