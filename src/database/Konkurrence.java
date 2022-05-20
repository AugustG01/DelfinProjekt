package database;

import java.util.ArrayList;

public class Konkurrence {
    private String konkurrenceNavn;
    private String dato;
    private double[] tider;

    ArrayList<KonkurrenceSvømmer> deltagere = new ArrayList<>();

    public Konkurrence(String dato, ArrayList<KonkurrenceSvømmer> deltagere, double[] tider, String disciplin) {
        this.dato = dato;
        this.deltagere = deltagere;
        this.tider = tider;

        //opdaterNyKonkurrence(konkurrenceNavn);

        switch (disciplin) {
            case "bryst" -> opdaterBrystRekorder();
            case "crawl" -> opdaterCrawlRekorder();
            case "rygcrawl" -> opdaterRygCrawlRekorder();
            case "butterfly" -> opdaterButterflyRekorder();
        }
    }

    public Konkurrence(String konkurrenceNavn, String dato) {
        setKonkurrenceNavn(konkurrenceNavn);
        this.dato = dato;
    }

    public void opdaterBrystRekorder() {
        //tjekker om deltagerne har slået deres personlige rekord, og opdatere den i så fald
        for (int i = 0; i < deltagere.size(); i++) {
            if (deltagere.get(i).getBrystRekord() > tider[i]) {
                deltagere.get(i).setBrystRekord(tider[i]);
                deltagere.get(i).setBryst(true);
            }
        }
    }

    public void opdaterCrawlRekorder() {
        //tjekker om deltagerne har slået deres personlige rekord, og opdatere den i så fald
        for (int i = 0; i < deltagere.size(); i++) {
            if (deltagere.get(i).getCrawlRekord() > tider[i]) {
                deltagere.get(i).setCrawlRekord(tider[i]);
                deltagere.get(i).setCrawl(true);
            }
        }
    }

    public void opdaterRygCrawlRekorder() {
        //tjekker om deltagerne har slået deres personlige rekord, og opdatere den i så fald
        for (int i = 0; i < deltagere.size(); i++) {
            if (deltagere.get(i).getRygCrawlRekord() > tider[i]) {
                deltagere.get(i).setRygCrawlRekord(tider[i]);
                deltagere.get(i).setRygCrawl(true);
            }
        }
    }

    public void opdaterButterflyRekorder() {
        //tjekker om deltagerne har slået deres personlige rekord, og opdatere den i så fald
        for (int i = 0; i < deltagere.size(); i++) {
            if (deltagere.get(i).getButterflyRekord() > tider[i]) {
                deltagere.get(i).setButterflyRekord(tider[i]);
                deltagere.get(i).setButterfly(true);
            }
        }
    }
/*
    public void opdaterNyKonkurrence(String konkurrenceNavn) {
        for (int i = 0; i < deltagere.size(); i++) {
            deltagere.get(i).tilføjKonkurrence(new Konkurrence(konkurrenceNavn, dato));
        }
    }

 */

    public String getKonkurrenceNavn() {
        return konkurrenceNavn;
    }

    public void setKonkurrenceNavn(String konkurrenceNavn) {
        this.konkurrenceNavn = konkurrenceNavn;
    }

    public String getDato() {
        return dato;
    }

    public ArrayList<KonkurrenceSvømmer> getDeltagere() {
        return deltagere;
    }

    public double[] getTider(){
        return tider;
    }


    @Override
    public String toString() {
        return "|" + konkurrenceNavn + " , " + dato + "|";
    }
}
