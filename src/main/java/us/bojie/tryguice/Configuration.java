package us.bojie.tryguice;

import us.bojie.tryguice.helloworlddemo.StringWritingApplet;
import us.bojie.tryguice.helloworlddemo.PrintStreamWriter;

public class Configuration {

    public static MyApplet getMainApplet() {
        return new StringWritingApplet(new PrintStreamWriter(System.out),
                "Hello World");
    }
}
