package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping(value = "/greeting")
	public Greeting greeting(@RequestParam(value="name", defaultValue = "World") String name,
							 @RequestParam(value="age", defaultValue = "24") int age){
		return new Greeting(counter.incrementAndGet(),String.format(template, name), age);
	}

}
