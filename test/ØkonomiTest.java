import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ØkonomiTest {

    @org.junit.jupiter.api.Test
    void udregning() throws FileNotFoundException {
        Controller controller = new Controller();
        //DataBase db = new DataBase();
        controller.indlæsMedlemmer();
        Økonomi økonomi = new Økonomi(controller.db.medlemmer);

        assertEquals(3100, økonomi.udregning());
    }
}