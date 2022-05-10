public class Delfinen {
    public void go(){
        Controller controller = new Controller();
        UI ui = new UI(controller);
        ui.start();
    }

    public static void main(String[] args) {
        new Delfinen().go();
    }
}
