package com.example.bcsd;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class HelloController {

    @ResponseBody
    @GetMapping("/{id}")
    public Info json() {
        Info info = new Info(22,"김성은");
        return info;
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "hello";
    }
}
