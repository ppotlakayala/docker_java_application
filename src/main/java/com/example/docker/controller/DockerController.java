package com.example.docker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class DockerController {
	
	@GetMapping("/add")
	public ResponseEntity<String> addCustomer(@RequestBody String customer){
		
		System.out.println("In CustomerController class and addCustomer method");
		if(customer!=null) {
			return ResponseEntity.ok("customer successfully added");
		}
		return ResponseEntity.ok("unable to add customer");
	}

}
