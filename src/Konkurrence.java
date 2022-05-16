
import java.util.ArrayList;
import java.util.Locale;

public class Konkurrence {
    private String konkurrenceNavn;
    private String dato;
    private double[] tider;
    ArrayList<KonkurrenceSvømmer> deltagere = new ArrayList<>();

    public Konkurrence(String konkurrenceNavn, String dato, ArrayList<KonkurrenceSvømmer> deltagere, double[] tider, String disciplin){
        this.konkurrenceNavn = konkurrenceNavn;
        this.dato = dato;
        this.deltagere = deltagere;
        this.tider = tider;

        switch (disciplin.toLowerCase(Locale.ROOT)){
            case "bryst" -> opdaterBrystRekorder();
            case "crawl" -> opdaterCrawlRekorder();
            case "rygcrawl" -> opdaterRygCrawlRekorder();
            case "butterfly" -> opdaterButterflyRekorder();
            default -> System.out.println("Det er ikke en mulig disciplin!");
        }
    }
    public Konkurrence(String konkurrenceNavn) {
        this.konkurrenceNavn = konkurrenceNavn;
    }

    public void opdaterBrystRekorder(){
        //tjekker om deltagerne har slået deres personlige rekord, og opdatere den i så fald
        for(int i = 0; i<deltagere.size(); i++){
                if (deltagere.get(i).getBrystRekord() > tider[i]) {
                    deltagere.get(i).setBrystRekord(tider[i]);
                }
        }
    }

    public void opdaterCrawlRekorder(){
        //tjekker om deltagerne har slået deres personlige rekord, og opdatere den i så fald
        for(int i = 0; i<deltagere.size(); i++){
            if (deltagere.get(i).getCrawlRekord() > tider[i]) {
                deltagere.get(i).setCrawlRekord(tider[i]);
            }
        }
    }

    public void opdaterRygCrawlRekorder(){
        //tjekker om deltagerne har slået deres personlige rekord, og opdatere den i så fald
        for(int i = 0; i<deltagere.size(); i++){
            if (deltagere.get(i).getRygCrawlRekord() > tider[i]) {
                deltagere.get(i).setRygCrawlRekord(tider[i]);
            }
        }
    }

    public void opdaterButterflyRekorder(){
        //tjekker om deltagerne har slået deres personlige rekord, og opdatere den i så fald
        for(int i = 0; i<deltagere.size(); i++){
            if (deltagere.get(i).getButterflyRekord() > tider[i]) {
                deltagere.get(i).setButterflyRekord(tider[i]);
            }
        }
    }

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



    @Override
    public String toString() {
        return "'" + konkurrenceNavn + "'" + dato + "|" + deltagere + "|";
    }
}
