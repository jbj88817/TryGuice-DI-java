package us.bojie.tryguice;

import us.bojie.tryguice.helloworlddemo.HelloWorldPrinter;

public class Configuration {

    public static MyApplet getMainApplet() {
        return new HelloWorldPrinter();
    }
}
