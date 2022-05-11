import java.io.FileNotFoundException;
import java.util.Scanner;

public class UI {
    private Controller controller;
    private boolean isRunning = true;

    Scanner in = new Scanner(System.in);

    public UI(Controller controller){
        this.controller = controller;
    }

    public void start() throws FileNotFoundException {
        System.out.println("Velkommen til Svømmeklubben Delfinens database");
        while (isRunning) {
            System.out.println("Hvad vil du gøre?");
            valgmuligheder();
            valg();
        }
    }

    public void valgmuligheder() {
        System.out.println("""
        (1) Se liste over medlemmer
        (2) Tilføj medlem
        (3) Ændr medlem
        (4) Slet medlem
        (5) Konkurrence menu
        (6) Økonomi menu
        (7) Indlæs liste af medlemmer (test)
        (0) Afslut programmet""");
    }
    public void valg() throws FileNotFoundException {
        int svar = in.nextInt();
        switch (svar){
            case 1 -> controller.seListe();
            case 2 -> tilføj();
            case 3 -> controller.ændrMedlem();
            case 4 -> controller.sletMedlem();
            case 5 -> controller.konkurrenceMenu();
            case 6 -> controller.økonomiMenu();
            case 7 -> controller.indlæsMedlemmer();
            case 0 -> afslut();
        }
    }
    public void tilføj() throws FileNotFoundException {
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
        controller.tilføjMedlem(alder, navn, medlemskab, konkurrencesvømmer, restance);
    }

    public void afslut() {
        System.out.println("Du har afsluttet programmet! Alle ændinger vil blive gemt");
        isRunning = false;
    }
}
