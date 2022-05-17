package sorter;

import java.util.Comparator;
import database.*;


public class SorterRygCrawl
        implements Comparator<KonkurrenceSvømmer> {


    @Override
    public int compare(KonkurrenceSvømmer svømmer1, KonkurrenceSvømmer svømmer2) {
        if (svømmer1.getRygCrawlRekord() < svømmer2.getRygCrawlRekord()) return -1;
        if (svømmer1.getRygCrawlRekord() > svømmer2.getRygCrawlRekord()) return 1;
        else return 0;
    }
}