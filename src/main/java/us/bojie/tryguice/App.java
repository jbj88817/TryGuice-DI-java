package us.bojie.tryguice;

public class App {
    /**
     * bootstrap:
     * parse command line
     * setup env
     * kick off main logic
     *
     * @param args
     */
    public static void main(String[] args) {
        MyApplet mainApplet = Configuration.getMainApplet();
        mainApplet.run();
    }
}
