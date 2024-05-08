package com.sparta.springmvc.response;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // : controller + responseBody
// RestController에노테이션을 붙이면 @ResponseBody를 안붙여줘도 된다.
// 클래스전체가 json형식의 데이터를 반환하는 경우 코드량을 줄이기 위해 
// @RestController이노테이션을 사용한다.
@RequestMapping("/response/rest")
public class ResponseRestController {
    // [Response header]
    //   Content-Type: text/html
    // [Response body]
    //   {"name":"Robbie","age":95}
    @GetMapping("/json/string")
    public String helloStringJson() {
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // [Response header]
    //   Content-Type: application/json
    // [Response body]
    //   {"name":"Robbie","age":95}
    @GetMapping("/json/class")
    public Star helloClassJson() {
        return new Star("Robbie", 95);
    }
}