package tech.pedrolima;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class exemplo {

    private static final String template = "Hello, %s! ";

    @RequestMapping("/teste")
    public String greeting(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format(template, name);
    }
}