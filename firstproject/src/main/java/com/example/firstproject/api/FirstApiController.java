package com.example.firstproject.api;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Rest Api용 컨트롤러 기본적으로 제이슨을 반환! 일반컨트롤러는 뷰템블릿페이지를 반환
public class FirstApiController {

    @GetMapping("/api/hello")
    public String hello(){
        return "hello world";
    }
}
