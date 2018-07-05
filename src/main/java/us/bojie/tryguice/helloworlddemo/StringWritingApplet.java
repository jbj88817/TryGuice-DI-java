package us.bojie.tryguice.helloworlddemo;

import us.bojie.tryguice.MyApplet;

public class StringWritingApplet implements MyApplet {

    private MyDestination mDestination;
    private String mOutputString;

    public StringWritingApplet(MyDestination destination,
                               String outputString) {
        mDestination = destination;
        mOutputString = outputString;
    }

    private void writeString() {
        mDestination.write(mOutputString);
    }

    public void run() {
        writeString();
    }
}
