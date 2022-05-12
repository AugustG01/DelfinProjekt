import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVKonkurrence {

        private String filnavn;
        private Scanner filScanner;
        PrintStream printStream;


        public ArrayList<Konkurrence> indlæsKonkurrencer() throws FileNotFoundException {
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

        public void skrivMedlem(ArrayList<Medlem> medlemmer) throws FileNotFoundException {
            printStream = new PrintStream(filnavn);
            for(Medlem medlem : medlemmer) {
                printStream.print(medlem.getNavn());
                printStream.print(";");
                printStream.print(medlem.getAlder());
                printStream.print(";");
                printStream.print(medlem.getAktivtMedlemskab());
                printStream.print(";");
                printStream.print(medlem.getKonkurrenceSvømmer());
                printStream.print(";");
                printStream.print(medlem.getRestance());
                printStream.print(";");
                printStream.println();
            }
        }

    }
