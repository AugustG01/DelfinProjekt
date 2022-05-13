import java.util.ArrayList;

public class Konkurrence {
    private String konkurrenceNavn;
    private String dato;
    ArrayList<KonkurrenceSvømmer> deltagere = new ArrayList<>();


    public String getKonkurrenceNavn() {
        return konkurrenceNavn;
    }

    public String getDato() {
        return dato;
    }

    public ArrayList<KonkurrenceSvømmer> getDeltagere() {
        return deltagere;
    }
}
