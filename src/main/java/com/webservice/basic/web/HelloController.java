package com.webservice.basic.web;

import com.webservice.basic.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
public class HelloController {

    @GetMapping("/hello") // Get의 요청을 받을 수 있는 api
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloResponseDto(@RequestParam("name") String name,@RequestParam("amount") int amount) {
        return new HelloResponseDto(name,amount);
    }
    //@RequestParam : 외부에서 api로 넘긴 파라미터를 가져오는 어노테이션
}
