package com.midwesten.demo.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.midwesten.demo.model.Customer;
import com.midwesten.demo.repository.CustomerRepository;
import com.midwesten.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		// TODO Auto-generated constructor stub
		this.customerRepository=customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers(Integer pageNo, Integer pageSize, String sortedBy) {
		// TODO Auto-generated method stub
		Pageable paging=PageRequest.of(pageNo, pageSize, Sort.by(sortedBy));
		Page<Customer> pagedResult = customerRepository.findAll(paging);
		if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Customer>();
        }
	}

	@Override
	public Customer updateCustomer(Long Id, Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.findById(Id)
                .map(customerToUpdate -> {
                	customerToUpdate.setCustomerNumber(customer.getCustomerNumber());
                	customerToUpdate.setDateOfBirth(customer.getDateOfBirth());
                	customerToUpdate.setEmail(customer.getEmail());
                	customerToUpdate.setFirstName(customer.getFirstName());
                	customerToUpdate.setLastName(customer.getLastName());
                	customerToUpdate.setMiddleName(customer.getMiddleName());
                	customerToUpdate.setContactPhoneNumber(customer.getContactPhoneNumber());
                return customerRepository.save(customerToUpdate);
               }).orElseGet(() -> {
                    return customerRepository.save(customer);
                });
	}

	@Override
	public void deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

	@Override
	public List<Customer> searchCustomers(String searchString) {
		// TODO Auto-generated method stub
		if(isNumeric(searchString)) {
			System.out.println("----------------------------------------------------");
			System.out.println(customerRepository.findByCustomerNumber(10002L));
			return customerRepository.findByCustomerNumber(Long.parseLong(searchString));
		}else if(isDate(searchString)) {
			return customerRepository.findByDateOfBirth(LocalDate.parse(searchString,DateTimeFormatter.ISO_DATE));
		}else {
			return customerRepository.findAllByFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrEmailContainingOrContactPhoneNumberOrderByLastName(searchString, searchString, searchString, searchString, searchString);
		}
	}

	private boolean isDate(String searchString) {
		// TODO Auto-generated method stub
		 boolean isParseableAsDate = false;
	        try {
	            LocalDate.parse(searchString, DateTimeFormatter.ISO_DATE);
	            isParseableAsDate = true;
	        } catch(Exception ex) {
	            if(ex instanceof DateTimeParseException) {
	                isParseableAsDate = false;
	            }
	        }
	        return isParseableAsDate;
	}

	private boolean isNumeric(String searchString) {
		// TODO Auto-generated method stub
		return  searchString.matches("-?\\d+(\\.\\d+)?");
	}

	@Override
	public Customer getById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

}
