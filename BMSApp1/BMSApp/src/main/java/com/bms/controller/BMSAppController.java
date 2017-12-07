package com.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bms.repository.CustomerRespository;
import com.bms.service.CustomerService;
import com.bms.vo.Customer;
import com.bms.vo.Response;
import com.bms.vo.Transaction;
import com.bms.vo.User;

@RestController
public class BMSAppController {
	
  @Autowired
   CustomerService customerService;	
  @Autowired
	CustomerRespository customerRespository;
	
  @RequestMapping("/home")
	public void home() {
		System.out.println(" home method called ");
	}
  
  
  @RequestMapping(value="/login", method=RequestMethod.POST, consumes = "application/json")
  @ResponseBody
  public Response login(@RequestBody User user ) {
	  Response response= new Response();
	  try{
		System.out.println(customerService+"  login method called" +user.getUsername());
		if(user.getUsername().equals("sathish")){
			String str=null;
			str.toString();
		}
		Customer cust= new Customer();
		cust.setName("Yasin");
		cust.setUsername("yasin");
		cust.setAccountNumber(0001001);
		response.setSuccess(true);
		response.setData(cust);
	  }catch(Exception ex){
			response.setSuccess(false);
			response.setData("Invalid Credentials");
	  }
	  return response;
  }
  
  @RequestMapping(value="/register", method=RequestMethod.POST, consumes = "application/json")
  @ResponseBody
  public Response register(@RequestBody Customer customer ) {
	  System.out.println(" register method called" +customer.getUsername());
	  Response response= new Response();
	  try{			
		//call next layer method
		 //String custId=customerService.register(customer);
		    customerService.fillCustomerDetails(customer);
		    customerRespository.insert(customer);
			//return custmr.getCustomerId();
		response.setSuccess(true);
		response.setData(null);
	  }catch(Exception ex){
			response.setSuccess(false);
			response.setData("Registration Failed. Please contact alpsupportteam@cts.com.");
	  }
	  return response;
  }
  
  @RequestMapping(value="/saveTransaction", method=RequestMethod.POST, consumes = "application/json")
  @ResponseBody
  public Response saveTransaction(@RequestBody Transaction transaction ) {
	  System.out.println(" saveTransaction method called" +transaction.getAccountNumber());
	  Response response= new Response();
	  try{			
		//call next layer method
		response.setSuccess(true);
		response.setData(null);
	  }catch(Exception ex){
			response.setSuccess(false);
			response.setData("Transaction Failed. Please contact alpsupportteam@cts.com.");
	  }
	  return response;
  }
  
  @RequestMapping(value="/viewStatements", method=RequestMethod.POST, consumes = "application/json")
  @ResponseBody
  public Response viewStatements(@RequestBody Customer customer ) {
	  System.out.println(" viewStatements method called" +customer.getUsername());
	  Response response= new Response();
	  try{			
		//call next layer method
		response.setSuccess(true);
		response.setData(null);
	  }catch(Exception ex){
			response.setSuccess(false);
			response.setData("Transaction Failed. Please contact alpsupportteam@cts.com.");
	  }
	  return response;
  }
}
