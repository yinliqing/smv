package com.ylq.msv.blog.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ylq.msv.blog.bean.User;

@RestController
public class UserController {

	private static final String template = "BeiJing, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@PostMapping("/user")
	public User post(@RequestBody User user) {
		System.out.println("firstName: " + user.firstName() + ", lastName: " + user.lastName());
		return new User(counter.incrementAndGet(), user.firstName(), user.lastName(), 
				String.format(template, user.lastName()), String.format(template, user.lastName()), 
				String.format(template, user.firstName()));
	}
}
