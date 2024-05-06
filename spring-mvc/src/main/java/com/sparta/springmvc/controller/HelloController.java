package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// 해당 클래스는 Controller의 역할을 수행할 거라는 의미
@Controller
@RequestMapping("/api")
public class HelloController {
	
	@GetMapping("/hello")
	@ResponseBody
	// Controller라는 에너테이션을 달고
	// 문자열로 리턴하게 되면 resources의 teplates에서 
	public String hello() {
		// 아래와 같은 Hello world라는 
		// HTML를 찾는다.
		return "이것이 스프링부트로 만든 서버다!";
	}
	
	
	@GetMapping("/get")
	@ResponseBody
	public String get() {
		return "Get method 요청";
	}
	
	
	@PostMapping("/post")
	@ResponseBody
	public String post() {
		return "POST Method 요청";
	}
	
	@PutMapping("/put")
	@ResponseBody
	public String put() {
		return "Put method 요청";
	}
	
	@DeleteMapping("/delete")
	@ResponseBody
	public String delete() {
		return "Delete Method 요청";
	}
}
