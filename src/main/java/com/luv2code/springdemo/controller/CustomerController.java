package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// need to inject the customer service
	
	@Autowired
	private CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomer(Model theModel) {
		// get customer from the DAO
		List<Customer> theCustomer = customerService.getCustomers();
		// add the customers to the model
		theModel.addAttribute("customers", theCustomer);
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String addCustomer(Model theModel) {
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer",theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		System.out.println(customer.getFirstName()+"\n"+customer.getLastName()+"\n"+customer.getEmail());
		// save the customer using a service
		customerService.saveCustomer(customer);
		return "redirect:/customer/list";
		
	}
	
	
	@GetMapping("/showFormForUpdate")
	public String showUpdateCustomerForm(@RequestParam("customerId") int theId, Model theModel) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int theId) {
		
		// delete the customer
		customerService.deleteCustomer(theId);
		return "redirect:/customer/list";
	}
}
