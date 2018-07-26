package us.bojie.springguice;

import org.springframework.web.context.annotation.RequestScope;

@RequestScope
public class RequestParams {
    private String message;

    public RequestParams() {
        System.out.println("RequestParams constructed");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
