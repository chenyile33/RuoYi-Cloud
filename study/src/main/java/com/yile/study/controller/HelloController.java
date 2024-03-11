package com.yile.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenyile
 * @date 2024/3/12  1:59
 */
@RestController
public class HelloController {

    @GetMapping("test")
    public String test(){
        return "Hello World";
    }
}
