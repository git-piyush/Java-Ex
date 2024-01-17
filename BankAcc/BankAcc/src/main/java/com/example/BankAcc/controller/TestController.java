package com.example.BankAcc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/bank")
@RestController
public class TestController {

	@GetMapping("/test")
	public String Test() {
		return "Test";
	}
	
}
