import java.io.FileNotFoundException;

public class Controller {
    DataBase db = new DataBase();

    public void seListe() {

    }

    public void tilføjMedlem() throws FileNotFoundException {
        db.skriv(new Medlem(2,"bob",true, true, true));
    }

    public void indlæsMedlemmer() throws FileNotFoundException {
        db.indlæs();
    }
}
