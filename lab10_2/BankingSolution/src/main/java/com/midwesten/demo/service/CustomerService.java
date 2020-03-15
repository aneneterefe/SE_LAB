package com.midwesten.demo.service;

import java.util.List;


import com.midwesten.demo.model.Customer;


public interface CustomerService {

	public abstract List<Customer> getAllCustomers(Integer pageNo, Integer pageSize, String sortedBy);
	public abstract List<Customer> getAllCustomers();
    public abstract Customer saveCustomer(Customer customer);
    public abstract Customer updateCustomer(Long Id, Customer customer);
    public abstract void deleteCustomer(Long Id);
    public abstract List<Customer> searchCustomers(String searchString);
    public abstract Customer getById(Long id);
	
}
