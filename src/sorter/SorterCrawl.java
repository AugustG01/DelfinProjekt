package sorter;

import database.KonkurrenceSvømmer;

import java.util.Comparator;

public class SorterCrawl implements Comparator<KonkurrenceSvømmer> {

    @Override
    public int compare(KonkurrenceSvømmer svømmer1, KonkurrenceSvømmer svømmer2) {
        if (svømmer1.getCrawlRekord() < svømmer2.getCrawlRekord()) return -1;
        if (svømmer1.getCrawlRekord() > svømmer2.getCrawlRekord()) return 1;
        else return 0;
    }
}
