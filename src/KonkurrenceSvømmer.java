import java.util.ArrayList;

public class KonkurrenceSvømmer extends Medlem{
    private boolean crawl;
    private boolean bryst;
    private boolean butterfly;
    private boolean rygCrawl;
    private double crawlRekord;
    private double brystRekord;
    private double rygCrawlRekord;
    private double butterflyRekord;
    ArrayList<Konkurrence> konkurrencer;

    public KonkurrenceSvømmer(Medlem medlem){
        super.setNavn(medlem.getNavn());
        super.setAlder(medlem.getAlder());
    }

    public KonkurrenceSvømmer(String navn, int alder, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance,
                              boolean bryst, boolean crawl, boolean rygCrawl, boolean butterfly){
        super(navn,  alder,  aktivtMedlemskab,  konkurrenceSvømmer, restance);
        this.bryst = bryst;
        this.crawl = crawl;
        this.butterfly = butterfly;
        this.rygCrawl = rygCrawl;
    }
    public KonkurrenceSvømmer(String navn,int alder,boolean crawl,boolean bryst,boolean butterfly,boolean rygCrawl,double crawlRekord,double brystRekord,double rygCrawlRekord,double butterflyRekord, ArrayList<Konkurrence> konkurrencer){
        super.setNavn(navn);
        super.setAlder(alder);
        this.crawl = crawl;
        this. bryst = bryst;
        this.butterfly = butterfly;
        this.rygCrawl = rygCrawl;
        this.crawlRekord = crawlRekord;
        this.brystRekord = brystRekord;
        this.rygCrawlRekord = rygCrawlRekord;
        this.butterflyRekord = butterflyRekord;
        this.konkurrencer = konkurrencer;
    }

    public boolean isCrawl() {
        return crawl;
    }

    public boolean isBryst() {
        return bryst;
    }

    public boolean isButterfly() {
        return butterfly;
    }

    public boolean isRygCrawl() {
        return rygCrawl;
    }

    public double getCrawlRekord() {
        return crawlRekord;
    }

    public double getBrystRekord() {
        return brystRekord;
    }

    public double getRygCrawlRekord() {
        return rygCrawlRekord;
    }

    public double getButterflyRekord() {
        return butterflyRekord;
    }

    public ArrayList<Konkurrence> getKonkurrencer() {
        return konkurrencer;
    }

    @Override
    public String toString() {
        return "Navn: " + super.getNavn() + " | " +
                "Alder: " + super.getAlder() + " | " +
                "crawl: " + crawl + " | " +
                "bryst: " + bryst + " | " +
                "butterfly: " + butterfly + " | " +
                "rygcrawl: " + rygCrawl + " | " +
                "crawl rekord: " + crawlRekord + " | " +
                "bryst rekord: " + brystRekord + " | " +
                "rygcrawl rekord: " + rygCrawlRekord + " | " +
                "butterfly rekord: " + butterflyRekord + " | " +
                "Konkurrencer: " + konkurrencer + " | " + "\n";
    }
}
