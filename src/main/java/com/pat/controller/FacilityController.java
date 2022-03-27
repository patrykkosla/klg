package com.pat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/facilities")
public class FacilityController {

	
	@GetMapping
	public String testController() {
		return "test jest oki";
	}
	
	
	//test tt
	
}
