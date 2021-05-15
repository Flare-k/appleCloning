package apple.cloneApple.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
public class ApiController {

    @GetMapping("/api/test")
    public String hello() {
        return "helloWorld!";
    }
}
