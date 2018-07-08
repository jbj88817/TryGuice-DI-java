package us.bojie.tryguice;

import com.google.inject.AbstractModule;

import us.bojie.tryguice.helloworlddemo.HelloWorldModule;
import us.bojie.tryguice.printline.PrintLineModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new HelloWorldModule());
        install(new PrintLineModule());
    }
}
