package us.bojie.tryguice;

import com.google.common.base.Joiner;
import com.google.inject.Guice;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.Map;

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
        Map<String, MyApplet> applets =
                Guice.createInjector(new MainModule(),
                        new CommandLineModule(args))
                        .getInstance(Key.get(
                                new TypeLiteral<Map<String, MyApplet>>() {
                                }));
        if (args.length == 0 || !applets.containsKey(args[0])) {
            System.out.println("Unable to find applet."
                    + "Valid applets are "
                    + Joiner.on(", ").join(applets.keySet()));
            return;
        }
        applets.get(args[0]).run();
    }
}
