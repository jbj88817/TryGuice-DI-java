package us.bojie.tryguice.helloworlddemo;

import com.google.inject.Provider;

import javax.inject.Inject;

import us.bojie.tryguice.MyApplet;

public class StringWritingApplet implements MyApplet {

    private MyDestination mDestination;
    private Provider<String> mStringProvider;

    @Inject
    public StringWritingApplet(MyDestination destination,
                               Provider<String> stringProvider) {
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
