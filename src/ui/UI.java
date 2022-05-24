package ui;

import core.Controller;
import database.KonkurrenceSvømmer;
import database.Medlem;

import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.NumberFormat;
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
                case 1 -> seMedlemsListe();
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

    public void konkurrenceMenu() throws FileNotFoundException {
        System.out.println("""
                Hvad vil du gøre?
                (1) Tilføj en konkurrence
                (2) Se top 5 inden for en disciplin""");
        int svar = in.nextInt();
        switch (svar) {
            case 1 -> tilføjKonkurrence();
            case 2 -> seTop5();
        }

        //controller.gemKonkurrenceSvømmere();
        controller.seKonkurrenceListe();
    }

    public void seMedlemsListe() {
        ArrayList<Medlem> medlemmer = controller.seMedlemsListe();
        for (Medlem medlem : medlemmer)
            System.out.println(medlem);
    }

    public void seTop5() {
        try {
            System.out.println("""
                    Hvilken Top5
                    (1) Bryst
                    (2) Crawl
                    (3) Butterfly
                    (4) Rygcrawl""");
            int svar = in.nextInt();
            switch (svar) {
                case 1 -> seBrystTop5();
                case 2 -> seCrawlTop5();
                case 3 -> seButterflyTop5();
                case 4 -> seRygcrawlTop5();
                default -> fejl();
            }
        } catch (Exception e) {
            fejl();
        }
    }

    public void seBrystTop5() {
        System.out.println("Sorteret efter bryst rekord");
        System.out.println("Top 5 Senior brystsvømmere: ");
        udregnBrystTop5(controller.udregnBrystSenior());
        System.out.println("-----------------------------");
        System.out.println("Top 5 Junior brystsvømmere: ");
        udregnBrystTop5(controller.udregnBrystJunior());
        System.out.println();

    }

    public void udregnBrystTop5(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere) {
        int i = 0;
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmere) {
            if (konkurrenceSvømmer.isBryst() && i < 5) {
                i++;
                System.out.printf("#" + i + "|" + konkurrenceSvømmer.getNavn() + " | " +
                        konkurrenceSvømmer.getBrystRekord());
            }
        }
    }

    public void seCrawlTop5() {
        System.out.println("Sorteret efter crawl rekord");
        System.out.println("Top 5 Senior crawlsvømmere: ");
        udregnCrawlTop5(controller.udregnCrawlSenior());
        System.out.println("-----------------------------");
        System.out.println("Top 5 Junior crawlsvømmere: ");
        udregnCrawlTop5(controller.udregnCrawlJunior());
        System.out.println();

    }

    public void udregnCrawlTop5(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere) {
        int i = 0;
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmere) {
            if (konkurrenceSvømmer.isCrawl() && i < 5) {
                i++;
                System.out.println("#" + (i) + " | " + konkurrenceSvømmer.getNavn() + " | " +
                        konkurrenceSvømmer.getCrawlRekord());
            }
        }
    }


    public void seButterflyTop5() {
        System.out.println("Sorteret efter butterfly rekord");
        System.out.println("Top 5 Senior butterflysvømmere: ");
        udregnButterflyTop5(controller.udregnButterflySenior());
        System.out.println("-----------------------------");
        System.out.println("Top 5 Junior butterflysvømmere: ");
        udregnButterflyTop5(controller.udregnButterflyJunior());
        System.out.println();
    }

    public void udregnButterflyTop5(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere) {
        int i = 0;
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmere) {
            if (konkurrenceSvømmer.isButterfly() && i < 5) {
                i++;
                System.out.println("#" + (i) + " | " + konkurrenceSvømmer.getNavn() + " | " +
                        konkurrenceSvømmer.getButterflyRekord());
            }
        }
    }


    public void seRygcrawlTop5() {
        System.out.println("Sorteret efter rygcrawl rekord");
        System.out.println("Top 5 Senior rygcrawl svømmere: ");
        udregnRygCrawlTop5(controller.udregnRygcrawlSenior());
        System.out.println("-----------------------------");
        System.out.println("Top 5 Junior rygcrawl svømmere: ");
        udregnRygCrawlTop5(controller.udregnRygcrawlJunior());
        System.out.println();
    }

    public void udregnRygCrawlTop5(ArrayList<KonkurrenceSvømmer> konkurrenceSvømmere) {
        int i = 0;
        for (KonkurrenceSvømmer konkurrenceSvømmer : konkurrenceSvømmere) {
            if (konkurrenceSvømmer.isRygCrawl() && i < 5) {
            i++;
                System.out.println("#" + (i) + " | " + konkurrenceSvømmer.getNavn() + " | " +
                        konkurrenceSvømmer.getRygCrawlRekord());
            }
        }
    }


    public void tilføj() {
        in.nextLine();
        System.out.print("Navn: ");
        String navn = in.nextLine();

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
        boolean fødselsdatoRigtigt;

        String fødselsdato = "";
        do {
            System.out.println("Fødselsdato(dd/mm/yyyy): ");
            fødselsdato = in.nextLine();
            fødselsdatoRigtigt = true;
            try {
                controller.tilføjMedlem(navn, fødselsdato, medlemskab, konkurrencesvømmer);
            } catch (Exception e) {
                fødselsdatoRigtigt = false;
                fejl();
            }
        } while (!fødselsdatoRigtigt);
    }

    public void tilføjKonkurrence() throws FileNotFoundException {
        boolean korrektInput = false;

        in.nextLine();
        /*
        System.out.print("Navn på konkurrence: ");
        String konkurrenceNavn = in.nextLine();
        //konkurrence.setKonkurrenceNavn(konkurrenceNavn);
         */
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
        int antalSvømmere = in.nextInt(); // TODO: 20/05/2022 Gør så man ikke kan indtaste et større antal svømmere end der findes
        double[] tid = new double[antalSvømmere];
        ArrayList<KonkurrenceSvømmer> valgteSvømmere = new ArrayList<>();
        for (int i = 0; i < antalSvømmere; i++) {
            System.out.println("Vælg svømmer nr. " + (i + 1));
            valgteSvømmere.add(findSvømmere());

            System.out.println("Hvilken tid fik svømmeren: ");
            tid[i] = in.nextDouble();
        }

        controller.tilføjKonkurrence(dato, valgteSvømmere, tid, disciplin);
        controller.gem();
        controller.indlæsMedlemmer();
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
                case 1 -> økonomiOversigt();
                case 2 -> controller.seRestanceListe();
                default -> System.out.println("Du bliver nu sendt tilbage til hovedmenuen");
            }
        } catch (InputMismatchException ime) {
            fejl();
            in.next();
        }
    }

    public void økonomiOversigt() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance();
        String kontingent = numberFormat.format(controller.seKontingent());
        System.out.println("Forventede indkomst over tilmeldte medlemmer \n" + kontingent + "\n");

    }

    public void findMedlem() {
        ArrayList<Medlem> fundneMedlemmer;

        fundneMedlemmer = controller.findMedlem(søg());

        if (fundneMedlemmer.size() > 0) {
            int i = 1;
            for (Medlem medlem : fundneMedlemmer) {
                System.out.printf("# %-3d " + medlem, i);
                i++;
            }
            System.out.println("Indtast nummeret på det medlem du vil bruge: ");
            vælgMedlem(fundneMedlemmer);
        } else {
            System.out.println("Fandt ingen medlemmer i systemet! Prøv igen: ");
            findMedlem();
        }
    }

    public String søg() {
        System.out.println("""
                Find et medlem
                --------------
                Skriv navnet eller dele af navnet for at finde et medlem.""");
        System.out.print(": ");
        String søg = in.next().trim().toLowerCase();
        return søg;
    }

    public KonkurrenceSvømmer findSvømmere() {
        ArrayList<KonkurrenceSvømmer> fundneSvømmere;
        ArrayList<KonkurrenceSvømmer> valgteSvømmere = new ArrayList<>();
        fundneSvømmere = controller.findSvømmer(søg());

        if (fundneSvømmere.size() > 0) {
            int i = 1;
            for (Medlem medlem : fundneSvømmere) {
                System.out.printf("# %-3d " + medlem, i);
                i++;
            }
            System.out.println("Indtast nummeret på den svømmer du vil bruge: ");
            int valg = in.nextInt();
            if (valg - 1 > -1 && valg - 1 < fundneSvømmere.size())
                return fundneSvømmere.get(valg - 1);
            else {
                System.out.println("Det er ikke en gyldig svømmer! Prøv igen");
                return findSvømmere();
            }

        } else {
            System.out.println("Fandt ingen svømmere i systemet! Prøv igen: ");
            return findSvømmere();
        }
    }

    public void vælgMedlem(ArrayList<Medlem> fundneMedlemmer) {
        // TODO: 12-05-2022 InputMissMatch håndter 
        int valg = in.nextInt();
        Medlem medlem;
        if (valg - 1 > -1 && valg - 1 < fundneMedlemmer.size())
            medlem = fundneMedlemmer.get(valg - 1);
        else {
            System.out.println("Ikke et muligt medlem. Prøv igen");
            medlem = null;
            findMedlem();
        }

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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void ændrKonkurrenceStatus(Medlem medlem) throws FileNotFoundException {
        in.nextLine();
        boolean rigtigtInput = false;
        System.out.println("Konkurrence status på " + medlem.getNavn() + " er lige nu : " + medlem.getKonkurrenceSvømmer());
        while (!rigtigtInput) {
            rigtigtInput = true;
            System.out.println("Hvad vil du ændre konkurrence status til? ");
            String valg = in.nextLine().toLowerCase();
            switch (valg) {
                case "ja", "j", "true" -> {
                    medlem.setKonkurrenceSvømmer(true);
                    controller.tilføjSvømmer(medlem);
                }
                case "nej", "n", "false" -> {
                    medlem.setKonkurrenceSvømmer(false);
                    controller.fjernSvømmer(medlem);
                }
                default -> {
                    fejl();
                    rigtigtInput = false;
                }
            }
        }
        System.out.println(medlem.getNavn() + " er nu ændret til " + medlem.getKonkurrenceSvømmer());
        controller.gem();
        controller.indlæsMedlemmer();
    }

    public void ændrAktivMedlem(Medlem medlem) {
        in.nextLine();
        boolean rigtigtInput = false;
        while (!rigtigtInput) {
            rigtigtInput = true;
            System.out.println("Aktivt medlemskab på " + medlem.getNavn() + " er lige nu : " + medlem.getAktivtMedlemskab());
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
            System.out.println("Restance på " + medlem.getNavn() + " er lige nu: " + medlem.getRestance());
            System.out.println("Har medlemmet betalt? ");
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
        System.err.println("Forkert input.");
    }
}
