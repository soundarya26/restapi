package com.tavant.employeerestapi.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tavant.employeerestapi.exception.AccountNotFoundException;
import com.tavant.employeerestapi.exception.EmptyData;
import com.tavant.employeerestapi.exception.NoDataFoundException;
import com.tavant.employeerestapi.model.Account;
import com.tavant.employeerestapi.repository.AccountRepository;



@RestController
@RequestMapping("/api/account")

public class AccountController {
	@Autowired
	AccountRepository accountRepository;

	@GetMapping
	
	public String getAccount() {
	return "hello";
}

@GetMapping("/all")

public ResponseEntity<?> getAllAccounts() throws NoDataFoundException, AccountNotFoundException 
{
	Optional<List<Account>> optional = Optional.of(accountRepository.findAll());
	
	if(optional.isEmpty())
	{
		throw new AccountNotFoundException("record not found");
		
	}
	else {
		return ResponseEntity.ok(optional.get());	
	}

}

@GetMapping("/{id}")


public ResponseEntity<?> getAccountById(@PathVariable("id")Integer id) throws AccountNotFoundException {
	Optional<Account> optional = accountRepository.findById(id);
	 
	if(optional.isPresent()) {
		return ResponseEntity.ok(optional.get());
	}  
	else {

		throw new AccountNotFoundException("no record found");
	}
	
}

@PostMapping  //transforming JSON java object
//jackson api will take care implicity
public Account addAccount(@RequestBody @Valid Account account) throws EmptyData {
	
	
		return accountRepository.save(account);

	
}


@DeleteMapping("/{id}")
public Map<String, Boolean> deleteAccount(@PathVariable(value = "id") Integer accountId)
  throws AccountNotFoundException {
 Account account = accountRepository.findById(accountId)
   .orElseThrow(() -> new AccountNotFoundException("Account not found for this id :: " + accountId));

 accountRepository.delete(account);
 Map<String, Boolean> response = new HashMap<>();
 response.put("deleted", Boolean.TRUE);
 return response;
}
@PutMapping("/{id}")
public ResponseEntity<Account> updateAccount(@PathVariable(value = "id") Integer accountId,
  @Valid @RequestBody Account accountDetails) throws AccountNotFoundException {
 Account account = accountRepository.findById(accountId)
 .orElseThrow(() -> new AccountNotFoundException("Account not found for this id :: " + accountId));

 account.setEmail(accountDetails.getEmail());
 account.setCustomerName(accountDetails.getCustomerName());

 final Account updatedAccount = accountRepository.save(account);
 return ResponseEntity.ok(updatedAccount);
}
	

}
