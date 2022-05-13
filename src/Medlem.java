public class Medlem {
    private int alder;
    private String navn;
    private boolean aktivtMedlemskab;
    private boolean konkurrenceSvømmer;
    private boolean restance;

    public Medlem(String navn, int alder, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance) {
        setNavn(navn);
        setAlder(alder);
        setAktivtMedlemskab(aktivtMedlemskab);
        setKonkurrenceSvømmer(konkurrenceSvømmer);
        setRestance(restance);
    }

    public Medlem() {

    }


    public int getAlder(){
        return alder;
    }
    public void setAlder(int alder){
        this.alder = alder;
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
        return "Navn: " + navn + " | " +
                "Alder: " + alder + " | " +
                "Aktivt medlemskab: " + aktivtMedlemskab + " | " +
                "Konkurrence svømmer: " + konkurrenceSvømmer + " | " +
                "Restance: " + restance + " | " + "\n";
    }
}
