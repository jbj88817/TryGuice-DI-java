package us.bojie.tryguice.helloworlddemo;

import us.bojie.tryguice.MyApplet;

public class StringWritingApplet implements MyApplet {

    private MyDestination mDestination;
    private StringProvider mStringProvider;

    public StringWritingApplet(MyDestination destination,
                               StringProvider stringProvider) {
        mDestination = destination;
        mStringProvider = stringProvider;
    }

    private void writeString() {
        mDestination.write(mStringProvider.get());
    }

    public void run() {
        writeString();
    }
}
