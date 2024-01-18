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
    public String helloRequestPath(@PathVariable String name, @PathVariable int age) { //GetMapping에 {}중괄호 안의 변수명이랑 동일 해야함
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);               //return Hello, @PathVariable.<br> name = 도살, age = 33
    }
    @GetMapping("/form/param") //http://localhost:8080/hello/request/form/param?name=도살&age=33
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age){
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
//        //오류내용
//        //웹페이지 :There was an unexpected error (type=Internal Server Error, status=500).
//        //spring로그: Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: java.lang.IllegalArgumentException: Name for argument of type [java.lang.String] not specified, and parameter name information not available via reflection. Ensure that the compiler uses the '-parameters' flag.] with root cause
    }
    //실제 구동되는 코드
//    @GetMapping("/form/param") //http://localhost:8080/hello/request/form/param?name=도살&age=33
//    @ResponseBody
//    public String helloGetRequestParam(@RequestParam("name") String name, @RequestParam("name") int age){
//        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
//    }
    @PostMapping("/form/param")  //http://localhost:8080/hello/request/from/param
    @ResponseBody       //'name=도살&age=33'(RequestParam)방식으로 입력된 데이터(Body)를 가져 올 때 사용.
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) { //개발자도구 Payload(body)부분에 name=%EB%8F%84%EC%82%B4&age=33
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }
        //================================================================================================//
    @PostMapping("/form/model") //http://localhost:8080/hello/request/form/model
    @ResponseBody                   //'name=도살&age=33'(RequestParam)방식으로 입력된 데이터(Body)를 객체로 변환 할 때 사용.
     public String helloRequestBodyForm(@ModelAttribute Star star) { //필드값을 가지고있는 생성자 나 Setter가 있어야 가능
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d ", star.name, star.age);
     }
    @GetMapping("/form/param/model") //http://localhost:8080/hello/request/form/param/model?name=도살&age=33
    @ResponseBody                      //필드값을 가지고있는 생성자 나 Setter가 있어야 가능
    public String helloRequestParam(@ModelAttribute Star star) { //입력받아온 값을 star 인스턴트에 입력
        return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d ", star.name, star.age);
    }
    @PostMapping("/form/json") //http://localhost:8080/hello/request/form/json
    @ResponseBody                    //'{"name":"도살","age":"33"}'(Json)방식으로 입력된 데이터(Body)를 객체로 변환 할 때 사용.
    public String helloPostRequestJson(@RequestBody Star star){ //필드값을 가지고있는 생성자 나 Setter가 있어야 가능
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }

}
