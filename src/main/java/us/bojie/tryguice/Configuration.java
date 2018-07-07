package us.bojie.tryguice;

import com.google.inject.Provider;

import us.bojie.tryguice.helloworlddemo.StringWritingApplet;
import us.bojie.tryguice.helloworlddemo.PrintStreamWriter;

public class Configuration {

    public static MyApplet getMainApplet() {
        return new StringWritingApplet(new PrintStreamWriter(System.out),
                new Provider<String>() {
                    public String get() {
                        return "Hello World";
                    }
                });
    }
}
