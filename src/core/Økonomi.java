package core;

import java.util.ArrayList;
import database.*;

public class Økonomi {
    private final int JUNIOR_TAKST = 1000;
    private final int SENIOR_TAKST = 1600;
    private final int PASSIVT_KONTINGENT = 500;
    private final double PENSIONIST_RABAT = 0.75;
    private ArrayList<Medlem> passiveMedlemmer = new ArrayList<>();
    private ArrayList<Medlem> juniorMedlemmer = new ArrayList<>();
    private ArrayList<Medlem> seniorMedlemmer = new ArrayList<>();
    private ArrayList<Medlem> pensionistMedlemmer = new ArrayList<>();
    private ArrayList<Medlem> restanceMedlemmer = new ArrayList<>();

    public Økonomi(ArrayList<Medlem> medlemmer){
        for(Medlem medlem : medlemmer){
            if (medlem.getRestance())
                tilføjRestanceMedlem(medlem);
            if(medlem.getAktivtMedlemskab()){
                if (medlem.getAlder() > 60)
                    tilføjPensionist(medlem);
                else if (medlem.getAlder() < 18)
                    tilføjJuniorMedlem(medlem);
                else tilføjSenior(medlem);

            }
            else {
                tilføjPassivtMedlem(medlem);
            }
        }
    }

    public void tilføjRestanceMedlem(Medlem medlem) {
        restanceMedlemmer.add(medlem);
    }

    public void tilføjSenior(Medlem medlem) {
        seniorMedlemmer.add(medlem);
    }

    public void tilføjPensionist(Medlem medlem) {
        pensionistMedlemmer.add(medlem);
    }

    public void tilføjJuniorMedlem(Medlem medlem){
        juniorMedlemmer.add(medlem);
    }

    public void tilføjPassivtMedlem(Medlem medlem){
        passiveMedlemmer.add(medlem);
    }

    public double udregning() {
        return udregnJunior() + udregnSenior() + udregnPassiv() + udregnPensionist();
    }

    public double udregnSenior(){
        return SENIOR_TAKST * seniorMedlemmer.size();
    }

    public double udregnPensionist(){
        return (PENSIONIST_RABAT * SENIOR_TAKST) * pensionistMedlemmer.size();
    }

    public double udregnJunior(){
        return JUNIOR_TAKST * juniorMedlemmer.size();
    }

    public double udregnPassiv() {
        return PASSIVT_KONTINGENT * passiveMedlemmer.size();
    }

    public double udregnTotalKontingent(){
        return udregning();
    }

    public ArrayList<Medlem> getRestanceListe() {
        return restanceMedlemmer;

    }

}
