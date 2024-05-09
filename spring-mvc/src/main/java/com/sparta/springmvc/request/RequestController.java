package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// Path Variable : 브라우저에서 서버로 HTTP요청을 보낼때 데이터를 함께 보낼 수 있다.

@Controller
@RequestMapping("/hello/request")
public class RequestController {

	//
	@GetMapping("/form/html")
	public String helloForm() {
		return "hello-request-form";
	}

	// [Request sample]
	// GET http://localhost:8080/hello/request/star/Robbie/age/95
	// node에서는 템플릿리터럴 : ${}, 스프링에서는 {}
	@GetMapping("/star/{name}/age/{age}")
	@ResponseBody
	// 위의 Path에 있는 데이터를 받는 방법은 매개변수앞에 @PathVariable어노테이션을 붙인다
	// 변수명은 같아야한다. name == name, age == age
	public String helloRequestPath(@PathVariable String name, @PathVariable int age) {
		return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
	}

	// [Request sample]
	// GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
	// @RequestParam : 쿼리스트링 방식 => ?key=val방식
	@GetMapping("/form/param")
	@ResponseBody
	// @RequestParam(required = false) => 클라이언트에서 오는 데이터중 해당값이 들어있지 않은 경우 에러처리
	// 값이 안들어온 경우 null로 초기화 된다.
	public String helloGetRequestParam(@RequestParam(required = false) String name, @RequestParam int age) {
		return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
	}

	// [Request sample]
	// POST http://localhost:8080/hello/request/form/param
	// Header
	// Content type: application/x-www-form-urlencoded
	// Body
	// name=Robbie&age=95
	@PostMapping("/form/param")
	@ResponseBody
	public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
		return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
	}

	// [Request sample]
	// POST http://localhost:8080/hello/request/form/model
	// Header
	// Content type: application/x-www-form-urlencoded
	// Body
	// name=Robbie&age=95
	@PostMapping("/form/model")
	@ResponseBody // 쿼리스트링방식의 데이터를 Star객체에 매핑해서 가져오기
	// @ModelAttribute어노테이션사용하기;
	// Star객체는 String name과 int age를 받으니까 클라이언트에서 name, age를 바디에 넣어서
	// 서버로 옮기면 @ModelAttribute어노테이션을 사용해서 매핑하면 두 데이터가 star객체에 들어가는구만
	// 변수명은 틀리면 안되겠지
	// 객체로 받으면 좋은점은 나중에 협업에서는 지금처럼 RequestParam이 2개가 아닌 4 5개가 될때가 있으니
	// 객체로 한번에 받는게 비용이 절약된다.
	// @ModelAttribute를 사용하려면 반드시 오버로딩된 Constructer가 필요하다
	public String helloRequestBodyForm(@ModelAttribute Star star) {
		return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
	}

	// [Request sample]
	// GET http://localhost:8080/hello/request/form/param/model?name=Robbie&age=95
	@GetMapping("/form/param/model")
	@ResponseBody
	public String helloRequestParam(@ModelAttribute Star star) {
		return String.format("Hello, @ModelAttribute.<br> (name = %s, age = %d) ", star.name, star.age);
	}

	// simpleVal = 원시타입(int, double, Integer등등)

	// [Request sample]
	// POST http://localhost:8080/hello/request/form/json
	// Header
	//  Content type: application/json
	// Body
	//  {"name":"Robbie","age":"95"}
	@PostMapping("/form/json")
	@ResponseBody
	public String helloPostRequestJson(@RequestBody Star star) {
	    return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
	}
	
	
	
	
	
	
}
