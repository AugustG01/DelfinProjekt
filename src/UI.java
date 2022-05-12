import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
            valgmulighederHovedmenu();
        }
    }

    public void valgmulighederHovedmenu() throws FileNotFoundException {
        System.out.println("""
                (1) Se liste over medlemmer
                (2) Tilføj medlem
                (3) Søg efter medlem
                    - Ændre medlem
                    - Slet medlem
                (4) Konkurrence menu
                (5) Økonomi menu
                (0) Afslut programmet""");
        hovedMenu();
    }

    public void hovedMenu() throws FileNotFoundException {
        try {
            int svar = in.nextInt();
            switch (svar) {
                case 1 -> controller.seListe();
                case 2 -> tilføj();
                case 3 -> findMedlem();
                case 4 -> controller.konkurrenceMenu();
                case 5 -> controller.økonomiMenu();
                case 0 -> afslut();
            }
        } catch (InputMismatchException ime) {
            fejl();
            in.next();
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

        if (fundneMedlemmer.size() > 0) {
            // TODO: 11/05/2022 flyt sout
            int i = 1;
            for (Medlem medlem : fundneMedlemmer) {
                System.out.println("#" + i + ". " + medlem);
                i++;
            }
            System.out.println("Indtast nummeret på det medlem du vil ændre/fjerne: ");
            vælgMedlem(fundneMedlemmer);
        } else {
            System.out.println("Fandt ingen medlemmer i systemet! Prøv igen: ");
            findMedlem();
        }
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
        try {
            int andetValg = in.nextInt();
            switch (andetValg) {
                case 1 -> ændreMedlem(medlem);
                case 2 -> controller.sletMedlem(medlem);
                case 3 -> System.out.println("Du bliver nu sendt tilbage til hovedmenuen");
            }
        } catch (InputMismatchException ime) {
            fejl();
            in.next();
        }
    }

    public void ændreMedlem(Medlem medlem) {
        System.out.println("""
                Hvad vil du ændre?
                (1) Konkurrence status
                (2) Medlemskab
                (3) Restance
                """);
        try {
            int valg = in.nextInt();
            switch (valg) {
                case 1 -> ændrKonkurrenceStatus(medlem);
                case 2 -> ændrAktivMedlem(medlem);
                case 3 -> ændrRestance(medlem);
                default -> {
                    fejl();
                    ændreMedlem(medlem);
                }
            }
        } catch (InputMismatchException ime) {
            fejl();
            in.next();
        }
    }

    public void ændrKonkurrenceStatus(Medlem medlem) {
        in.nextLine();
        boolean rigtigtInput = false;
        System.out.println("Konkurrence status på " + medlem.getNavn() + " er lige nu : " + medlem.getKonkurrenceSvømmer());// TODO: 12/05/2022 Ændr fra true/false til noget pænere
        while (!rigtigtInput) {
            rigtigtInput = true;
            System.out.println("Hvad vil du ændre konkurrence status til? ");
            String valg = in.nextLine().toLowerCase();
            switch (valg) {
                case "ja", "j", "true" -> medlem.setKonkurrenceSvømmer(true);
                case "nej", "n", "false" -> medlem.setKonkurrenceSvømmer(false);
                default -> {
                    fejl();
                    rigtigtInput = false;
                }
            }
        }
        System.out.println(medlem.getNavn() + " er nu ændret til " + medlem.getKonkurrenceSvømmer());
    }

    public void ændrAktivMedlem(Medlem medlem) {
        in.nextLine();
        boolean rigtigtInput = false;
        while (!rigtigtInput) {
            rigtigtInput = true;
            System.out.println("Aktivt medlemskab på " + medlem.getNavn() + " er lige nu : " + medlem.getAktivtMedlemskab());// TODO: 12/05/2022 Ændr fra true/false til noget pænere
            System.out.println("Hvad vil du ændre medlemskab til? ");
            String valg = in.nextLine().toLowerCase();
            switch (valg) {
                case "ja", "j", "true" -> medlem.setAktivtMedlemskab(true);
                case "nej", "n", "false" -> medlem.setAktivtMedlemskab(false);
                default -> {
                    fejl();
                    rigtigtInput = false;
                }
            }
        }
        System.out.println(medlem.getNavn() + " er nu ændret til " + medlem.getAktivtMedlemskab());
    }

    public void ændrRestance(Medlem medlem) {
        in.nextLine();
        boolean rigtigtInput = false;
        while (!rigtigtInput) {
            rigtigtInput = true;
            System.out.println("Restance på " + medlem.getNavn() + " er lige nu : " + medlem.getRestance());// TODO: 12/05/2022 Ændr fra true/false til noget pænere
            System.out.println("Hvad vil du ændre konkurrence status til? ");
            String valg = in.nextLine().toLowerCase();
            switch (valg) {
                case "ja", "j", "true" -> medlem.setRestance(true);
                case "nej", "n", "false" -> medlem.setRestance(false);
                default -> {
                    fejl();
                    rigtigtInput = false;
                }
            }
        }
        System.out.println(medlem.getNavn() + " er nu ændret til " + medlem.getRestance());
    }

    public void fejl() {
        System.err.println("Forkert input. Prøv igen: ");
    }
}
