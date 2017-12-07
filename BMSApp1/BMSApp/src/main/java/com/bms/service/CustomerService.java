package com.bms.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.bms.vo.Customer;

@Service
public class CustomerService {
	
	//public String register(Customer customer);
	
		public void fillCustomerDetails(Customer customer){
			  customer.setAccountNumber(generateUniqueAccNumber());
			  customer.setCustomerId(generateUniqueCustomerId());
		  }
		  
		  private long generateUniqueAccNumber(){
			 long uniqueAccountNumber = (long) (Math.random() * 10000000000000000L);
			 return  uniqueAccountNumber;
		  }
		  
		  private String generateUniqueCustomerId() {
			  Random random = new Random();
			  String uniqueCustomerId = "RRR-"+random.nextInt(900);
			  return uniqueCustomerId;
		  }

}
