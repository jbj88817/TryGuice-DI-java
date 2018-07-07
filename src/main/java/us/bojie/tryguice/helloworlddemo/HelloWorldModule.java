package us.bojie.tryguice.helloworlddemo;

import com.google.inject.AbstractModule;

import java.io.PrintStream;

import us.bojie.tryguice.MyApplet;

public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
        bind(String.class).annotatedWith(Output.class).toInstance("Hello World!!!");
    }
}
