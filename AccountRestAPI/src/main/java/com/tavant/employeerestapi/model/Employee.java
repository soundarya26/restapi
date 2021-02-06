package com.tavant.employeerestapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "employees")
public class Employee implements Comparable<Employee> {
	
	
	
	
	@Id
	private Integer employeeNumber;
	@NotBlank(message = "first name should not be blank")
	private String firstName;
	//@Column(length=15)
	//@Size(max=20)
	@NotBlank(message = "last name should not be blank")
	private String lastName;
	@NotBlank(message="extension value has to be provided")
	//@Transient
	private String extension;
	@NotBlank(message="email should not be blank")
	@Email(message="email should be valid")
	private String email;
//	@ManyToOne
//	@JoinColumn(name = "officeCode")
	//@Column(length=25)
	//@NotNull(message="office code sholuld not be null")
	@Max(123)
	//@Min(120)
	private Integer officeCode;
	private Integer reportsTo;
	
	//@Column(length=15)
	//@Size(max=20)
	private String jobTitle;
	
	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
