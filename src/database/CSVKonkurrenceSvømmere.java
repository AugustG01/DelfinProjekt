package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class CSVKonkurrenceSvømmere {

        private String filnavn;
        private Scanner filScanner;
        PrintStream printStream;

        public CSVKonkurrenceSvømmere(String filnavn){
            this.filnavn = filnavn;
        }


        public ArrayList<KonkurrenceSvømmer> indlæsKonkurrenceSvømmere() throws FileNotFoundException {
            filScanner = new Scanner(new File(filnavn)).useDelimiter(";");
            ArrayList<KonkurrenceSvømmer> indlæsteKonkurrenceSvømmere = new ArrayList<>();
            while (filScanner.hasNextLine()) {
                // Bruger Locale.ENGLISH for at undgå Scanneren forstår punktum i stedet for komma i indlæsning af double
                Scanner linjeScanner = new Scanner(filScanner.nextLine()).useDelimiter(";").useLocale(Locale.ENGLISH);
                String navn = linjeScanner.next();
                String fødselsdato = linjeScanner.next();
                boolean crawl = linjeScanner.nextBoolean();
                boolean bryst = linjeScanner.nextBoolean();
                boolean butterfly = linjeScanner.nextBoolean();
                boolean rygCrawl = linjeScanner.nextBoolean();
                double crawlRekord = linjeScanner.nextDouble();
                double brystRekord = linjeScanner.nextDouble();
                double rygCrawlRekord = linjeScanner.nextDouble();
                double butterflyRekord = linjeScanner.nextDouble();
                int fastId = linjeScanner.nextInt();
                String træner = linjeScanner.next();
                //ArrayList<Konkurrence> konkurrencer = indlæsKonkurrencer(linjeScanner);
                //filScanner.nextLine();
                indlæsteKonkurrenceSvømmere.add(new KonkurrenceSvømmer(navn,fødselsdato,fastId,crawl,bryst,butterfly,rygCrawl,crawlRekord,brystRekord,rygCrawlRekord,butterflyRekord, træner));

            }
            return indlæsteKonkurrenceSvømmere;
        }
        /*
        public ArrayList<Konkurrence> indlæsKonkurrencer(Scanner linjeScanner){
            ArrayList<Konkurrence> konkurrencer = new ArrayList<>();
            while(linjeScanner.hasNext()){
                Konkurrence konkurrence = new Konkurrence(linjeScanner.next(), linjeScanner.next());
                konkurrencer.add(konkurrence);
            }
            return konkurrencer;
        }
        */


        public void skrivSvømmer(ArrayList<KonkurrenceSvømmer> svømmere) throws FileNotFoundException {
            printStream = new PrintStream(filnavn);
            for(KonkurrenceSvømmer svømmer : svømmere) {
                printStream.print(svømmer.getNavn());
                printStream.print(";");
                printStream.print(svømmer.getFødselsdato());
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
                printStream.print(svømmer.getId());
                printStream.print(";");
                printStream.print(svømmer.getTræner());
                printStream.print(";");

                //printStream.print(printKonkurrenceListe(svømmer.getKonkurrencer()));
                printStream.println();
            }
        }

        public String printKonkurrenceListe(ArrayList<Konkurrence> konkurrencer){
            StringBuilder tmp = new StringBuilder();
            if(konkurrencer!=null) {
                for (Konkurrence konkurrence : konkurrencer) {
                    tmp.append(konkurrence.getKonkurrenceNavn());
                    tmp.append(";");
                    tmp.append(konkurrence.getDato());
                    tmp.append(";");
                }
                return tmp.toString();
            }
            else {
                return "Ingen konkurrencer endnu" + ";" + "ingen dato;" ;
            }
        }

    }
