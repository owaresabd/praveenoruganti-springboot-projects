package com.praveen.oms.customer.errors;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

}
