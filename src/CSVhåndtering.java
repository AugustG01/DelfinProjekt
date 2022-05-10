import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CSVhåndtering {
    private String filnavn;
    private Scanner filScanner;
    PrintStream printStream;


    public CSVhåndtering(String filnavn){
        this.filnavn = filnavn;
    }

    public void indlæsMedlemmer() throws FileNotFoundException {
        filScanner = new Scanner(new File(filnavn)).useDelimiter(";");
        while (filScanner.hasNextLine()) {
            int alder = filScanner.nextInt();
            String navn = filScanner.next();
            boolean aktivtMedlemskab = filScanner.nextBoolean();
            boolean konkurrenceSvømmer = filScanner.nextBoolean();
            boolean restance = filScanner.nextBoolean();
            Medlem indlæsMedlem = new Medlem(alder, navn, aktivtMedlemskab, konkurrenceSvømmer, restance);
            DataBase dataBase = new DataBase();
            dataBase.medlemmer.add(indlæsMedlem);
            System.out.println(dataBase.medlemmer);
        }
    }

    public void skrivMedlem(ArrayList<Medlem> medlemmer) throws FileNotFoundException {
        printStream = new PrintStream(filnavn);
        for(Medlem medlem : medlemmer) {
            printStream.print(medlem.getAlder());
            printStream.print(";");
            printStream.print(medlem.getNavn());
            printStream.print(";");
            printStream.print(medlem.getAktivtMedlemskab());
            printStream.print(";");
            printStream.print(medlem.getKonkurrenceSvømmer());
            printStream.print(";");
            printStream.print(medlem.getRestance());
            printStream.println();
        }
    }

}
