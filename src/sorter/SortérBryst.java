package sorter;

import java.util.Comparator;
import database.*;


public class SortérBryst implements Comparator<KonkurrenceSvømmer> {


    @Override
    public int compare(KonkurrenceSvømmer svømmer1, KonkurrenceSvømmer svømmer2) {
        if (svømmer1.getBrystRekord() < svømmer2.getBrystRekord()) return -1;
        if (svømmer1.getBrystRekord() > svømmer2.getBrystRekord()) return 1;
        else return 0;
    }
}
