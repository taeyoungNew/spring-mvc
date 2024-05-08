package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.exceptions.TemplateInputException;

@Controller
@RequestMapping("/response")
public class ResponseController {
	// Content-Type : text/html
	@GetMapping("/json/string")
	@ResponseBody
	public String helloStringJson() {
		// json형식으로 리턴
		return "{\"name\":\"Robbie\",\"age\":95}";
	}
	
	
	// Content-Type : application/json
	// Response Body : 
	// {"name" : "Taeyoung", "age" : 95 }
	@GetMapping("/json/class")
	@ResponseBody // 그냥 데이터를 리턴할 때 
	public Star helloClassJson() {
		// 위처럼 일일이 json형식으로 변환하는건 시간적 비용이 많이 드므로
		// 스프링내부에서 자바의 객체를 json형식으로 자동변환해준다.
		return new Star();
	}
}


