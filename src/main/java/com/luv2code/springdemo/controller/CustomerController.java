package com.luv2code.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping("/list")
	public String listCustomer(Model theModel) {
		System.out.println("FIRST REQUEST RECEIVED");
		return "list-customers";
	}
	
}
