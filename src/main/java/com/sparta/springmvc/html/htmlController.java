package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class htmlController {

    private static long visitCount = 0;
    //정적인 페이지
    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
    }

    @GetMapping("/html/re")
    public String htmlStatic() {
        return "redirect:/hello.html";
    }
    @GetMapping("/html/templates")
    public String htmlTemplates(){
        return hello();
    }

    //동적인페이지
    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) {
        //페이지 방문때마다 visitCount +1
        visitCount++;
        //visitCount를 visits로 선언
        model.addAttribute("visits",visitCount);
        //반환할 뷰(template안 hello-visit.html) 입력
        return "hello-visit";
    }

}
