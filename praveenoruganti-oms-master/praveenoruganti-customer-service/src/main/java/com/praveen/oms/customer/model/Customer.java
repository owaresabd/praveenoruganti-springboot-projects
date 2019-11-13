package com.praveen.oms.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@ApiModel(description = "This model is to create a customer")
@Entity
@Data
@SuperBuilder
@NoArgsConstructor
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;

	@ApiModelProperty(notes = "firstname should have atleast 2 characters", example = "Praveen", required = true)
	@Column(name="FIRST_NAME",length = 50, nullable = false)
	private String firstname;

	@ApiModelProperty(notes = "lastname should have atleast 2 characters", example = "O", required = true)
	@Column(name="LAST_NAME",length = 50, nullable = false)
	private String lastname;

	@ApiModelProperty(name="EMAIL",notes = "email must include @ and proper domain", example = "op@gmail.com", required = true)
	@Column(length = 50, nullable = false)
	private String email;
	
	@ApiModelProperty(name="CREATIONDATE",notes = "creationdate must be in DD/MM/YYYY", example = "14/09/1985", required = true)
	@Column(name="CREATION_DATE",length = 20, nullable = false)
	private String creationdate;

}
