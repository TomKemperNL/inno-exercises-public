package nl.hu.inno.clouddeploy.hellospring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World! It is now " + LocalDateTime.now();
    }
}
