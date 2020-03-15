package com.midwesten.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.midwesten.demo.model.Customer;
import com.midwesten.demo.service.CustomerService;


@Controller
@RequestMapping(value = {"/bankingsolution/customer"})
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService=customerService;
	}
	
	@GetMapping(value = {"/list"})
    public ModelAndView listProducts() {
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customers = customerService.getAllCustomers(0, 10, "lastName");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customerSize",customers.size());
        modelAndView.setViewName("customer/list");
        return modelAndView;
    }
	
	@GetMapping(value = {"/new"})
    public String displayNewCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer/new";
    }
	
	@PostMapping(value = {"/new"})
    public String addNewCustomer(@Valid @ModelAttribute("customer")Customer customer, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            model.addAttribute("customer", customer);
            return "customer/new";
        }
        customerService.saveCustomer(customer);
        return "redirect:/bankingsolution/customer/list";
    }
	
	@GetMapping(value = {"/edit/{customerId}"})
	public String editCustomer(@PathVariable Long customerId, Model model) {
        Customer customer = customerService.getById(customerId);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customer/edit";
        }
        return "customer/list";
    }
	
	@PostMapping(value = {"/edit"})
    public String editCustomer(@Valid @ModelAttribute("customer") Customer customer,
                                     BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "customer/edit";
        }
        customer = customerService.updateCustomer(customer.getCustomerId(), customer);
        return "redirect:/bankingsolution/customer/list";
    }
	
	@GetMapping(value = {"/delete/{customerId}"})
	public String deleteCustomer(@PathVariable Long customerId, Model model) {
        customerService.deleteCustomer(customerId);
        return "redirect:/bankingsolution/customer/list";
    }
	
	@GetMapping(value = {"/search"})
    public ModelAndView searchCustomers(@RequestParam String searchString) {
        ModelAndView modelAndView = new ModelAndView();
        List<Customer> customers = customerService.searchCustomers(searchString);
        modelAndView.addObject("students", customers);
        modelAndView.addObject("searchString", searchString);
        modelAndView.addObject("customerSize", customers.size());
        modelAndView.setViewName("customer/list");
        return modelAndView;
    }
}
