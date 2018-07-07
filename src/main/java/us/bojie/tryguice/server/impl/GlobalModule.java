package us.bojie.tryguice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class GlobalModule extends AbstractModule {

    @Override
    protected void configure() {
        //Adds EUR, USD support
        Multibinder<String> stringMultibinder = Multibinder.newSetBinder(binder(), String.class);
        stringMultibinder.addBinding().toInstance("EUR");
        stringMultibinder.addBinding().toInstance("USD");
        stringMultibinder.addBinding().toInstance("JPY");
    }
}
