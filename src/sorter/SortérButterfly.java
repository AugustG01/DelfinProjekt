package sorter;

import database.KonkurrenceSvømmer;

import java.util.Comparator;

public class SortérButterfly implements Comparator<KonkurrenceSvømmer> {


    @Override
    public int compare(KonkurrenceSvømmer svømmer1, KonkurrenceSvømmer svømmer2) {
        if (svømmer1.getButterflyRekord() < svømmer2.getButterflyRekord()) return -1;
        if (svømmer1.getButterflyRekord() > svømmer2.getButterflyRekord()) return 1;
        else return 0;
    }
}


