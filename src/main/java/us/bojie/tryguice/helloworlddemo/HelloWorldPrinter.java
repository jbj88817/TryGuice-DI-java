package us.bojie.tryguice.helloworlddemo;

import us.bojie.tryguice.MyApplet;

public class HelloWorldPrinter implements MyApplet {

    private void printHelloWorld() {
        System.out.println("Hello World!");
    }

    public void run() {
        printHelloWorld();
    }
}
