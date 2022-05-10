import java.io.FileNotFoundException;

public class Delfinen {
    public void go() throws FileNotFoundException {
        Controller controller = new Controller();
        UI ui = new UI(controller);
        ui.start();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Delfinen().go();
    }
}
