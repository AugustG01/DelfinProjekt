import java.io.FileNotFoundException;
import java.util.Scanner;

public class Controller {
    DataBase db = new DataBase();
    Scanner in = new Scanner(System.in);

    public void seListe() {

    }

    public void tilføjMedlem() throws FileNotFoundException {
        System.out.print("Alder: ");
        int alder = in.nextInt();

        in.nextLine();
        System.out.print("Navn: ");
        String navn = in.nextLine();

        System.out.print("Aktivt medlemskab? ");
        String medlemskabSvar = in.nextLine();
        boolean medlemskab;
        switch (medlemskabSvar){
            case "ja", "j" -> medlemskab = true;
            case "nej", "n" -> medlemskab = false;
            default -> medlemskab = false;
        }

        System.out.print("Konkurrencesvømmer? ");
        String konkurrenceSvar = in.nextLine();
        boolean konkurrencesvømmer;
        switch (konkurrenceSvar){
            case "ja", "j" -> konkurrencesvømmer = true;
            case "nej", "n" -> konkurrencesvømmer = false;
            default -> konkurrencesvømmer = false;
        }

        System.out.print("Betalt? ");
        String betalt = in.nextLine();
        boolean restance;
        switch (betalt){
            case "ja", "j" -> restance = false;
            case "nej", "n" -> restance = true;
            default -> restance = false;
        }

        db.skriv(new Medlem(alder, navn, medlemskab, konkurrencesvømmer, restance));
    }

    public void indlæsMedlemmer() throws FileNotFoundException {
        db.indlæs();
    }

    public void ændrMedlem() {

    }

    public void sletMedlem() {

    }

    public void konkurrenceMenu() {

    }

    public void økonomiMenu() {

    }
}
