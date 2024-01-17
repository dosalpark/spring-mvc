package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller //컨트롤러 수행시 이노테이션 작성
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "Hello World!!!";
    }
    @GetMapping("/get")
    @ResponseBody
    public String get(){
        return "GET method 요청";
    }
    @PostMapping("/post")
    @ResponseBody
    public String post(){
        return "POST Method 요청";
    }
    @PutMapping("/put")
    @ResponseBody
    public String put(){
        return "PUT Method 요청";
    }
    @DeleteMapping("/delete")
    @ResponseBody
    public String delete(){
        return "DELETE Method 요청";
    }
}
