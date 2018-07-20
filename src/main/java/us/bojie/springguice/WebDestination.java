package us.bojie.springguice;

import javax.inject.Singleton;

import us.bojie.tryguice.helloworlddemo.MyDestination;

@Singleton
public class WebDestination implements MyDestination {

    private StringBuilder sb = new StringBuilder();

    public WebDestination() {
        System.out.println("WebDestination constructed");
    }

    @Override
    public void write(String s) {
        sb.append(s);
    }

    public String getResult() {
        return sb.toString();
    }
}
