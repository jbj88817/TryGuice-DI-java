package us.bojie.tryguice;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;

import java.io.PrintStream;

import us.bojie.tryguice.helloworlddemo.MyDestination;
import us.bojie.tryguice.helloworlddemo.PrintStreamWriter;
import us.bojie.tryguice.helloworlddemo.StringWritingApplet;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
//        bind(String.class).toInstance("Hello World!!!");
        bind(String.class).toProvider(new Provider<String>() {
            public String get() {
                return "Hello world provider";
            }
        });
    }
}
