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

    public KonkurrenceSvømmer(){
        super();
    }

    public KonkurrenceSvømmer(String navn, int alder, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance,
                              boolean bryst, boolean crawl, boolean rygCrawl, boolean butterfly){
        super(navn,  alder,  aktivtMedlemskab,  konkurrenceSvømmer, restance);
        this.bryst = bryst;
        this.crawl = crawl;
        this.butterfly = butterfly;
        this.rygCrawl = rygCrawl;
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
}
