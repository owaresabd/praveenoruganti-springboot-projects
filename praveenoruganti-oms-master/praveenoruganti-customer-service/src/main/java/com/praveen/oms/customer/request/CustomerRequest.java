package com.praveen.oms.customer.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerRequest{

	@NotBlank(message="firstname should have atleast 2 characters")
	@NotEmpty(message="firstname should have atleast 2 characters")
	private String firstname;
	@NotBlank(message="lastname should have atleast 1 character")
	@NotEmpty(message="lastname should have atleast 1 character")
	private String lastname;
	@Pattern(regexp="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$",message="Email address must include @ and proper domain")  
	private String email;
	@Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\\\d\\\\d)",message="creationdate must be in DD/MM/YYYY")
	private String creationdate;

	
}
