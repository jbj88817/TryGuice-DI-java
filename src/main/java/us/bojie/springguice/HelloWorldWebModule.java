package us.bojie.springguice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.servlet.ServletModule;

import us.bojie.tryguice.MyApplet;
import us.bojie.tryguice.helloworlddemo.MyDestination;
import us.bojie.tryguice.helloworlddemo.Output;
import us.bojie.tryguice.helloworlddemo.StringWritingApplet;

public class HelloWorldWebModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new ServletModule());
        bind(MyApplet.class).to(StringWritingApplet.class);
        bind(MyDestination.class).to(WebDestination.class);
    }

    @Provides
    @Output
    String getOutputString(RequestParams params) {
        return params.getMessage();
    }
}
