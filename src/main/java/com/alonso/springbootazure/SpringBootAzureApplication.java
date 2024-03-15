package com.alonso.springbootazure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootAzureApplication {

    @GetMapping("/welcome")
    public String welcome(){
        return "<h1>WELCOME</h1>";
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAzureApplication.class, args);
    }

}
