package us.bojie.tryguice.helloworlddemo;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.sun.tracing.dtrace.ArgsAttributes;

import java.util.Arrays;
import java.util.List;

public class CommandLineModule extends AbstractModule {

    private final String[] args;

    public CommandLineModule(String[] args) {
        this.args = args;
    }

    @Override
    protected void configure() {
        super.configure();
    }

    @Provides
    @Args
    List<String> getCommandLineArgs() {
        return Arrays.asList(args);
    }
}
