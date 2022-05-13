import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVKonkurrenceSvømmere {

        private String filnavn;
        private Scanner filScanner;
        PrintStream printStream;

        public CSVKonkurrenceSvømmere(String filnavn){
            this.filnavn = filnavn;
        }

        /*

        public ArrayList<KonkurrenceSvømmer> indlæsKonkurrenceSvømmere() throws FileNotFoundException {
            filScanner = new Scanner(new File(filnavn)).useDelimiter(";");
            ArrayList<Konkurrence> indlæsteKonkurrencer = new ArrayList<>();
            while (filScanner.hasNextLine()) {
                String navn = filScanner.next();
                int alder = filScanner.nextInt();
                boolean aktivtMedlemskab = filScanner.nextBoolean();
                boolean konkurrenceSvømmer = filScanner.nextBoolean();
                boolean restance = filScanner.nextBoolean();
                filScanner.nextLine();

             //   indlæsteKonkurrencer.add(new Konkurrence(navn, alder, aktivtMedlemskab, konkurrenceSvømmer, restance));
            }
            return indlæsteKonkurrencer;
        }
        */

        public void skrivSvømmer(ArrayList<KonkurrenceSvømmer> svømmere) throws FileNotFoundException {
            printStream = new PrintStream(filnavn);
            for(KonkurrenceSvømmer svømmer : svømmere) {
                printStream.print(svømmer.getNavn());
                printStream.print(";");
                printStream.print(svømmer.getAlder());
                printStream.print(";");
                printStream.print(svømmer.isCrawl());
                printStream.print(";");
                printStream.print(svømmer.isBryst());
                printStream.print(";");
                printStream.print(svømmer.isButterfly());
                printStream.print(";");
                printStream.print(svømmer.isRygCrawl());
                printStream.print(";");
                printStream.print(svømmer.getCrawlRekord());
                printStream.print(";");
                printStream.print(svømmer.getBrystRekord());
                printStream.print(";");
                printStream.print(svømmer.getRygCrawlRekord());
                printStream.print(";");
                printStream.print(svømmer.getButterflyRekord());
                printStream.print(";");
                printStream.print(printKonkurrenceListe(svømmer.getKonkurrencer()));
                printStream.println();
            }
        }

        public String printKonkurrenceListe(ArrayList<Konkurrence> konkurrencer){
            StringBuilder tmp = new StringBuilder();
            if(konkurrencer!=null) {
                for (Konkurrence konkurrence : konkurrencer) {
                    tmp.append(konkurrence.getKonkurrenceNavn());
                    tmp.append(";");
                }
                return tmp.toString();
            }
            else {
                return "ingen konkurrencer endnu" + ";";
            }
        }

    }
