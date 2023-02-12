package xyz.ziang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AOPController {

    @GetMapping("/hello")
    public void hello() {
        System.out.println("AOPController.test");
    }
}
