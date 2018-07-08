package us.bojie.tryguice;

import com.google.inject.Guice;
import com.google.inject.Injector;

import us.bojie.tryguice.helloworlddemo.CommandLineModule;

public class App {
    /**
     * bootstrap:
     * parse command line
     * setup env
     * kick off main logic
     *
     * @param args
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MainModule(),
                new CommandLineModule(args));

        Applets.get(injector, args[0]).run();
    }
}
