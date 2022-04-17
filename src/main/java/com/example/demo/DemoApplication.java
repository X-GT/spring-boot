package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@SpringBootApplication
@RestController
public class DemoApplication {

	public static final String template = "Hello %s!";
	private final AtomicLong counter = new AtomicLong();

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "world") String name) {
        return String.format("Hello %S!", name);
    }

    @GetMapping("/greeting")
    public Greetings greetings(@RequestParam(value = "name", defaultValue = "World") String name){
		return new Greetings(counter.incrementAndGet(), String.format(template, name));
	}

}
