package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello/request") //하단 소스의 공통되는 주소 기재
public class RequestController {
    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }
    @GetMapping("/star/{name}/age/{age}")   //http://localhost:8080/hello/request/star/도살/age/33
    @ResponseBody //예제에는 없었지만 @PathVariable 옆에 변수 명을 기재해줘야 정상적으로 작동됨
    public String helloRequestPath(@PathVariable("name") String name, @PathVariable("age") int age) { //GetMapping에 {}중괄호 안의 변수명이랑 동일 해야함
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);               //return Hello, @PathVariable.<br> name = 도살, age = 33
    }


    //예제코드
//    @GetMapping("/form/param") //http://localhost:8080/hello/request/form/param?name=도살&age=33
//    @ResponseBody
//    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age){
//        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
//        //오류내용
//        //웹페이지 :There was an unexpected error (type=Internal Server Error, status=500).
//        //spring로그: Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.IllegalArgumentException: Name for argument of type [java.lang.String] not specified, and parameter name information not available via reflection. Ensure that the compiler uses the '-parameters' flag.] with root cause
//    }
    //실제 구동되는 코드
    @GetMapping("/form/param") //http://localhost:8080/hello/request/form/param?name=도살&age=33
    @ResponseBody
    public String helloGetRequestParam(@RequestParam("name") String name, @RequestParam("age") int age){
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }
    @PostMapping("/form/param")
    @ResponseBody       //html파일에서 <form method="POST" action="/hello/request/form/param">
    public String helloPostRequestParam(@RequestParam("name") String name, @RequestParam("age") int age){ //개발자도구 Payload(body)부분에 name=%EB%8F%84%EC%82%B4&age=33
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }
}
