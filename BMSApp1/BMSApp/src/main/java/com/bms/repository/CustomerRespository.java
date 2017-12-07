package com.bms.repository;
import java.util.List;

import org.springframework.data.annotation.Persistent;
import org.springframework.data.repository.CrudRepository;

import com.bms.vo.Customer;




@Persistent
public interface CustomerRespository extends CrudRepository<Customer, String>{
	Customer findByFirstName(String firstName);
	List<Customer> findByLastName(String lastName);
}