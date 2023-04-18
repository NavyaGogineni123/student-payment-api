package net.navya.springtest.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/hello/")
public class HelloWorldController {


    @GetMapping("helloworld")
    public String helloWorld() {
        return "Hello World spring";
    }

    @GetMapping("test")
    public String test() {
        return "this is test";
    }


}
