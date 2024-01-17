package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.spring6.context.SpringContextUtils;

@Controller
@RequestMapping("/response")
public class ResponseController {

    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {               //Content-Type: text/html
        return "{\"name\":\"Robbie\",\"age\":95}";
    }
    @GetMapping("/json/calss")
    @ResponseBody                                   //Content-Type: application/json
    public Star helloClassJson(){                   //자바에서 객체를 생성해서 보낼 때는 자동으로 json 타입으로 잡아줌.
        return new Star("Dosal",95);    //key:name|age, value: Dosal|95 형식으로 반환
    }
}
