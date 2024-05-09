package com.sparta.springmvc.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class Star {
	@JsonProperty
	String name;
	@JsonProperty
	int age;
	
	public Star() {
		
	}
	
	public Star(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
	}

	
	
}
