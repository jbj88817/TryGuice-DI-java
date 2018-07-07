package us.bojie.tryguice;

import com.google.inject.AbstractModule;

import us.bojie.tryguice.helloworlddemo.HelloWorldModule;

public class MainModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new HelloWorldModule());
    }
}
