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


    public KonkurrenceSvømmer(String navn, int alder, boolean aktivtMedlemskab, boolean konkurrenceSvømmer, boolean restance,
                              boolean bryst, boolean crawl, boolean rygCrawl, boolean butterfly){
        super(navn,  alder,  aktivtMedlemskab,  konkurrenceSvømmer, restance);
        this.bryst = bryst;
        this.crawl = crawl;
        this.butterfly = butterfly;
        this.rygCrawl = rygCrawl;
    }

}
