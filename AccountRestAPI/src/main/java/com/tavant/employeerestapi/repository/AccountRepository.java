package com.tavant.employeerestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tavant.employeerestapi.model.Account;
@Repository
public interface AccountRepository  extends JpaRepository<Account, Integer>  {

}
