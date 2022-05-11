import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class UI {
    private Controller controller;
    private boolean isRunning = true;

    Scanner in = new Scanner(System.in);

    public UI(Controller controller) {
        this.controller = controller;
    }

    public void start() throws FileNotFoundException {
        System.out.println("Velkommen til Svømmeklubben Delfinens database");
        controller.indlæsMedlemmer();
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
                (7) Søg efter navn
                (0) Afslut programmet""");
    }

    public void valg() throws FileNotFoundException {
        int svar = in.nextInt();
        switch (svar) {
            case 1 -> controller.seListe();
            case 2 -> tilføj();
            case 3 -> findMedlem();
            case 4 -> controller.konkurrenceMenu();
            case 5 -> controller.økonomiMenu();
            case 0 -> afslut();
        }
    }

    public void tilføj() throws FileNotFoundException {
        in.nextLine();
        System.out.print("Navn: ");
        String navn = in.nextLine();

        System.out.print("Alder: ");
        int alder = in.nextInt();

        in.nextLine();
        System.out.print("Aktivt medlemskab? ");
        String medlemskabSvar = in.nextLine();
        boolean medlemskab;
        switch (medlemskabSvar) {
            case "ja", "j" -> medlemskab = true;
            case "nej", "n" -> medlemskab = false;
            default -> medlemskab = false;
        }

        System.out.print("Konkurrencesvømmer? ");
        String konkurrenceSvar = in.nextLine();
        boolean konkurrencesvømmer;
        switch (konkurrenceSvar) {
            case "ja", "j" -> konkurrencesvømmer = true;
            case "nej", "n" -> konkurrencesvømmer = false;
            default -> konkurrencesvømmer = false;
        }

        System.out.print("Betalt? ");
        String betalt = in.nextLine();
        boolean restance;
        switch (betalt) {
            case "ja", "j" -> restance = false;
            case "nej", "n" -> restance = true;
            default -> restance = false;
        }
        controller.tilføjMedlem(navn, alder, medlemskab, konkurrencesvømmer, restance);
    }

    public void afslut() throws FileNotFoundException {
        System.out.println("Du har afsluttet programmet! Alle ændringer vil blive gemt");
        controller.gem();
        System.out.println(controller.db.medlemmer.size());
        isRunning = false;
    }

    public void findMedlem() {
        ArrayList<Medlem> fundneMedlemmer = new ArrayList<>();
        System.out.println("""
                Find et medlem
                --------------
                Skriv navnet eller dele af navnet for at finde et medlem.""");
        in.nextLine();
        System.out.print(": ");
        String søg = in.nextLine().trim().toLowerCase();
        fundneMedlemmer = controller.findMedlem(søg);

        // TODO: 11/05/2022 flyt sout
        int i = 1;
        for (Medlem medlem : fundneMedlemmer) {
            System.out.println("#" + i + ". " + medlem);
            i++;
        }
        System.out.println("Indtast nummeret på det medlem du vil ændre/fjerne: ");
        vælgMedlem(fundneMedlemmer);

    }

    public void vælgMedlem(ArrayList<Medlem> fundneMedlemmer) {
        int valg = in.nextInt();
        Medlem medlem;
        medlem = fundneMedlemmer.get(valg - 1);
        System.out.println("""
                Hvad vil du gøre?
                (1) Ændre oplysninger på medlem
                (2) Slet medlem fra databasen
                (3) Annuller""");
        int andetValg = in.nextInt();
        switch (andetValg) {
            case 1 -> ændreMedlem();
            case 2 -> controller.sletMedlem(medlem);
            default -> System.out.println("Du bliver nu sendt tilbage til hovedmenuen");
        }
    }
    public void ændreMedlem(){
        System.out.println("IKKE IMPLEMENTERET");
    }
}
