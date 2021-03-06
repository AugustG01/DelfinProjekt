package database;
public class  KonkurrenceSvømmer extends Medlem{
    private String træner = "";
    private boolean crawl;
    private boolean bryst;
    private boolean butterfly;
    private boolean rygCrawl;
    private double crawlRekord;
    private double brystRekord;
    private double rygCrawlRekord;
    private double butterflyRekord;

    public void setTræner(String træner) {
        this.træner = træner;
    }

    public String getTræner() {
        return træner;
    }

    public KonkurrenceSvømmer(String navn, String fødselsdato, int fastId, boolean crawl, boolean bryst, boolean butterfly, boolean rygCrawl, double crawlRekord, double brystRekord, double rygCrawlRekord, double butterflyRekord, String træner){
        super(navn, fødselsdato, fastId);
        this.crawl = crawl;
        this.bryst = bryst;
        this.butterfly = butterfly;
        this.rygCrawl = rygCrawl;
        this.crawlRekord = crawlRekord;
        this.brystRekord = brystRekord;
        this.rygCrawlRekord = rygCrawlRekord;
        this.butterflyRekord = butterflyRekord;
        this.træner = træner;
    }

    public void setCrawl(boolean crawl) {
        this.crawl = crawl;
    }

    public void setBryst(boolean bryst) {
        this.bryst = bryst;
    }

    public void setButterfly(boolean butterfly) {
        this.butterfly = butterfly;
    }

    public void setRygCrawl(boolean rygCrawl) {
        this.rygCrawl = rygCrawl;
    }

    public void setCrawlRekord(double crawlRekord){
        this.crawlRekord = crawlRekord;
    }
    public void setBrystRekord(double brystRekord){
        this.brystRekord = brystRekord;
    }
    public void setRygCrawlRekord(double rygCrawlRekord){
        this.rygCrawlRekord = rygCrawlRekord;
    }
    public void setButterflyRekord(double butterflyRekord){
        this.butterflyRekord = butterflyRekord;
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


    @Override
    public String toString() {
        String tmp = String.format("Navn: %-10s | " +
                "Alder: %-10d | " +
                "Crawl:  %-10b | " +
                "Bryst:  %-10b | " +
                "Butterfly: %-10b | " +
                "Rygcrawl:  %-10b | " +
                "Crawl rekord: %-10.2f | " +
                "Bryst rekord: %-10.2f | " +
                "Rygcrawl rekord: %-10.2f | " +
                "Butterfly rekord: %-10.2f  | "
                + "Træner: %-10s"+ "\n",super.getNavn(), super.getAlder(), crawl, bryst, butterfly, rygCrawl, crawlRekord, brystRekord, rygCrawlRekord, butterflyRekord, træner);
        return tmp.replaceAll("true", "ja").replaceAll("false", "nej");
    }
}
