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
        boolean restance = in.nextBoolean();
        db.tilføjMedlem(new Medlem(alder, navn, medlemskab, konkurrencesvømmer, restance));
    }

    // TODO: 10/05/2022 husk exceptionshåndtering 
    public void gem() throws FileNotFoundException {
        db.skriv();
    }

    public void indlæsMedlemmer() throws FileNotFoundException {
        db.indlæs();
    }
}
