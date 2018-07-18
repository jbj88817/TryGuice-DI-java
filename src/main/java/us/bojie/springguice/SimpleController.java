package us.bojie.springguice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimpleController {

    @GetMapping("/hello")
    String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleController.class, args);
    }
}

