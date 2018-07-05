package us.bojie.tryguice.helloworlddemo;

import java.io.PrintStream;

public class PrintStreamWriter implements MyDestination {


    private PrintStream mDestination;

    public PrintStreamWriter(PrintStream destination) {
        mDestination = destination;
    }

    public void write(String s) {
        mDestination.println(s);
    }
}
