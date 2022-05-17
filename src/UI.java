import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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
                    - Tilføj konkurrence
                    - Se top 5
                (5) Økonomi menu
                    - Se total forventet indkomst
                    - Se liste af medlemmer i restance
                (0) Afslut programmet""");
        hovedMenu();
    }

    public void hovedMenu() throws FileNotFoundException {
        try {
            int svar = in.nextInt();
            switch (svar) {
                case 1 -> controller.seMedlemsListe();
                case 2 -> tilføj();
                case 3 -> findMedlem();
                case 4 -> konkurrenceMenu();
                case 5 -> økonomiMenu();
                case 0 -> afslut();
            }
        } catch (InputMismatchException ime) {
            fejl();
            in.next();
        }
    }
    public void konkurrenceMenu() {
        System.out.println("""
                Hvad vil du gøre?
                (1) Tilføj en konkurrence
                (2) Se top 5 inden for en disciplin""");
        int svar = in.nextInt();
        switch (svar){
            case 1 -> tilføjKonkurrence();
            case 2 -> seTop5();
        }

        //controller.gemKonkurrenceSvømmere();
        controller.seKonkurrenceListe();
    }
    public void seTop5(){
        System.out.println("IKKE IMPLEMENTERET ENDNU");


    }

    public void tilføj() {
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
            case "ja", "j" -> {
                konkurrencesvømmer = true;
            }
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

    public void tilføjKonkurrence() {
        boolean korrektInput = false;

        in.nextLine();

        System.out.print("Navn på konkurrence: ");
        String konkurrenceNavn = in.nextLine();
        //konkurrence.setKonkurrenceNavn(konkurrenceNavn);
        String disciplin = "bryst";
        System.out.print("Disciplin: ");

        while (!korrektInput) {
            disciplin = in.nextLine().toLowerCase();
            korrektInput = true;
            switch (disciplin) {
                case "b", "bryst" -> disciplin = "bryst";
                case "bf", "butterfly", "butter fly", "butter" -> disciplin = "butterfly";
                case "c", "crawl" -> disciplin = "crawl";
                case "rc", "rygcrawl", "ryg crawl" -> disciplin = "rygcrawl";
                default -> {
                    fejl();
                    korrektInput = false;
                }
            }
        }

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dato = dateFormat.format(date);

        System.out.print("Hvor mange svømmere fra klubben er med? ");
        int antalSvømmere = in.nextInt();
           double[] tid = new double[antalSvømmere];
           ArrayList<KonkurrenceSvømmer> valgteSvømmere = new ArrayList<>();
        for (int i = 0; i < antalSvømmere; i++) {
            System.out.println("Vælg svømmer nr. " + (i+1));
           valgteSvømmere.add(findSvømmere());

            System.out.println("Hvilken tid fik svømmeren: ");
            tid[i] = in.nextDouble();
        }

        controller.tilføjKonkurrence(konkurrenceNavn, dato, valgteSvømmere , tid, disciplin);


    }

    public void afslut() throws FileNotFoundException {
        System.out.println("Du har afsluttet programmet! Alle ændringer vil blive gemt");
        controller.gem();
        isRunning = false;
    }

    public void økonomiMenu() {
        System.out.println("Hvad vil du gøre?");
        System.out.println("""
                (1) Se total forventet indkomst
                (2) Se liste af medlemmer i restance
                (3) Annuller""");
        try {
            int svar = in.nextInt();
            switch (svar) {
                case 1 -> controller.seKontingent();
                case 2 -> controller.seRestanceListe();
                default -> System.out.println("Du bliver nu sendt tilbage til hovedmenuen");
            }
        } catch (InputMismatchException ime) {
            fejl();
            in.next();
        }
    }

    public void findMedlem() {
        ArrayList<Medlem> fundneMedlemmer;

        fundneMedlemmer = controller.findMedlem(søg());

        if (fundneMedlemmer.size() > 0) {
            // TODO: 11/05/2022 flyt sout
            int i = 1;
            for (Medlem medlem : fundneMedlemmer) {
                System.out.println("#" + i + ". " + medlem);
                i++;
            }
            System.out.println("Indtast nummeret på det medlem du vil bruge: ");
            vælgMedlem(fundneMedlemmer);
        } else {
            System.out.println("Fandt ingen medlemmer i systemet! Prøv igen: ");
            findMedlem();
        }
    }
    public String søg(){
        System.out.println("""
                Find et medlem
                --------------
                Skriv navnet eller dele af navnet for at finde et medlem.""");
        in.nextLine();
        System.out.print(": ");
        String søg = in.nextLine().trim().toLowerCase();
        return søg;
    }

    public KonkurrenceSvømmer findSvømmere() {
        ArrayList<KonkurrenceSvømmer> fundneSvømmere;
        ArrayList<KonkurrenceSvømmer> valgteSvømmere = new ArrayList<>();
        fundneSvømmere = controller.findSvømmer(søg());

        if (fundneSvømmere.size() > 0) {
            // TODO: 11/05/2022 flyt sout
            int i = 1;
            for (Medlem medlem : fundneSvømmere) {
                System.out.println("#" + i + ". " + medlem);
                i++;
            }
            System.out.println("Indtast nummeret på den svømmer du vil bruge: ");
            int valg = in.nextInt();


            return fundneSvømmere.get(valg - 1);
        } else {
            System.out.println("Fandt ingen svømmere i systemet! Prøv igen: ");
            return findSvømmere();
        }
    }

    public void vælgMedlem(ArrayList<Medlem> fundneMedlemmer) {
        // TODO: 12-05-2022 InputMissMatch håndter 
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
