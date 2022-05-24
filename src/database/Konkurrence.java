package database;

import java.util.ArrayList;

public class Konkurrence {
    private String konkurrenceNavn;
    private String dato;
    private double[] tider;

    ArrayList<KonkurrenceSvømmer> deltagere;

    public Konkurrence(String dato, ArrayList<KonkurrenceSvømmer> deltagere, double[] tider, String disciplin) {
        this.dato = dato;
        this.deltagere = deltagere;
        this.tider = tider;

        switch (disciplin) {
            case "bryst" -> opdaterBrystRekorder();
            case "crawl" -> opdaterCrawlRekorder();
            case "rygcrawl" -> opdaterRygCrawlRekorder();
            case "butterfly" -> opdaterButterflyRekorder();
        }
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
        for (int i = 0; i < deltagere.size(); i++) {
            if (deltagere.get(i).getCrawlRekord() > tider[i]) {
                deltagere.get(i).setCrawlRekord(tider[i]);
                deltagere.get(i).setCrawl(true);
            }
        }
    }

    public void opdaterRygCrawlRekorder() {
        for (int i = 0; i < deltagere.size(); i++) {
            if (deltagere.get(i).getRygCrawlRekord() > tider[i]) {
                deltagere.get(i).setRygCrawlRekord(tider[i]);
                deltagere.get(i).setRygCrawl(true);
            }
        }
    }

    public void opdaterButterflyRekorder() {
        for (int i = 0; i < deltagere.size(); i++) {
            if (deltagere.get(i).getButterflyRekord() > tider[i]) {
                deltagere.get(i).setButterflyRekord(tider[i]);
                deltagere.get(i).setButterfly(true);
            }
        }
    }

    @Override
    public String toString() {
        return "|" + konkurrenceNavn + " , " + dato + "|";
    }
}
