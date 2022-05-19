package database;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Random;

public class Medlem {
    private int alder;
    private String navn;
    private boolean aktivtMedlemskab;
    private boolean konkurrenceSvømmer;
    private boolean restance;
    public int id;
    Random random = new Random();

    /*
    public Medlem(String navn, int alder, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance, int id) {
        setNavn(navn);
        setAlder(alder);
        setAktivtMedlemskab(aktivtMedlemskab);
        setKonkurrenceSvømmer(konkurrenceSvømmer);
        setRestance(restance);
        setId(id);
    }

     */

    public Medlem(String navn, LocalDate fødselsDato, boolean aktivtMedlemskab, boolean restance, int id) {
        setNavn(navn);
        setFødselsdato(fødselsDato); //var førhen alder, kan være det skal ændres tilbage
        setAktivtMedlemskab(aktivtMedlemskab);
        setRestance(restance);
        setId(id);
    }


    public Medlem(String navn, LocalDate fødselsDato, boolean aktivtMedlemskab, boolean restance) {
        setNavn(navn);
        setFødselsdato(fødselsDato);
        setAktivtMedlemskab(aktivtMedlemskab);
        setRestance(restance);
        generérId();
    }

    public Medlem() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public void generérId() {
        id = random.nextInt(999999) + 1;
    }

    public void setFødselsdato(LocalDate date) {
        this.alder = (int) ChronoUnit.YEARS.between(date, LocalDate.now());
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public int getAlder() {
        return alder;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public boolean getAktivtMedlemskab() {
        return aktivtMedlemskab;
    }

    public void setAktivtMedlemskab(boolean aktivtMedlemskab) {
        this.aktivtMedlemskab = aktivtMedlemskab;
    }

    public boolean getKonkurrenceSvømmer() {
        return konkurrenceSvømmer;
    }

    public void setKonkurrenceSvømmer(boolean konkurrenceSvømmer) {
        this.konkurrenceSvømmer = konkurrenceSvømmer;
    }

    public boolean getRestance() {
        return restance;
    }

    public void setRestance(boolean restance) {
        this.restance = restance;
    }

    public boolean matcher(String søg) {
        return navn.toLowerCase().contains(søg);
    }

    @Override
    public String toString() {
        String tmp = "Navn: " + navn + " | " +
                "Alder: " + alder + " | " +
                "Aktivt medlemskab: " + aktivtMedlemskab + " | " +
                "Konkurrence svømmer: " + konkurrenceSvømmer + " | " +
                "Restance: " + restance + " | " + "\n";
        return tmp.replaceAll("true", "ja").replaceAll("false", "nej");
    }
}
