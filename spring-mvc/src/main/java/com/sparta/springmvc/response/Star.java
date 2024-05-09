package com.sparta.springmvc.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//import lombok.Value;

//@Value
@NoArgsConstructor
@Setter
@Getter
public class Star {
	// JsonProperty가 없으면 Not Acception에러가 계속뜸
	@JsonProperty
	String name;
	@JsonProperty
	int age;

	public Star() {
	}
//	
//	@JsonCreator
	public Star(@JsonProperty("name") String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return this.name;
	}

    public String setName(String name) {
    	return this.name = name;
    }
    
    public int setAge(int age) {
    	return this.age = age;
    }
    
}