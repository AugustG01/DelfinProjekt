package database;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVMedlemmer {
    private String filnavn;
    private Scanner filScanner;
    PrintStream printStream;



    public CSVMedlemmer(String filnavn){
        this.filnavn = filnavn;
    }

    public ArrayList<Medlem> indlæsMedlemmer() throws FileNotFoundException {
        filScanner = new Scanner(new File(filnavn)).useDelimiter(";");
        ArrayList<Medlem> indlæsteMedlemmer = new ArrayList<>();
        while (filScanner.hasNextLine()) {
            String navn = filScanner.next();
            String fødselsdato = filScanner.nextLine();
            LocalDate alder = LocalDate.parse(fødselsdato);
            boolean aktivtMedlemskab = filScanner.nextBoolean();
            boolean konkurrenceSvømmer = filScanner.nextBoolean();
            boolean restance = filScanner.nextBoolean();
            int fastId = filScanner.nextInt();
            filScanner.nextLine();

            indlæsteMedlemmer.add(new Medlem(navn, alder, aktivtMedlemskab, konkurrenceSvømmer, restance, fastId));
        }
            return indlæsteMedlemmer;
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
            printStream.print(medlem.getId());
            printStream.print(";");

            printStream.println();
        }
    }

}
