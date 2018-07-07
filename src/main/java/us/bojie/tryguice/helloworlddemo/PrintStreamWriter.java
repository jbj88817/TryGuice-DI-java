package us.bojie.tryguice.helloworlddemo;

import java.io.PrintStream;

import javax.inject.Inject;

public class PrintStreamWriter implements MyDestination {


    private PrintStream mDestination;

    @Inject
    public PrintStreamWriter(PrintStream destination) {
        mDestination = destination;
    }

    public void write(String s) {
        mDestination.println(s);
    }
}
