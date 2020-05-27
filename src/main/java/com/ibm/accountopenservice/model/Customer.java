package com.ibm.accountopenservice.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Customer {

	private String id;
	@Id
	private String customerId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobileNumber;
	private String emailId;

}
