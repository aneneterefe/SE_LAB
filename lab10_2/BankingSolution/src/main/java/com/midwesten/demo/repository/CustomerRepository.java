package com.midwesten.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.midwesten.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findAllByFirstNameContainingOrMiddleNameContainingOrLastNameContainingOrEmailContainingOrContactPhoneNumberOrderByLastName(
			String fname,
            String mname,
            String lname,
            String email,
            String contactPhoneNumber);
	List<Customer> findByDateOfBirth(LocalDate dateOfBirth);
	List<Customer> findByCustomerNumber(Long customerNumber);
}
