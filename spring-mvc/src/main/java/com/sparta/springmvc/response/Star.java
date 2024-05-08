package com.sparta.springmvc.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
//import lombok.Value;

//@Value
@Getter
public class Star {
	// JsonProperty가 없으면 Not Acception에러가 계속뜸
	@JsonProperty
    String name;
	@JsonProperty
    int age;

    public Star(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Star() {}
}