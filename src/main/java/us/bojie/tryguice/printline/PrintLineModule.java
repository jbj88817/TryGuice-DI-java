package us.bojie.tryguice.printline;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;

import us.bojie.tryguice.MyApplet;

public class PrintLineModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder.newMapBinder(binder(), String.class, MyApplet.class)
                .addBinding("println").to(PrintLineApplet.class);
//        bind(MyApplet.class).annotatedWith(Names.named("println"))
//                .to(PrintLineApplet.class);
    }
}
