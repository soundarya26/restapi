package com.tavant.employeerestapi.model;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "accounts")

public class Account implements Comparable<Account> {
	  @Id
	  private Integer accountNumber ;
	  private double balance;
	  private String customerName ;
	  private String email ;
	  private String phoneNumber;
	@Override
	public int compareTo(Account o) {
		// TODO Auto-generated method stub
		return 0;
	}

}