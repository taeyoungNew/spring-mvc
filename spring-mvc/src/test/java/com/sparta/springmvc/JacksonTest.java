package com.sparta.springmvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springmvc.response.Star;

public class JacksonTest {
	
	@Test
	@DisplayName("Object To JSON : Get Method 피요")
	void test1() throws JsonProcessingException {
		Star star = new Star("Taeyoung", 93);
		// Jackson 라이브러리의 ObjectMapper
		ObjectMapper objectMapper = new ObjectMapper();
		// writeValueAsString() <= 반환하고 싶은 object의 객체를 인자로 받는다.
		// star객체를 String타입의 객체로 바꾼다 
		
		String json = objectMapper.writeValueAsString(star);
		
		// result => json = {"name":"Taeyoung","age":93}
		System.out.println("json = " + json);
	}
	
//	@Test
//	@DisplayName("JSON to Object : 기본생성자 & (get Or set) Method필요")
//	void test2() throws JsonProcessingException {
//		String json = "{\"name\":\"Taeyoung\",\"age\":93"; // Json타입의 String 
//		
//		ObjectMapper objectMapper = new ObjectMapper(); // Jackson안의 라이브러리 ObjectMapper
//		
//		Star star = objectMapper.readValue(json, Star.class);
//		System.out.println("star.getName() = " + star.getName());
//	}
	
	@Test
	@DisplayName("JSON To Object : 기본 생성자 & (get OR set) Method 필요")
	void test2() throws JsonProcessingException {
	    String json = "{\"name\":\"Robbie\",\"age\":95}"; // JSON 타입의 String

	    ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper

	    // 첫번째 인자에는 Json, 두번째 인자에는 바꾸고 싶은 클래스를 넣는다
	    Star star = objectMapper.readValue(json, Star.class);
	    System.out.println("star.getName() = " + star.getName());
	}
}
