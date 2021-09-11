package com.kdk.codepaste.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class testController {
    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
