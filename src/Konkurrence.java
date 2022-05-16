
import java.util.ArrayList;

public class Konkurrence {
    private String konkurrenceNavn;
    private String dato;
    private double[] tider;
    ArrayList<KonkurrenceSvømmer> deltagere = new ArrayList<>();

    public Konkurrence(String konkurrenceNavn, String dato, ArrayList<KonkurrenceSvømmer> deltagere, double[] tider){
        this.konkurrenceNavn = konkurrenceNavn;
        this.dato = dato;
        this.deltagere = deltagere;
        this.tider = tider;
        opdaterBrystRekorder();
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
