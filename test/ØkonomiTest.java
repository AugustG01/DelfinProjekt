import core.Controller;
import core.Økonomi;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ØkonomiTest {

    @org.junit.jupiter.api.Test
    void udregning() throws FileNotFoundException {
        Controller controller = new Controller();
        //database.DataBase db = new database.DataBase();
        controller.indlæsMedlemmer();
        Økonomi økonomi = new Økonomi(controller.seMedlemsListe());

        assertEquals(3100, økonomi.udregning());
    }
}