package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tuzhijin
 * @version Id: DemoController.java, v 0.1 2019/11/24 19:46 tuzhijin Exp $$
 */
@RestController
public class DemoController {

    @GetMapping("/test")
    public String getMessage(@RequestParam String message) {
        return "hello, " + message;
    }
}
