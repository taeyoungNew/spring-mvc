package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

// HTML Controller
@Controller
public class HtmlController {
	
	// 동적페이지 처리
	private static long visitCount = 0;
	@GetMapping("/html/dynamic") 
	// Model : org.springframework.ui.Model
	public String htmlDynamic(Model model) {
		// /html/dynamic로 접근하면 아래의 로직이 실행
		// 해당 요청이 들어오면 visitCount를 증가시켜줄거임
		visitCount++;
		// visits라는 이름으로 return하는 html페이지로 visitsCount를 보낸다.
		model.addAttribute("visits", visitCount);
		return "hello-visit";
	}
	
	
	// 정적페이지 처리
	@GetMapping("/static-hello")
	public String hello() {
		// @ResponseBody가 없을 경우 해당 메서드는 html파일을 찾는다.
		return "helloWorld.html";
	}
	
	// Controller를 타고 정적html파일을 반환해야 할 경우
	@GetMapping("/html/redirect")
	public String htmlStatic() {
		// 
		return "redirect:/helloWorld.html";
	}
	
	@GetMapping("/html/templates") 
	public String htmlTemplates() {
		// html확장자는 생략가능하다.
		return "hello";
	}
	
}
