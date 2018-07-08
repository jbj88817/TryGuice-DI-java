package us.bojie.tryguice.helloworlddemo;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import java.io.PrintStream;
import java.util.List;

import us.bojie.tryguice.Applets;

public class HelloWorldModule extends AbstractModule {

    @Override
    protected void configure() {

        Applets.register(binder()).named("hello")
                .to(StringWritingApplet.class);
//        MapBinder.newMapBinder(binder(), String.class, MyApplet.class)
//                .addBinding("hello").to(StringWritingApplet.class);
//        bind(MyApplet.class).annotatedWith(Names.named("hello")).to(StringWritingApplet.class);
        bind(MyDestination.class).to(PrintStreamWriter.class);
        bind(PrintStream.class).toInstance(System.out);
    }

    @Provides
    @Output
    String getOutputString(@Args List<String> args) {
        return args.get(0);
    }
}
