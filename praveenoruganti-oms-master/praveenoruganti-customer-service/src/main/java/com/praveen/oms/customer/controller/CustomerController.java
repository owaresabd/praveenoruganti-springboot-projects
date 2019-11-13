package com.praveen.oms.customer.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.oms.customer.errors.ErrorDetails;
import com.praveen.oms.customer.model.Customer;
import com.praveen.oms.customer.request.CustomerRequest;
import com.praveen.oms.customer.service.CustomerService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "Customer Service", value = "CustomerController", description = "Controller for Customer Service")
@RestController
@RequestMapping("/customerservice")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@GetMapping("/customer")
	@ApiOperation(value = "Gets all the Customers")
	public ResponseEntity<List<Customer>> getCustomers() {
		return new ResponseEntity<List<Customer>>(customerService.getCustomers(), HttpStatus.OK);
	}

	@PostMapping("/customer")
	@ApiOperation(value = "Creates new customer")
	public ResponseEntity<?> createCustomer(
			@ApiParam("Customer information for a new customer to be created.") @Valid @RequestBody CustomerRequest customerRequest,
			Errors errors) {
		ErrorDetails errorDetails = new ErrorDetails();
		if (errors.hasErrors()) {
			errorDetails.setTimestamp(new Date());			
			errorDetails.setMessage(
					errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));

			return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Customer>(customerService.createCustomer(customerRequest), HttpStatus.CREATED);
		}
	}

}
