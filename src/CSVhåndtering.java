import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
        int alder = filScanner.nextInt();
        String navn = filScanner.next();
        boolean aktivtMedlemskab = filScanner.nextBoolean();
        boolean konkurrenceSvømmer = filScanner.nextBoolean();
        boolean restance = filScanner.nextBoolean();
        Medlem indlæsMedlem = new Medlem(alder, navn, aktivtMedlemskab, konkurrenceSvømmer, restance);

    }

    public void skrivMedlem(Medlem medlem) throws FileNotFoundException {
        printStream = new PrintStream(filnavn);

        printStream.print(medlem.getAlder());
        printStream.print(";");
        printStream.print(medlem.getNavn());
        printStream.print(";");
        printStream.print(medlem.getAktivtMedlemskab());
        printStream.print(";");
        printStream.print(medlem.getKonkurrenceSvømmer());
        printStream.print(";");
        printStream.print(medlem.getRestance());
    }

}
