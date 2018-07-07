package us.bojie.tryguice.server.impl;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;

public class ChinaModule extends AbstractModule {

    @Override
    protected void configure() {
        // Add CNY support
        Multibinder.newSetBinder(binder(), String.class)
                .addBinding().toInstance("CNY");
    }
}
