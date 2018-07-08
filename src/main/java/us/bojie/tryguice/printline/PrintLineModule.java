package us.bojie.tryguice.printline;

import com.google.inject.AbstractModule;

import us.bojie.tryguice.Applets;

public class PrintLineModule extends AbstractModule {

    @Override
    protected void configure() {
        Applets.register(binder()).named("println")
                .to(PrintLineApplet.class);
//        bind(MyApplet.class).annotatedWith(Names.named("println"))
//                .to(PrintLineApplet.class);
    }
}
