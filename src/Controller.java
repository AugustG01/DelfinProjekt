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
        boolean medlemskab = in.nextBoolean();

        System.out.print("Konkurrencesvømmer? ");
        boolean konkurrencesvømmer = in.nextBoolean();

        System.out.print("Betalt? ");
        String betalt = in.nextLine();
        boolean restance;
        switch (betalt){
            case "ja", "j" -> restance = false;
            case "nej", "n" -> restance = true;
            default -> restance = false;
        }

        db.tilføjMedlem(new Medlem(alder, navn, medlemskab, konkurrencesvømmer, restance));
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
