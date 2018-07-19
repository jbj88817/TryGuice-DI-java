package us.bojie.springguice;

import us.bojie.tryguice.helloworlddemo.MyDestination;

public class WebDestination implements MyDestination {

    private StringBuilder sb = new StringBuilder();
    @Override
    public void write(String s) {
        sb.append(s);
    }

    public String getResult() {
        return sb.toString();
    }
}
